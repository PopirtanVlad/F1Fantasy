package ro.sd.a2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.dto.DriverTeamDto;
import ro.sd.a2.entity.DriverTeam;
import ro.sd.a2.mapper.DriverTeamMapper;
import ro.sd.a2.service.repository.DriverTeamRepository;

import java.util.List;
import java.util.ArrayList;

@Service
public class DriverTeamService {
    @Autowired
    private DriverTeamRepository driverTeamRepository;

    public List<DriverTeamDto> getAllDriverTeams(){
        List<DriverTeamDto> driverTeamDtos=new ArrayList<>();
        for(DriverTeam d:driverTeamRepository.findAll()){
            driverTeamDtos.add(DriverTeamMapper.entityToDto(d));
        }
        return driverTeamDtos;
    }

    public void addNewDriverTeam(DriverTeamDto driverTeamDto){
        driverTeamRepository.save(DriverTeamMapper.dtoToEntity(driverTeamDto));
    }
}
