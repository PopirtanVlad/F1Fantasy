package ro.sd.a2.factory;

import ro.sd.a2.entity.UsersEntity;

import java.util.UUID;

public class UserFactory {

    public static UsersEntity generateUser(){
        return UsersEntity.builder().user_id(UUID.randomUUID().toString()).build();
    }

}
