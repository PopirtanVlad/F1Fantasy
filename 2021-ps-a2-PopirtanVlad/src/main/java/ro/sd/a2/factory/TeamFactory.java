package ro.sd.a2.factory;

import ro.sd.a2.entity.Team;

import java.util.UUID;

public class TeamFactory {

    public static Team generateTeam(){
        return Team.builder().team_id(UUID.randomUUID().toString()).build();
    }

}
