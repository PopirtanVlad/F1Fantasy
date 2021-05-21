package ro.sd.a2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.dto.TeamDto;
import ro.sd.a2.entity.Team;
import ro.sd.a2.mapper.TeamMapper;
import ro.sd.a2.service.repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public List<TeamDto> getAllTeams(){
        List<TeamDto> teamDtos=new ArrayList<>();
        for(Team t:teamRepository.findAll()){
            teamDtos.add(TeamMapper.entityToDto(t));
        }
        return teamDtos;
    }

    public void addTeam(TeamDto teamDto){
        teamRepository.save(TeamMapper.dtoToEntity(teamDto));
    }
}
