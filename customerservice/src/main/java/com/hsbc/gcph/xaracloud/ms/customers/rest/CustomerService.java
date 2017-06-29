package com.hsbc.gcph.xaracloud.ms.customers.rest;


import com.hsbc.gcph.xaracloud.ms.customers.model.Customer;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by subhash on 27/6/17.
 */

@Named
@Path("/customers")
public class CustomerService {

    private static List<Customer> customers = new ArrayList<Customer>();

    static {
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setName("Customer 1");
        customer1.setEmail("customer1@hsbc.cOm");

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setName("Customer 2");
        customer2.setEmail("Customer2@hsbc.cOm");

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setName("Customer 3″");
        customer3.setEmail("Customer3@hsbc.cOm");

        Customer customer4 = new Customer();
        customer4.setId(4);
        customer4.setName("Customer 4");
        customer4.setEmail("Customer4@hsbc.cOm");

        Customer customer5 = new Customer();
        customer5.setId(5);
        customer5.setName("Customer 5");
        customer5.setEmail("Customer5@hsbc.cOm");

        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);
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
        return id <= customers.size() && id >= 0 ?
                customers.get(id-1) :
                null;
    }
}
