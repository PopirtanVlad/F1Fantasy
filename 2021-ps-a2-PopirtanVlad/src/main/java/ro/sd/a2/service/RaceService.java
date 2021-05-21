package ro.sd.a2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.dto.RaceDto;
import ro.sd.a2.entity.Race;
import ro.sd.a2.mapper.RaceMapper;
import ro.sd.a2.service.repository.RaceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RaceService {
    private static final Logger log= LoggerFactory.getLogger(UserService.class);

    @Autowired
    private RaceRepository raceRepository;

    public void addRace(RaceDto raceDto){
        raceRepository.save(RaceMapper.dtoToEntity(raceDto));
    }

    public RaceDto findRaceById(String id){
        return RaceMapper.entityToDto(raceRepository.findById(id).get());
    }

    public void deleteRace(RaceDto raceDto){
        raceRepository.delete(RaceMapper.dtoToEntity(raceDto));
    }

    public List<RaceDto> getAllRaces(){
        List<RaceDto> raceDtos=new ArrayList<>();
        for(Race r:raceRepository.findAll()){
            raceDtos.add(RaceMapper.entityToDto(r));
        }
        return raceDtos;
    }

}
