package com.joseph.lil;

import com.joseph.lil.data.dao.ServiceDao;
import com.joseph.lil.data.entity.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        ServiceDao serviceDao = new ServiceDao();
        List<Service> services = serviceDao.getAll();

        System.out.println("**** SERVICES ****");
        System.out.println("\n**** GET_ALL ****");
        services.forEach(System.out::println);


        Optional<Service> serviceOpt = serviceDao.getOne(services.get(0).getServiceID());
        System.out.println("\n**** GET_ONE ****" + serviceOpt.get());
        serviceOpt.ifPresent(System.out::println);


        Service newService = new Service();
        newService.setName("FoodBaz" + System.currentTimeMillis());
        newService.setPrice(new BigDecimal(4.35));
        newService = serviceDao.create(newService);
        System.out.println("\n**** NEW SERVICE ****" + newService);
    }
}
