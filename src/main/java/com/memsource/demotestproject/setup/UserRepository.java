package com.memsource.demotestproject.setup;

public interface UserRepository {
    UserSetupDTO getFirstUsersSetup();

    UserSetupDTO findUserSetupByUsername(String username);

    void save(UserSetupDTO userSetup);
}
