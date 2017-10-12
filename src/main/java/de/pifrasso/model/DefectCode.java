package de.pifrasso.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DefectCode {

    @Id
    @GeneratedValue
    private long id;
    private String label;
    private String name;
    private String part;

    protected DefectCode(){
    }

    public DefectCode(String label, String name, String part) {
        this.label = label;
        this.name = name;
        this.part = part;
    }

    public long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }
}
