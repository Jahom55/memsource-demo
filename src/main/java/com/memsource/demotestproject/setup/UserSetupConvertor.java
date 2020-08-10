package com.memsource.demotestproject.setup;

public class UserSetupConvertor {

    public static UserSetupEntity convert(UserSetupDTO userSetupDTO) {
        return UserSetupEntity.builder()
                .id(userSetupDTO.getId())
                .password(userSetupDTO.getPassword())
                .username(userSetupDTO.getUsername())
                .build();
    }

    public static UserSetupDTO convert(UserSetupEntity userSetupEntity) {
        if (userSetupEntity == null) {
            return null;
        }

        return UserSetupDTO.builder()
                .id(userSetupEntity.getId())
                .password(userSetupEntity.getPassword())
                .username(userSetupEntity.getUsername())
                .build();
    }
}
