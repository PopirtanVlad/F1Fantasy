package ro.sd.a2.mapper;

import ro.sd.a2.dto.DriverTeamDto;
import ro.sd.a2.entity.DriverTeam;

public class DriverTeamMapper {
    public static DriverTeamDto entityToDto(DriverTeam driverTeam) {
        DriverTeamDto driverTeamDto=new DriverTeamDto();
        driverTeamDto.setDriver_team_id(driverTeam.getDriver_team_id());
        driverTeamDto.setDriver_id(driverTeam.getDriver_id());
        driverTeamDto.setTeam_id(driverTeam.getTeam_id());
        return driverTeamDto;
    }

    public static DriverTeam dtoToEntity(DriverTeamDto driverTeamDto){
        DriverTeam driverTeam=new DriverTeam();
        driverTeam.setDriver_team_id(driverTeamDto.getDriver_team_id());
        driverTeam.setDriver_id(driverTeamDto.getDriver_id());
        driverTeam.setTeam_id(driverTeamDto.getTeam_id());
        return driverTeam;
    }
}
