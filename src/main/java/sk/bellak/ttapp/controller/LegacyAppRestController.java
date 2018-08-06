package sk.bellak.ttapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import sk.bellak.ttapp.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import sk.bellak.ttapp.service.RecordService;

@RestController
public class LegacyAppRestController {

    @Autowired
    RecordService recordService;  //Service which will do all data retrieval/manipulation work


    //-------------------Create a Record--------------------------------------------------------
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/record/", method = RequestMethod.POST)
    public ResponseEntity<Void> createRecord(@RequestBody Record record, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Record " + record.getEmail());
        recordService.saveRecord(record);

        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Find records by email--------------------------------------------------------
    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/record/{email:.+}", method = RequestMethod.GET)
    public ResponseEntity<List<Record>> getRecord(@PathVariable("email") String email) {
        System.out.println("Fetching Record with email " + email);
        List<Record> records = recordService.findByEmail(email);
        if (records == null) {
            System.out.println("Records with email " + email + " not found");
            return new ResponseEntity<List<Record>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Record>>(records, HttpStatus.OK);
    }

}