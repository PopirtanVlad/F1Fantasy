package ro.sd.a2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.dto.UserLeagueDto;
import ro.sd.a2.entity.UserLeague;
import ro.sd.a2.mapper.UserLeagueMapper;
import ro.sd.a2.service.repository.UserLeagueRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserLeagueService {

    @Autowired
    private UserLeagueRepository userLeagueRepository;

    public List<UserLeagueDto> getAlluserLeagues(){
        List<UserLeagueDto> userLeagues=new ArrayList<>();
        for(UserLeague u:userLeagueRepository.findAll()){
            userLeagues.add(UserLeagueMapper.entityToDto(u));
        }
        return userLeagues;
    }

    public void addUserLeague(UserLeagueDto userLeagueDto){
        userLeagueRepository.save(UserLeagueMapper.dtoToEntity(userLeagueDto));
    }
}
