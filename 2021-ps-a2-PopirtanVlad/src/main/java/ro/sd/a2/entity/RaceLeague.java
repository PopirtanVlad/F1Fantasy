package ro.sd.a2.entity;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RaceLeague")
public class RaceLeague {
    @Id
    private int nr_of_race;

    @Column
    private String race_id;

    @Column
    private String league_id;

    public RaceLeague() {
    }

    public int getNr_of_race() {

        return nr_of_race;
    }

    public void setNr_of_race(int nr_of_race) {
        this.nr_of_race = nr_of_race;
    }

    public String getRace_id() {
        return race_id;
    }

    public void setRace_id(String race_id) {
        this.race_id = race_id;
    }

    public String getLeague_id() {
        return league_id;
    }

    public void setLeague_id(String league_id) {
        this.league_id = league_id;
    }
}
