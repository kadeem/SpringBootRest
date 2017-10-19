package de.pifrasso.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class WaggonSequence {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Waggon waggon;

    protected WaggonSequence(){}

    public WaggonSequence(Waggon waggon){
        this.waggon = waggon;
    }
}
