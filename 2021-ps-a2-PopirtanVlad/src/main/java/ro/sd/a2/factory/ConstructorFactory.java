package ro.sd.a2.factory;

import ro.sd.a2.entity.Constructor;

import java.util.UUID;

public class ConstructorFactory {

    public static Constructor generateCosntructor(){
        return Constructor.builder().constructor_id(UUID.randomUUID().toString()).build();
    }
}
