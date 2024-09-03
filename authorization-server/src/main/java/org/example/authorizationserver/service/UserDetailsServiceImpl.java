package org.example.authorizationserver.service;

import lombok.RequiredArgsConstructor;
import org.example.authorizationserver.model.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = restTemplate.getForObject(
                "http://localhost:8761/user-service/api/user/username/" + username, UserDetailsImpl.class);
        if (userDetails == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return userDetails;
    }

}
