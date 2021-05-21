package ro.sd.a2.mapper;

import ro.sd.a2.dto.UserLeagueDto;
import ro.sd.a2.entity.UserLeague;

public class UserLeagueMapper {
    public static UserLeagueDto entityToDto(UserLeague userLeague){
        UserLeagueDto userLeagueDto=new UserLeagueDto();
        userLeagueDto.setUser_league_id(userLeague.getUser_league_id());
        userLeagueDto.setRanking(userLeague.getRanking());
        userLeagueDto.setUser_id(userLeague.getUser_id());
        userLeagueDto.setLeague_id(userLeague.getUser_league());
        return  userLeagueDto;
    }

    public static UserLeague dtoToEntity(UserLeagueDto userLeagueDto){
        UserLeague userLeague=new UserLeague();
        userLeague.setUser_league_id(userLeagueDto.getUser_league_id());
        userLeague.setRanking(userLeagueDto.getRanking());
        userLeague.setUser_id(userLeagueDto.getUser_id());
        userLeague.setUser_league(userLeagueDto.getLeague_id());
        return  userLeague;
    }
}
