package com.hsbc.gcph.xaracloud.service;

import com.hsbc.gcph.xaracloud.common.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by subhash on 28/7/17.
 */
@Named
@Path("/consumer")
public class ConsumerService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Value("${rest.api.customer.service.get_by_id}")
    private String GET_CUSTOMER_BY_ID;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Integer> getCustomerById(
            @QueryParam("numOfQueries") final int numOfQueries,
            @QueryParam("delay") final long delay,
            @QueryParam("cusId") final String cusId) throws InterruptedException {
        final Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < numOfQueries; i++) {
            final Customer customer = restTemplate.getForObject(
                    GET_CUSTOMER_BY_ID.replace("{id}", cusId),
                    Customer.class);

            if (map.containsKey(customer.getName())) {
                final int count = map.get(customer.getName());
                map.put(customer.getName(), count+1);
            } else {
                map.put(customer.getName(), 1);
            }
            Thread.sleep(delay);
        }
        return map;
    }
}
