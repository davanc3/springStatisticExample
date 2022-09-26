package ru.vantsyn.statistic.model.repository;

import ru.vantsyn.statistic.model.entity.Page2User;

public interface Page2UserRepository {
    Page2User getPageToUser(int userId, String page);
    void updateViews(Page2User page2User);
    int getUsersCountForPage(String page);
    int getUserViewsCount(int userId);
    int getUserViewsCountByPage(int userId, String page);
    int getAllUserViewsCount();
    int getViewsCountByPage(String page);
}
