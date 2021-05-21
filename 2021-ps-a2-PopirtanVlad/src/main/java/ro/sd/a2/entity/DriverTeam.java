package ro.sd.a2.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DriverTeam")
public class DriverTeam {

    @Id
    private String driver_team_id;

    @Column
    private String driver_id;

    @Column
    private String team_id;

    public DriverTeam() {
    }

    public String getDriver_team_id() {
        return driver_team_id;
    }

    public void setDriver_team_id(String driver_team_id) {
        this.driver_team_id = driver_team_id;
    }

    public String getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(String driver_id) {
        this.driver_id = driver_id;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }
}
