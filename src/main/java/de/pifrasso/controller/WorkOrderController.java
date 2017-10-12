package de.pifrasso.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import de.pifrasso.model.WorkOrder;
import de.pifrasso.model.WorkOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class WorkOrderController {


    private final WorkOrderRepository workOrderRepository;

    @Autowired
    public WorkOrderController(WorkOrderRepository workOrderRepository){
        this.workOrderRepository=workOrderRepository;
    }

    @RequestMapping("/sample")
    public Map<String,String> sample(@RequestParam(value="name", defaultValue="World") String name) {
        Map<String,String> result = new HashMap<>();
        result.put("message", String.format("Hello, %s", name));
        return result;
    }

    //@RequestMapping(value = "/workOrders",  produces = APPLICATION_JSON_VALUE)
    //public List<WorkOrder> allWorkOrders() {
    //    return workOrderRepository.findAll();
    //}

    //@RequestMapping(value = "/workOrder/{id}",  produces = APPLICATION_JSON_VALUE)
    //public WorkOrder oneWorkOrder(@PathVariable("id") Long id) {
   //     return workOrderRepository.findOne(id);
    //}

    @RequestMapping(method = RequestMethod.POST, value = "/workOrder", produces = APPLICATION_JSON_VALUE)
    public WorkOrder register(@RequestBody WorkOrder workOrder) {
        workOrderRepository.save(workOrder);
        /*
        if(usernameAlreadyExists) {
            throw new IllegalArgumentException("error.username");
        }
    */
        return workOrder;
    }
}