package sk.bellak.ttapp.service;

import java.util.ArrayList;
import java.util.List;

import sk.bellak.ttapp.model.Record;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service("recordService")
public class RecordServiceImpl implements RecordService {

    private static final String url = "http://192.168.99.100:8088/records";


    private static List<Record> records;


    public List<Record> findByEmail(String email) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Record[]> responseEntity;
        if (email != null) {
            responseEntity = restTemplate.getForEntity(url + "?email=" + email + "&length=10", Record[].class);
        } else {
            responseEntity = restTemplate.getForEntity(url + "?offset=0&length=10", Record[].class);
        }
        Record[] objects = responseEntity.getBody();
        records = new ArrayList<Record>();
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null) {
                Record record = new Record(objects[i].getEmail(), objects[i].getStart(), objects[i].getEnd());
                records.add(record);
            }
        }

        return records;
    }


    public void saveRecord(Record record) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("email", record.getEmail());
        map.add("start", record.getStart());
        map.add("end", record.getEnd());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
    }


}
