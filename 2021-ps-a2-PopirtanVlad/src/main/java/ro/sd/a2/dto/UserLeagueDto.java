package ro.sd.a2.dto;


public class UserLeagueDto {

    private String user_league_id;

    private String user_id;

    private String league_id;

    private int ranking;

    public UserLeagueDto() {
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

    public String getLeague_id() {
        return league_id;
    }

    public void setLeague_id(String league_id) {
        this.league_id = league_id;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}
