package com.Advertisements.dao;

import com.Advertisements.model.Advert;
import com.Advertisements.model.Section;
import java.util.List;

public interface AdvertDao {

    Advert getAdvertById(int id);

    void addAdvert(Advert advert);

    void updateAdvert(Advert advert);

    void removeAdvert(int id);

    List<Advert> getAllAdverts();

    List<Advert> getAdvertsBySection(Section section);

    }
