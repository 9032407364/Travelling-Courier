package com.travelingcourier.admin.feignclient;

import com.travelingcourier.admin.model1.Courier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "API-GATE")
public interface CourierClient {
    @PostMapping("/api/v2/courier/save")
    public Courier createCourier(@RequestBody Courier courier, @RequestHeader("Authorization") String bearerToken);

    @GetMapping("/api/v2/courier/show/courierDetails")
    public List<Courier> ListCourier(@RequestHeader("Authorization") String bearerToken);

    @GetMapping("/api/v2/courier/show/courierDetails/{packageId}")
    public Courier showCourierById(@PathVariable int packageId, @RequestHeader("Authorization") String bearerToken);

    @DeleteMapping("/api/v2/courier/delete/courier/{packageId}")
    public String deleteCourier(@PathVariable int packageId, @RequestHeader("Authorization") String bearerToken);
}
