package ro.sd.a2.entity;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserLeague")
public class UserLeague {
    @Id
    private String user_league_id;

    @Column
    private String user_id;

    @Column
    private String league_id;

    @Column
    private int ranking;

    public UserLeague() {
    }

    public String getUser_league_id() {
        return user_league_id;
    }

    public void setUser_league_id(String user_league_id) {
        this.user_league_id = user_league_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_league() {
        return league_id;
    }

    public void setUser_league(String user_league) {
        this.league_id = user_league;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}
