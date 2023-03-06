package com.travelingcourier.admin.service1;
import com.travelingcourier.admin.feignclient.CourierClient;
import com.travelingcourier.admin.model1.Courier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourierService {
    @Autowired
    private CourierClient courierClient;

    public Courier createCourier(Courier courier, String bearerToken) {
        return courierClient.createCourier(courier,bearerToken);
    }

    public List<Courier> listCourier(String bearerToken) {
        return courierClient.ListCourier(bearerToken);
    }

    public Courier showCourierById(int packageId, String bearerToken) {
        return courierClient.showCourierById(packageId,bearerToken);
    }

    public String deleteCourier(int packageId, String bearerToken) {
        return courierClient.deleteCourier(packageId,bearerToken);
    }
}
