package com.Advertisements.service;

import com.Advertisements.model.Advert;
import com.Advertisements.model.Section;

import java.util.List;
import java.util.Map;

public interface AdvertService {
    Advert getAdvertById(int id);

    void addAdvert(Advert advert);

    void updateAdvert(Advert advert);

    void removeAdvert(int id);

    List<Advert> getAllAdverts();

    List<Advert> getAdvertsByParams(Map<String,String> params);
}
