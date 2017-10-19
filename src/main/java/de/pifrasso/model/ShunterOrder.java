package de.pifrasso.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class ShunterOrder extends WorkOrder{

    @OneToMany
    @OrderBy("sort")
    private SortedSet<WaggonSequence> waggonSequence = new TreeSet<>();

    protected ShunterOrder(){}

    public ShunterOrder(String name, User user, Date begin, Date end, WorkOrderStatus status, SortedSet<WaggonSequence> waggonSequence){
        setName(name);
        setUser(user);
        setBegin(begin);
        setEnd(end);
        setStatus(status);


        setWaggonSequence(waggonSequence);
    }

    public SortedSet<WaggonSequence> getWaggonSequence() {
        return waggonSequence;
    }

    public void setWaggonSequence(SortedSet<WaggonSequence> waggonSequence) {
        this.waggonSequence = waggonSequence;
    }


}
