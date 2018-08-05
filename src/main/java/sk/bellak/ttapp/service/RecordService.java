package sk.bellak.ttapp.service;

import java.util.List;

import sk.bellak.ttapp.model.Record;


public interface RecordService {

    void saveRecord(Record record);

    List<Record> findByEmail(String email);
}
