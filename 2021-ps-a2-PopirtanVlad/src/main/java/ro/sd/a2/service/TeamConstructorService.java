package ro.sd.a2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.dto.TeamConstructorDto;
import ro.sd.a2.entity.TeamConstructor;
import ro.sd.a2.mapper.TeamConstructorMapper;
import ro.sd.a2.service.repository.TeamConstructorRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class TeamConstructorService {

    @Autowired
    private TeamConstructorRepository teamConstructorRepository;

    public List<TeamConstructorDto> getAllTeamConstructors(){
        List<TeamConstructorDto> teamConstructorDtoList=new ArrayList<>();
        for(TeamConstructor t:teamConstructorRepository.findAll()){
            teamConstructorDtoList.add(TeamConstructorMapper.entityToDto(t));
        }
        return teamConstructorDtoList;
    }

    public void addTeamConstructor(TeamConstructorDto teamConstructorDto){
        teamConstructorRepository.save(TeamConstructorMapper.dtoToEntity(teamConstructorDto));
    }

}
