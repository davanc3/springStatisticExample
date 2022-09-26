package ru.vantsyn.statistic.model.services;

import ru.vantsyn.statistic.model.entity.Page;

public interface PageService {
    Page getByUrl(String url);
}
