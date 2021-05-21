package ro.sd.a2.mapper;

import ro.sd.a2.dto.RaceDto;
import ro.sd.a2.entity.Race;
import ro.sd.a2.factory.RaceFactory;

public class RaceMapper {

    public static RaceDto entityToDto(Race race){
        RaceDto raceDto=new RaceDto();
        raceDto.setRace_id(race.getRace_id());
        raceDto.setRace_location(race.getRace_location());
        raceDto.setRace_date(race.getRace_date());
        raceDto.setRace_name(race.getRace_name());
        return  raceDto;
    }

    public static Race dtoToEntity(RaceDto raceDto){
        Race race= RaceFactory.generateRace();
        race.setRace_id(raceDto.getRace_id());
        race.setRace_location(raceDto.getRace_location());
        race.setRace_date(raceDto.getRace_date());
        race.setRace_name(raceDto.getRace_name());
        return race;
    }
}
