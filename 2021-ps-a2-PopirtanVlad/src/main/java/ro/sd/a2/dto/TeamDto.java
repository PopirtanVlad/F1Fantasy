package ro.sd.a2.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


public class TeamDto {

    private String team_id;

    private String team_name;

    private float team_budget;

    private String user_id;

    private int team_points;

    public TeamDto() {
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public float getTeam_budget() {
        return team_budget;
    }

    public void setTeam_budget(float team_budget) {
        this.team_budget = team_budget;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getTeam_points() {
        return team_points;
    }

    public void setTeam_points(int team_points) {
        this.team_points = team_points;
    }
}
