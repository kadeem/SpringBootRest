package de.pifrasso.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class ShunterOrder extends WorkOrder{

    @OneToMany
    private List<WaggonSequence> waggonSequence;

    protected ShunterOrder(){}

    public ShunterOrder(String name, User user, Date begin, Date end, WorkOrderStatus status, List<Waggon> waggons){
        setName(name);
        setUser(user);
        setBegin(begin);
        setEnd(end);
        setStatus(status);
        setWaggonSequenceByWaggons(waggons);
    }

    public List<WaggonSequence> getWaggonSequence() {
        return waggonSequence;
    }

    public void setWaggonSequence(List<WaggonSequence> waggonSequence) {
        this.waggonSequence = waggonSequence;
    }


    public void setWaggonSequenceByWaggons(List<Waggon> waggons) {
        List<WaggonSequence> ws = new ArrayList<>();
        ws.add(new WaggonSequence());

        this.waggonSequence = ws;
    }
}
