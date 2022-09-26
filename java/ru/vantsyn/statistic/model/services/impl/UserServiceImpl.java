package ru.vantsyn.statistic.model.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vantsyn.statistic.model.entity.User;
import ru.vantsyn.statistic.model.repository.UserRepository;
import ru.vantsyn.statistic.model.services.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public int getUsersCount() {
        return userRepository.getUsersCount();
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    @Transactional
    public int addNewUser() {
        return userRepository.addNewUser();
    }
}
