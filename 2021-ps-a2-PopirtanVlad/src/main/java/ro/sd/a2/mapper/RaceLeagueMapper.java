package ro.sd.a2.mapper;

import ro.sd.a2.dto.RaceLeagueDto;
import ro.sd.a2.entity.RaceLeague;

public class RaceLeagueMapper {
    public static RaceLeagueDto entityToDto(RaceLeague raceLeague){
        RaceLeagueDto raceLeagueDto=new RaceLeagueDto();
        raceLeagueDto.setNr_of_race(raceLeague.getNr_of_race());
        raceLeagueDto.setLeague_id(raceLeague.getLeague_id());
        raceLeagueDto.setRace_id(raceLeague.getRace_id());
        return  raceLeagueDto;
    }

    public static RaceLeague dtoToEntity(RaceLeagueDto raceLeagueDto){
        RaceLeague raceLeague=new RaceLeague();
        raceLeague.setNr_of_race(raceLeagueDto.getNr_of_race());
        raceLeague.setLeague_id(raceLeagueDto.getLeague_id());
        raceLeague.setRace_id(raceLeagueDto.getRace_id());
        return raceLeague;
    }
}
