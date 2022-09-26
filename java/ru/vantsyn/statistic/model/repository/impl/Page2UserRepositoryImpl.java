package ru.vantsyn.statistic.model.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.vantsyn.statistic.model.entity.Page;
import ru.vantsyn.statistic.model.entity.Page2User;
import ru.vantsyn.statistic.model.entity.User;
import ru.vantsyn.statistic.model.repository.Page2UserRepository;
import ru.vantsyn.statistic.model.repository.PageRepository;
import ru.vantsyn.statistic.model.services.PageService;
import ru.vantsyn.statistic.model.services.UserService;

import java.util.List;

@Repository
public class Page2UserRepositoryImpl implements Page2UserRepository {
    private final SessionFactory factory;
    private final UserService userService;
    private final PageService pageService;

    public Page2UserRepositoryImpl(SessionFactory factory, UserService userService, PageService pageService) {
        this.factory = factory;
        this.userService = userService;
        this.pageService = pageService;
    }

    @Override
    public Page2User getPageToUser(int userId, String page) {
        Page2User page2User;

        Session session = factory.getCurrentSession();
        Page pageDB = pageService.getByUrl(page);
        User user = userService.getUserById(userId);

        List page2Users = session.
                createQuery("from Page2User where user = " + userId + " and page = " + pageDB.getId()).
                getResultList();

        if (page2Users.size() == 0) {
            page2User = new Page2User();
            page2User.setPage(pageDB);
            page2User.setUser(user);
            session.save(page2User);
        } else {
            page2User = (Page2User) page2Users.get(0);
        }

        return page2User;
    }

    @Override
    public void updateViews(Page2User page2User) {
        page2User.setViewedCount(page2User.getViewedCount() + 1);
        factory.getCurrentSession().update(page2User);
    }

    @Override
    public int getUsersCountForPage(String page) {
        Page pageDB = pageService.getByUrl(page);

        return factory.getCurrentSession().createQuery("from Page2User where page = " + pageDB.getId()).
                getResultList().size();
    }

    @Override
    public int getUserViewsCount(int userId) {
        int viewsCount = 0;
        List<Page2User> page2Users = factory.getCurrentSession().createQuery("from Page2User where user = " + userId).getResultList();

        for (Page2User user: page2Users) {
            viewsCount += user.getViewedCount();
        }

        return viewsCount;
    }

    @Override
    public int getUserViewsCountByPage(int userId, String page) {
        int views = 0;
        Page pageDB = pageService.getByUrl(page);
        List page2Users = factory.getCurrentSession().
                createQuery("from Page2User where user = " + userId + " and page = " + pageDB.getId()).
                getResultList();
        if (page2Users.size() > 0) {
            views = ((Page2User) page2Users.get(0)).getViewedCount();
        }

        return views;
    }

    @Override
    public int getAllUserViewsCount() {
        int viewsCount = 0;
        List<Page2User> page2Users = factory.getCurrentSession().createQuery("from Page2User").getResultList();

        for (Page2User user: page2Users) {
            viewsCount += user.getViewedCount();
        }

        return viewsCount;
    }

    @Override
    public int getViewsCountByPage(String page) {
        int viewsCount = 0;
        Page pageDB = pageService.getByUrl(page);
        List<Page2User> page2Users = factory.getCurrentSession().
                createQuery("from Page2User where page = " + pageDB.getId()).getResultList();

        for (Page2User user: page2Users) {
            viewsCount += user.getViewedCount();
        }

        return viewsCount;
    }
}
