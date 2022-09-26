package ru.vantsyn.statistic.model.services;

import ru.vantsyn.statistic.model.entity.User;

public interface UserService {
    int getUsersCount();
    User getUserById(int id);
    int addNewUser();
}
