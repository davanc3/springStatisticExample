package ru.vantsyn.statistic.model.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vantsyn.statistic.model.entity.Page2User;
import ru.vantsyn.statistic.model.repository.Page2UserRepository;
import ru.vantsyn.statistic.model.services.Page2UserService;

@Service
public class Page2UserServiceImpl implements Page2UserService {
    private final Page2UserRepository page2UserRepository;

    public Page2UserServiceImpl(Page2UserRepository page2UserRepository) {
        this.page2UserRepository = page2UserRepository;
    }

    @Override
    @Transactional
    public Page2User getPageToUser(int userId, String page) {
        return page2UserRepository.getPageToUser(userId, page);
    }

    @Override
    @Transactional
    public void updateViews(Page2User page2User) {
        page2UserRepository.updateViews(page2User);
    }

    @Override
    @Transactional
    public int getUsersCountForPage(String page) {
       return page2UserRepository.getUsersCountForPage(page);
    }

    @Override
    @Transactional
    public int getUserViewsCount(int userId) {
        return page2UserRepository.getUserViewsCount(userId);
    }

    @Override
    @Transactional
    public int getUserViewsCountByPage(int userId, String page) {
        return page2UserRepository.getUserViewsCountByPage(userId, page);
    }

    @Override
    @Transactional
    public int getAllUserViewsCount() {
        return page2UserRepository.getAllUserViewsCount();
    }

    @Override
    @Transactional
    public int getViewsCountByPage(String page) {
        return page2UserRepository.getViewsCountByPage(page);
    }
}
