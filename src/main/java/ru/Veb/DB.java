package ru.Veb;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Model;
import jakarta.persistence.*;
import org.hibernate.SessionFactory;
import ru.Veb.Units.Dataon;
//import ru.aaaTurbo.entities.ReportEntity;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.List;
import java.util.Properties;
@Model
@ApplicationScoped
public class DB implements Serializable {

    EntityManager em;
    EntityTransaction transaction;
    EntityManagerFactory e;
    public DB() throws IOException {
        Properties properties=new Properties();
        InputStreamReader ir = new InputStreamReader(getClass().getClassLoader().getResourceAsStream("db.cfg"));
        properties.load(ir);
        System.out.println(getClass().getClassLoader().getResourceAsStream("/db.cfg"));
        e = Persistence.createEntityManagerFactory("def",properties);
        em = e.createEntityManager();
        transaction = em.getTransaction();
    }
    public boolean save(Dataon report) {
        transaction.begin();
        em.persist(report);
        transaction.commit();
        return true;
    }

    private static SessionFactory sessionFactory;
    private static final String p="def";
    public List<Dataon> getReports(String session) throws IOException {
            transaction.begin();
            Query query=em.createQuery("SELECT e from Dataon e");
            transaction.commit();
            System.out.println(query.getResultList());
            return query.getResultList();
    }
    public void delete(){
        transaction.begin();
        Query query=em.createQuery("delete from Dataon");
        query.executeUpdate();
        transaction.commit();
    }
}