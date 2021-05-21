package ro.sd.a2.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import ro.sd.a2.dto.TeamDto;
import ro.sd.a2.entity.Team;
import ro.sd.a2.factory.TeamFactory;
import ro.sd.a2.service.TeamService;
import ro.sd.a2.service.UserService;

public class TeamMapper {

    @Autowired
    private static UserService userService;

    public static TeamDto entityToDto(Team team){
        TeamDto teamDto=new TeamDto();
        teamDto.setTeam_id(team.getTeam_id());
        teamDto.setTeam_name(team.getTeam_name());
        teamDto.setTeam_budget(team.getTeam_budget());
        teamDto.setTeam_points(team.getTeam_points());
        teamDto.setUser_id(team.getUser().getUser_id());
        return teamDto;
    }

    public static Team dtoToEntity(TeamDto teamDto){
        Team team= TeamFactory.generateTeam();
        team.setTeam_id(teamDto.getTeam_id());
        team.setTeam_name(teamDto.getTeam_name());
        team.setTeam_budget(teamDto.getTeam_budget());
        team.setTeam_points(teamDto.getTeam_points());
        team.setUser(UserMapper.dtoToEntity(userService.findUserById(teamDto.getUser_id())));
        return team;
    }

}
