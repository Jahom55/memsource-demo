package com.memsource.demotestproject.setup;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    UserRepository userRepositoryMock;

    @InjectMocks
    UserService userService;

    @Test(expected = IllegalArgumentException.class)
    public void testDuplicitySave() {
        UserSetupDTO userSetup = new UserSetupDTO(1L, "Username", "password");
        when(userRepositoryMock.findUserSetupByUsername(userSetup.getUsername())).thenReturn(new UserSetupDTO(2L, "Username", "password"));
        userService.save(userSetup);
    }
}