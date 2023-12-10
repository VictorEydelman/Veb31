package ru.Veb.Units;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Dataon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private double x;
    @Column
    private double y;
    @Column
    private double r;
    @Column
    private String result;
    @Column
    private Date queryTime;

    public Dataon(int id, double x, double y, double r, String result, Date queryTime) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;
        this.queryTime = queryTime;
    }

    public Dataon() {

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public void setX(double x) {
        this.x=x;
    }

    public void setY(double y) {
        this.y=y;
    }

    public void setR(double r) {
        this.r=r;
    }


    public String isResult() {
        return result;
    }

    public Date getQueryTime() {
        return queryTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof Dataon)) return false;
        Dataon entry = (Dataon) o;
        return Double.compare(entry.getX(), getX()) == 0 && Double.compare(entry.getY(), getY()) == 0 && Double.compare(entry.getR(), getR()) == 0 && isResult() == entry.isResult() && Objects.equals(getQueryTime(), entry.getQueryTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY(), getR(), isResult(), getQueryTime());
    }
}
