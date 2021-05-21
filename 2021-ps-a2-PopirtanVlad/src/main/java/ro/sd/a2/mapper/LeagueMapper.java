package ro.sd.a2.mapper;

import ro.sd.a2.dto.LeagueDto;
import ro.sd.a2.entity.League;
import ro.sd.a2.factory.LeagueFactory;

public class LeagueMapper {
    public static LeagueDto entityToDto(League league){
        LeagueDto leagueDto=new LeagueDto();
        leagueDto.setLeague_id(league.getLeague_id());
        leagueDto.setLeague_name(league.getLeague_name());
        leagueDto.setLeague_cover_url(league.getLeague_cover_url());
        leagueDto.setLeague_image_url(league.getLeague_image_url());
        return leagueDto;
    }

    public static League dtoToEntity(LeagueDto leagueDto){
        League league= LeagueFactory.generateLeague();
        league.setLeague_id(leagueDto.getLeague_id());
        league.setLeague_name(leagueDto.getLeague_name());
        league.setLeague_cover_url(leagueDto.getLeague_cover_url());
        league.setLeague_image_url(leagueDto.getLeague_image_url());
        return  league;
    }
}
