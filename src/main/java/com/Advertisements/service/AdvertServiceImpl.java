package com.Advertisements.service;

import com.Advertisements.dao.AdvertDao;
import com.Advertisements.model.Advert;
import com.Advertisements.model.Section;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class AdvertServiceImpl implements AdvertService {

    private AdvertDao advertDao;
@Autowired
public void setAdvertDao(AdvertDao advertDao) {
        this.advertDao = advertDao;
   }

    @Override
    @Transactional
    public Advert getAdvertById(int id) {
        return this.advertDao.getAdvertById(id);
    }

    @Override
    @Transactional
    public void addAdvert(Advert advert) {
        this.advertDao.addAdvert(advert);
    }

    @Override
    @Transactional
    public void updateAdvert(Advert advert) {
        this.advertDao.updateAdvert(advert);
    }

    @Override
    @Transactional
    public void removeAdvert(int id) {
        this.advertDao.removeAdvert(id);
    }

    @Override
    @Transactional
    public List<Advert> getAllAdverts() {
        return this.advertDao.getAllAdverts();
    }

    @Override
    @Transactional
    public List<Advert> getAdvertsBySection(Section section) {
        return this.advertDao.getAdvertsBySection(section);
    }
}
