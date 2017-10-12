package de.pifrasso.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Waggon {
    @Id
    @GeneratedValue
    private long id;
    private String number;

    protected Waggon(){}

    public Waggon(String number){
        setNumber(number);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getId() {
        return id;
    }
}
