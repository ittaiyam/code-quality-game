package com.thepracticaldeveloper.devgame.modules.users.service;

import com.thepracticaldeveloper.devgame.modules.users.dao.UserMongoRepository;
import com.thepracticaldeveloper.devgame.modules.users.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    private final UserMongoRepository userRepository;

    public UserServiceImpl(final UserMongoRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Stream<User> getAllActiveUsers() {
        return userRepository.findAllUsersWithTeam();
    }

    @Override
    public List<User> findUsersByTeam(final String teamName) {
        return userRepository.findAllByTeam(teamName);
    }
}
