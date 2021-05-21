package ro.sd.a2.factory;

import ro.sd.a2.entity.Driver;

import java.util.UUID;

public class DriverFactory {

    public static Driver generateDriver(){
        return Driver.builder().driver_id(UUID.randomUUID().toString()).build();
    }
}
