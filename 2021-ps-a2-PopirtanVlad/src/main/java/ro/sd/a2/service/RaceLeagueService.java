package ro.sd.a2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.dto.RaceLeagueDto;
import ro.sd.a2.entity.RaceLeague;
import ro.sd.a2.mapper.RaceLeagueMapper;
import ro.sd.a2.service.repository.RaceLeagueRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class RaceLeagueService {

    @Autowired
    private RaceLeagueRepository raceLeagueRepository;

    public List<RaceLeagueDto> getAllRaceLeagues(){
        List<RaceLeagueDto> raceLeagueDtoList=new ArrayList<>();
        for(RaceLeague r:raceLeagueRepository.findAll()){
            raceLeagueDtoList.add(RaceLeagueMapper.entityToDto(r));
        }
        return raceLeagueDtoList;
    }

    public void addRaceLeague(RaceLeagueDto raceLeagueDto){
        raceLeagueRepository.save(RaceLeagueMapper.dtoToEntity(raceLeagueDto));
    }

}
