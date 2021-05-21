package ro.sd.a2.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

public class TeamConstructorDto {

    private String team_constructor_id;

    private String constructor_id;

    private String team_id;

    public TeamConstructorDto() {
    }

    public String getTeam_constructor_id() {
        return team_constructor_id;
    }

    public void setTeam_constructor_id(String team_constructor_id) {
        this.team_constructor_id = team_constructor_id;
    }

    public String getConstructor_id() {
        return constructor_id;
    }

    public void setConstructor_id(String constructor_id) {
        this.constructor_id = constructor_id;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }
}
