package ro.sd.a2.factory;

import ro.sd.a2.entity.League;

import java.util.UUID;

public class LeagueFactory {

    public static League generateLeague(){
        return League.builder().league_id(UUID.randomUUID().toString()).build();
    }
}
