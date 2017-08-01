package com.hsbc.gcph.xaracloud.service;

import com.hsbc.gcph.xaracloud.common.model.Customer;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by subhash on 28/7/17.
 */
@Named
@Path("/customers")
public class CustomerService {

    private static List<Customer> customers = new ArrayList<Customer>();

    static {
        Customer customer1 = new Customer(1, "Customer-1");
        Customer customer2 = new Customer(2, "Customer-2");
        Customer customer3 = new Customer(3, "Customer-3");

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public static List<Customer> getCustomers() {
        return customers;
    }


    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomerById(@QueryParam("id") final int id) {
        return id < customers.size() && id >= 0 ?
                customers.get(id-1) :
                null;
    }
}
