package com.memsource.demotestproject.setup;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    /**
     * method return first user's setup (no specific order)
     * @return
     */
    public UserSetupDTO getFirstUserSetup() {
        return userRepository.getFirstUsersSetup();
    }

    /**
     * Method save or update user's setup to database
     * If is username already in db throws IllegalArgumentException
     *
     * @param userSetupDTO
     * @throws IllegalArgumentException
     */
    public void save(UserSetupDTO userSetupDTO) throws IllegalArgumentException {
        UserSetupDTO existsUsername = userRepository.findUserSetupByUsername(userSetupDTO.getUsername());

        if (existsUsername != null && !userSetupDTO.getId().equals(existsUsername.getId())) {
            throw new IllegalArgumentException("This username is already taken.");
        }

        userRepository.save(userSetupDTO);
    }
}
