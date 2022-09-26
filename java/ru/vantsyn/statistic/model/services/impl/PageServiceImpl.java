package ru.vantsyn.statistic.model.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vantsyn.statistic.model.entity.Page;
import ru.vantsyn.statistic.model.repository.PageRepository;

@Service
public class PageServiceImpl implements ru.vantsyn.statistic.model.services.PageService {
    private final PageRepository pageRepository;

    public PageServiceImpl(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }

    @Override
    @Transactional
    public Page getByUrl(String url) {
        return pageRepository.getByUrl(url);
    }
}
