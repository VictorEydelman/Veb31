package ru.Veb.beans;

import ru.Veb.DB;
import ru.Veb.Units.Data;
import ru.Veb.Units.Dataon;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.Math.pow;

public class Bean {
    private Dataon entries=new Dataon(0,0,0,1,"1",new Date());
    private String dots = "";
    Data data = new Data();
    public List<Dataon> d = data.getRez();

    public Bean() throws IOException, SQLException, ClassNotFoundException {
    }
    public String getDots() {
        return dots;
    }

    public void setDots(String dots) {
        this.dots = dots;
    }
    public void setD(List<Dataon> d){
        this.d=d;
    }
    public List<Dataon> getD() {
        return d;
    }
    public void add() throws IOException {
        String check = check(entries.getX(),entries.getY(),entries.getR());
        Dataon ent=new Dataon(d.size(),entries.getX(),entries.getY(),entries.getR(),check,new Date());
        if (check.equals("Входит")) {
            dots += "<circle cx=\"" + (((ent.getX() * 80) / ent.getR()) + 140)
                    + "\" cy=\"" + (-1 * ((ent.getY() * 80) / ent.getR()) + 140) + "\" r=\"3\" fill=\"green\"/>";
        } else {
            dots += "<circle cx=\"" + (((ent.getX() * 80) / ent.getR()) + 140)
                    + "\" cy=\"" + (-1 * ((ent.getY() * 80) / ent.getR()) + 140) + "\" r=\"3\" fill=\"red\"/>";
        }
        entries = new Dataon(0,0,0,1,"1",new Date());
        d.add(ent);
        DB db = new DB();
        db.save(ent);
    }

    public void clear() throws IOException {
        d=new ArrayList<>();
        DB db = new DB();
        db.delete();
        dots="";
    }

    public void setEntries(Dataon entries) {
        this.entries = entries;
    }
    public Dataon getEntries() {
        return entries;
    }
    public String check(double x, double y, double r){
        if ((x >= 0 && y <= 0 && Math.sqrt(pow(x, 2) + pow(y, 2)) <= r / 2)
                || (x <= 0 && y >= 0 && x >= -r / 2 && y <= r) || (x <= 0 && y <= 0 && (x + y) >= -r)) {
            return "Входит";
        } else {
            return "Не входит";
        }
    }
}
