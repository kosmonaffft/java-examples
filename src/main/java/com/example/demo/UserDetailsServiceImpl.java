package com.example.demo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        HashMap<String, String> user = (HashMap<String, String>) UsersController.DB.values()
                .stream().filter(u -> ((HashMap<String, String>) u).get("firstname").equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("User not found."));

        return new UserDetails() {

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                if (username.equals("Anton")) {
                    return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"),
                            new SimpleGrantedAuthority("ROLE_ADMIN"));
                } else {
                    return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
                }
            }

            @Override
            public String getPassword() {
                return user.get("password");
            }

            @Override
            public String getUsername() {
                return user.get("firstname");
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }
}
