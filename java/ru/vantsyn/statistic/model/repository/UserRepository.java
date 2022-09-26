package ru.vantsyn.statistic.model.repository;

import ru.vantsyn.statistic.model.entity.User;

public interface UserRepository {
    int getUsersCount();
    User getUserById(int id);
    int addNewUser();
}
