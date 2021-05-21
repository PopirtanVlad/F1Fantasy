package ro.sd.a2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.dto.ConstructorDto;
import ro.sd.a2.dto.DriverDto;
import ro.sd.a2.dto.RaceDto;
import ro.sd.a2.entity.Constructor;
import ro.sd.a2.entity.Driver;
import ro.sd.a2.mapper.ConstructorMapper;
import ro.sd.a2.mapper.DriverMapper;
import ro.sd.a2.mapper.RaceMapper;
import ro.sd.a2.service.repository.ConstructorRepository;
import ro.sd.a2.service.repository.DriverRepository;
import ro.sd.a2.service.repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private ConstructorRepository constructorRepository;

    /**Metoda ce returneaza toti pilotii din baza de date.
     * @return o lista cu toti pilotii
     */
    public List<DriverDto> getAllDrivers(){
        List<DriverDto> driverDtos=new ArrayList<>();;
        for(Driver d:driverRepository.findAll()){
            driverDtos.add(DriverMapper.entityToDto(d));
        }
        return driverDtos;
    }
    /**Metoda ce returneaza un pilot dupa id*/
    public DriverDto findDriverById(String id){
        return DriverMapper.entityToDto(driverRepository.findById(id).get());
    }

    /**
     * Metoda ce sterge un pilot din baza de date, si totodata sterge pilotul din constructorul din care facea parte.
     * @param driverDto Pilotul ce trebuie sters.
     */
    public void deleteDriver(DriverDto driverDto){
        Driver driver=DriverMapper.dtoToEntity(driverDto);
        Constructor constructor=constructorRepository.findConstructorById(driverDto.getDriver_constructor_id());
        constructor.removeDriver(driver);
        driverRepository.delete(DriverMapper.dtoToEntity(driverDto));
    }

    /**
     * Metoda ce adauga un pilot in baza de date, dar si in constructor. Acesta poate fi adaugat doar daca in constructor nu
     * exista deja 2 piloti.
     * @param driverDto Pilotul ce trebiue adaugat.
     */
    public void addDriver(DriverDto driverDto){
        Driver driver=DriverMapper.dtoToEntity(driverDto);
        Constructor constructor=constructorRepository.findConstructorById(driverDto.getDriver_constructor_id());
        if(constructor.getDrivers().size()<2) {
            constructor.addDrivers(driver);
            driverRepository.save(driver);
        }
        else{
            System.out.println("Constructor already full");
        }
    }
}
