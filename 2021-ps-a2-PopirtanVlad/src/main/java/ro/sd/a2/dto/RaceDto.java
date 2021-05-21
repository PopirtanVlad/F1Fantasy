package ro.sd.a2.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

public class RaceDto {

    private String race_id;

    private String race_location;

    private String race_date;

    private String race_name;

    public RaceDto() {
    }

    public RaceDto(String race_location) {
        this.race_location = race_location;
        this.race_id= UUID.randomUUID().toString();
    }

    public String getRace_name() {
        return race_name;
    }

    public void setRace_name(String race_name) {
        this.race_name = race_name;
    }

    public String getRace_date() {
        return race_date;
    }

    public void setRace_date(String race_date) {
        this.race_date = race_date;
    }

    public String getRace_id() {
        return race_id;
    }

    public void setRace_id(String race_id) {
        this.race_id = race_id;
    }

    public String getRace_location() {
        return race_location;
    }

    public void setRace_location(String race_location) {
        this.race_location = race_location;
    }
}
