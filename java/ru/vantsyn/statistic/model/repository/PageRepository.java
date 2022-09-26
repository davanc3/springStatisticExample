package ru.vantsyn.statistic.model.repository;

import ru.vantsyn.statistic.model.entity.Page;

public interface PageRepository {
    Page getByUrl(String url);
}
