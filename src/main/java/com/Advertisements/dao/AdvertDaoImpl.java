package com.Advertisements.dao;


import com.Advertisements.model.Advert;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class AdvertDaoImpl implements AdvertDao {

    private SessionFactory sessionFactory;

    @Autowired
    public AdvertDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Advert getAdvertById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Advert advert = (Advert) session.load(Advert.class, id);

        return advert;
    }

    public void addAdvert(Advert advert) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(advert);


    }

    public void updateAdvert(Advert advert) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(advert);
    }

    public void removeAdvert(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Advert advert = (Advert) session.load(Advert.class, id);

        if (advert != null)
            session.delete(advert);
    }


    public List<Advert> getAdvertsByParams(Map<String, String> params) {
        String id = params.get("id");
        if (!id.equals("")) {
            List<Advert> list = new ArrayList();
            list.add(this.getAdvertById(Integer.valueOf(params.get("id"))));
            return list;
        }

        String title = params.get("title");
        if (title.equals("")) title = "%";

        String section = params.get("section");
        if (section.equals("All")) section = "%";

        String price = params.get("price");
        if (price.equals("")) price = "%";

        String moreOrLess = params.get("moreOrless");
        if (moreOrLess.equals("")) moreOrLess = "=";
        if (moreOrLess.equals("More")) moreOrLess = ">=";
        if (moreOrLess.equals("Less")) moreOrLess = "<=";

        if (title.equals("%") & section.equals("%") & price.equals("%"))
            return this.getAllAdverts();

        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createSQLQuery(
                "SELECT * FROM adverts WHERE title Like'" + title + "' AND section LIKE '"
                        + section + "' AND price" + moreOrLess + price);

        List<Advert> list = query.setResultTransformer(Transformers.aliasToBean(Advert.class)).list();

        return list;
    }

    @SuppressWarnings("unchecked")
    public List<Advert> getAllAdverts() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Advert> list = (List<Advert>) session.createQuery("from Advert").list();
        return list;

    }


}
