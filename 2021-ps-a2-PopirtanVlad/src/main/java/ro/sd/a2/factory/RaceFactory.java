package ro.sd.a2.factory;

import ro.sd.a2.entity.Race;

import java.util.UUID;

public class RaceFactory {

    public static Race generateRace(){
        return Race.builder().race_id(UUID.randomUUID().toString()).build();
    }

}
