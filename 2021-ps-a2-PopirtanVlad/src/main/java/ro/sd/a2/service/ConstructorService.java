package ro.sd.a2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.dto.ConstructorDto;
import ro.sd.a2.dto.RaceDto;
import ro.sd.a2.entity.Constructor;
import ro.sd.a2.mapper.ConstructorMapper;
import ro.sd.a2.mapper.RaceMapper;
import ro.sd.a2.service.repository.ConstructorRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class ConstructorService {

    @Autowired
    private ConstructorRepository constructorRepository;


    /**Metoda ce returneaza toti constructorii din baza de date.
     * @return o lista cu toti constructorii
     */
    public List<ConstructorDto> getAllConstructors(){
        List<ConstructorDto> constructorDtos=new ArrayList<>();
        for(Constructor c:constructorRepository.findAll()){
            constructorDtos.add(ConstructorMapper.entityToDto(c));
        }
        return constructorDtos;
    }

    /**Metoda ce returneaza un constructor dupa id-ul sau.
     */
    public ConstructorDto findConstructorById(String id){
        return ConstructorMapper.entityToDto(constructorRepository.findById(id).get());
    }
    /**Metoda ce sterge constructorul*/
    public void deleteConstructor(ConstructorDto constructorDto){
        constructorRepository.delete(ConstructorMapper.dtoToEntity(constructorDto));
    }

    /**Metoda ce adauga un constructor*/
    public void addConstructor(ConstructorDto constructorDto){
        constructorRepository.save(ConstructorMapper.dtoToEntity(constructorDto));
    }
}
