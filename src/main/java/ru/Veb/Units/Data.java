package ru.Veb.Units;

import ru.Veb.DB;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Data implements Serializable {
    private List<Dataon> rez;
    private SimpleDateFormat simple;

    public Data() {
        rez = new ArrayList<>();
        simple = new SimpleDateFormat("HH:mm:ss");
    }

    public List<Dataon> getRez(String session) throws IOException, ClassNotFoundException, SQLException {
        DB db = new DB();
        rez=db.getReports(session);
        if(rez.size()>0) {
            System.out.println(rez + " getRez ");
        }
        return rez;
    }

    public void setRez(List<Dataon> rez) {
        //for (int i=0;i<rez.size();i++){
          //  System.out.print(rez.get(i).getX()+" ");
        //}
        System.out.println(rez+" setRez");
        this.rez=rez;
    }
    public void addEntry(Dataon entry) {
        rez.add(entry);
    }


    public SimpleDateFormat getSimpleDateFormat() {
        return simple;
    }

    public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
        this.simple=simpleDateFormat;
    }



}

