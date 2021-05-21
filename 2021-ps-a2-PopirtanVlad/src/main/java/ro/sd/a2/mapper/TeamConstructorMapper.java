package ro.sd.a2.mapper;

import ro.sd.a2.dto.TeamConstructorDto;
import ro.sd.a2.entity.TeamConstructor;

public class TeamConstructorMapper {
    public static TeamConstructorDto entityToDto(TeamConstructor teamConstructor){
        TeamConstructorDto teamConstructorDto=new TeamConstructorDto();
        teamConstructorDto.setTeam_constructor_id(teamConstructor.getTeam_constructor_id());
        teamConstructorDto.setConstructor_id(teamConstructor.getConstructor_id());
        teamConstructorDto.setTeam_id(teamConstructor.getTeam_id());
        return teamConstructorDto;
    }

    public static TeamConstructor dtoToEntity(TeamConstructorDto teamConstructorDto){
        TeamConstructor teamConstructor=new TeamConstructor();
        teamConstructor.setTeam_constructor_id(teamConstructorDto.getTeam_constructor_id());
        teamConstructor.setConstructor_id(teamConstructorDto.getConstructor_id());
        teamConstructor.setTeam_id(teamConstructorDto.getTeam_id());
        return teamConstructor;
    }

}
