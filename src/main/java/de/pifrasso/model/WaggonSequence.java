package de.pifrasso.model;

import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.util.List;

@Entity
public class WaggonSequence implements Comparable{
    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    private Waggon waggon;

    private int sort;

    protected WaggonSequence(){}

    public WaggonSequence(Waggon waggon, int sort){
        this.waggon = waggon;
        this.sort = sort;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof WaggonSequence) {
            return this.sort - ((WaggonSequence) o).sort;
        }
        return 0;
    }
}
