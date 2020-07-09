package com.mcks.spring.security.service;

import com.mcks.spring.security.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private List<User> usersList = new ArrayList<>();

    public List<User> addUser(User user) {
        usersList.add(user);
        return usersList;
    }

    public User getUser(String username) {
        User userFromCollection = new User();

      /*  for(User user : usersList) {
            if(username.equalsIgnoreCase(user.getUsername())) {
                userFromCollection = user;
                break;
            }
        }*/
        userFromCollection = usersList.stream().filter(user -> username.equalsIgnoreCase(user.getUsername())).collect(Collectors.toList()).get(0);
        return userFromCollection;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userFromDataSource = getUser(username);
        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(userFromDataSource.getUsername(), userFromDataSource.getPassword(), new ArrayList<>());
        return user;
    }
}
