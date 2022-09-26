package ru.vantsyn.statistic.model.repository.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.vantsyn.statistic.model.entity.Page;
import ru.vantsyn.statistic.model.repository.PageRepository;

@Repository
public class PageRepositoryImpl implements PageRepository {
    SessionFactory factory;

    public PageRepositoryImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Page getByUrl(String url) {
        return (Page) factory.getCurrentSession().createQuery("from Page where href = '" + url + "'").getResultList().get(0);
    }
}
