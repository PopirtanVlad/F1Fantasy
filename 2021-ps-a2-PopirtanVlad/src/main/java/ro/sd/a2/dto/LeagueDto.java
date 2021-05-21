package ro.sd.a2.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


public class LeagueDto {

    private String league_id;

    private String league_name;

    private String league_image_url;

    private String league_cover_url;

    public LeagueDto() {
    }

    public String getLeague_id() {
        return league_id;
    }

    public void setLeague_id(String league_id) {
        this.league_id = league_id;
    }

    public String getLeague_name() {
        return league_name;
    }

    public void setLeague_name(String league_name) {
        this.league_name = league_name;
    }

    public String getLeague_image_url() {
        return league_image_url;
    }

    public void setLeague_image_url(String league_image_url) {
        this.league_image_url = league_image_url;
    }

    public String getLeague_cover_url() {
        return league_cover_url;
    }

    public void setLeague_cover_url(String league_cover_url) {
        this.league_cover_url = league_cover_url;
    }
}
