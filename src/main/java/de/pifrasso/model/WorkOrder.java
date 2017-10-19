package de.pifrasso.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class WorkOrder {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ManyToOne
    private User user;
    private Date begin;
    private Date end;
    private WorkOrderStatus status;

    protected WorkOrder(){}

    public WorkOrder(String name, User user, Date begin, Date end, WorkOrderStatus status){
        setName(name);
        setUser(user);
        setBegin(begin);
        setEnd(end);
        setStatus(status);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public long getId() {
        return id;
    }

    public WorkOrderStatus getStatus() {
        return status;
    }

    public void setStatus(WorkOrderStatus status) {
        this.status = status;
    }


}
