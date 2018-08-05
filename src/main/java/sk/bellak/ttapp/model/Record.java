package sk.bellak.ttapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Record {
    private String email;
    private String start;
    private String end;

    public Record() {
    }

    public Record(String email, String start, String end) {
        this.email = email;
        this.start = start;
        this.end = end;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Record{" +
                "email='" + email + '\'' +
                ", start=" + start +
                '}';
    }
}
