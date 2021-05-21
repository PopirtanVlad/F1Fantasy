package ro.sd.a2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.dto.LeagueDto;
import ro.sd.a2.entity.League;
import ro.sd.a2.mapper.LeagueMapper;
import ro.sd.a2.service.repository.LeagueRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class LeagueService {

    @Autowired
    private LeagueRepository leagueRepository;

    public List<LeagueDto> getAllLeagues(){
        List<LeagueDto> leagueDtos=new ArrayList<>();
        for(League l:leagueRepository.findAll()){
            leagueDtos.add(LeagueMapper.entityToDto(l));
        }
        return leagueDtos;
    }

    public void addLeague(LeagueDto leagueDto){
        leagueRepository.save(LeagueMapper.dtoToEntity(leagueDto));
    }
}
