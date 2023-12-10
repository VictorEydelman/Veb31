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

    public List<Dataon> getRez() throws IOException, ClassNotFoundException, SQLException {
        DB db = new DB();
        rez=db.getReports();
        return rez;
    }

    public void setRez(List<Dataon> rez) {

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

