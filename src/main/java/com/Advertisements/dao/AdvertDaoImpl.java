package com.Advertisements.dao;


import com.Advertisements.model.Advert;
import com.Advertisements.model.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AdvertDaoImpl implements AdvertDao {

//private static final Logger logger = LoggerFactory.getLogger(AdvertDaoImpl.class);

    private SessionFactory sessionFactory ;

    @Autowired
    public AdvertDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Advert getAdvertById(int id){
    Session session = this.sessionFactory.getCurrentSession();
    Advert advert = (Advert) session.load(Advert.class,id);
    //logger.info("Advert loaded. Advert:"+advert);
    return advert;
    }

    public void addAdvert(Advert advert){
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(advert);
       // logger.info("Advert saved. Advert:"+advert);

    }

    public void  updateAdvert(Advert advert){
        Session session  = this.sessionFactory.getCurrentSession();
        session.update(advert);
       // logger.info("Advert updated. Advert:"+advert);
    }

    public void removeAdvert(int id){
        Session session = this.sessionFactory.getCurrentSession();
        Advert advert =(Advert) session.load(Advert.class,id);

        if (advert!=null)
            session.delete(advert);
       // logger.info("Advert removed. Advert:"+advert);
    }


    public List<Advert> getAdvertsBySection(Section section) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Advert> list = session.createQuery("from adverts where advert.section =:section").list();
        // list.stream().forEach(a->logger.info("Adverts list from "+section+":"+a));
        return list;
    }
    @SuppressWarnings("unchecked")
    public List<Advert> getAllAdverts(){
        Session session =  this.sessionFactory.getCurrentSession();
        List<Advert> list = (List<Advert>) session.createQuery("from Advert").list();
       // list.stream().forEach(a->logger.info("Adverts list:"+a));
        return list;

    }


}
