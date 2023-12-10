package ru.Veb;

import ru.Veb.Units.Dataon;

import jakarta.persistence.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.List;
import java.util.Properties;

public class DB implements Serializable {

    EntityManager em;
    EntityTransaction transaction;
    EntityManagerFactory e;
    public DB() throws IOException {
        Properties properties=new Properties();
        InputStreamReader ir = new InputStreamReader(getClass().getClassLoader().getResourceAsStream("db.cfg"));
        properties.load(ir);
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

    private static final String p="def";
    public List<Dataon> getReports() throws IOException {
            transaction.begin();
            Query query=em.createQuery("SELECT e from Dataon e");
            transaction.commit();
            return query.getResultList();
    }
    public void delete(){
        transaction.begin();
        Query query=em.createQuery("delete from Dataon");
        query.executeUpdate();
        transaction.commit();
    }
}