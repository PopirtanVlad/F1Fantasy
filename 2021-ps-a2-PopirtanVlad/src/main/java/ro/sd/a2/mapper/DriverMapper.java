package ro.sd.a2.mapper;

import ro.sd.a2.dto.DriverDto;
import ro.sd.a2.entity.Driver;
import ro.sd.a2.factory.DriverFactory;
import ro.sd.a2.service.ConstructorService;


public class DriverMapper {

    private static ConstructorService constructorService=new ConstructorService();

    public static DriverDto entityToDto(Driver driver){
        DriverDto driverDto=new DriverDto();
        driverDto.setDriver_id(driver.getDriver_id());
        driverDto.setDriver_age(driver.getDriver_age());
        driverDto.setDriver_nr(driver.getDriver_nr());
        driverDto.setDriver_name(driver.getDriver_name());
        driverDto.setDriver_points(driver.getDriver_points());
        driverDto.setDriver_constructor_id(driver.getConstructor().getConstructor_id());
        driverDto.setDriver_nationality(driver.getDriver_nationality());
        driverDto.setDriver_price(driver.getDriver_price());
        driverDto.setDriver_standing(driver.getDriver_standing());
        return driverDto;
    }

    public static Driver dtoToEntity(DriverDto driverDto){
        Driver driver= DriverFactory.generateDriver();
        driver.setDriver_id(driverDto.getDriver_id());
        driver.setDriver_age(driverDto.getDriver_age());
        driver.setDriver_nr(driverDto.getDriver_nr());
        driver.setDriver_name(driverDto.getDriver_name());
        driver.setDriver_points(driverDto.getDriver_points());
        driver.setDriver_nationality(driverDto.getDriver_nationality());
        driver.setDriver_price(driverDto.getDriver_price());
        driver.setDriver_standing(driverDto.getDriver_standing());
        return driver;
    }
}
