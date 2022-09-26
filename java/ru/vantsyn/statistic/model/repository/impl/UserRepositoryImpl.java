package ru.vantsyn.statistic.model.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.vantsyn.statistic.model.entity.User;
import ru.vantsyn.statistic.model.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final SessionFactory factory;

    public UserRepositoryImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public int getUsersCount() {
        return factory.getCurrentSession().createQuery("from User").getResultList().size();
    }

    @Override
    public User getUserById(int id) {
        return factory.getCurrentSession().get(User.class, id);
    }

    @Override
    public int addNewUser() {
        User user = new User();

        return (int) factory.getCurrentSession().save(user);
    }
}
