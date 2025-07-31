package com.reso.scheduler.infrastructure.security;

import com.reso.scheduler.business.dto.UserDTO;
import com.reso.scheduler.infrastructure.security.client.UserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl{

    private final UserClient client;

    public UserDetails loadDataUser(String email, String token) {

        UserDTO userDTO = client.findUserByEmail(email, token);
        return User
                .withUsername(userDTO.getEmail())
                .password(userDTO.getPassword())
                .build();
    }
}