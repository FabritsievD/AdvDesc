package com.Advertisements.dao;


import com.Advertisements.model.Advert;
import com.Advertisements.model.Section;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.xml.transform.Transformer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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


    public List<Advert> getAdvertsByParams(Map<String,String> params) {
        String id =  params.get("id");
        String title = params.get("title");
        Section section = Section.valueOf(params.get("section"));
        String price =  params.get("price");

        if(!id.equals("")) {
            List<Advert> list = new ArrayList();
            list.add(this.getAdvertById( Integer.valueOf(params.get("id"))));
            return list;
        }

        if(id.equals("0")&title.equals("")&section.toString().equals("")&price.equals(""))
            return this.getAllAdverts();



        Session session = this.sessionFactory.getCurrentSession();

        Query query = session.createSQLQuery(
                "select * from adverts where price ='"+price+"' ");
        List<Advert> list = query.setResultTransformer(Transformers.aliasToBean(Advert.class)).list();
        Advert advert = list.get(0);
        advert.getId();
        advert.getDescription();
        // list.stream().forEach(a->logger.info("Adverts list from "+section+":"+a));

        return (List<Advert>) query.list();
    }
    @SuppressWarnings("unchecked")
    public List<Advert> getAllAdverts(){
        Session session =  this.sessionFactory.getCurrentSession();
        List<Advert> list = (List<Advert>) session.createQuery("from Advert").list();
       // list.stream().forEach(a->logger.info("Adverts list:"+a));
        return list;

    }


}
