package ro.sd.a2.mapper;

import ro.sd.a2.dto.ConstructorDto;
import ro.sd.a2.entity.Constructor;
import ro.sd.a2.factory.ConstructorFactory;

public class ConstructorMapper {
    public static ConstructorDto entityToDto(Constructor constructor){
        ConstructorDto constructorDto=new ConstructorDto();
        constructorDto.setConstructor_id(constructor.getConstructor_id());
        constructorDto.setConstructor_name(constructor.getConstructor_name());
        constructorDto.setConstructor_price(constructor.getConstructor_price());
        constructorDto.setConstructor_points(constructor.getConstructor_points());
        return constructorDto;
    }

    public static Constructor dtoToEntity(ConstructorDto constructorDto){
        Constructor constructor= ConstructorFactory.generateCosntructor();
        constructor.setConstructor_id(constructorDto.getConstructor_id());
        constructor.setConstructor_name(constructorDto.getConstructor_name());
        constructor.setConstructor_price(constructorDto.getConstructor_price());
        constructor.setConstructor_points(constructorDto.getConstructor_points());
        return constructor;
    }

}
