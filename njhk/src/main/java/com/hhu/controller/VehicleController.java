package com.hhu.controller;


import com.hhu.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Ricardo
 */
@Controller
@RequestMapping("/")

public class VehicleController {

    @Resource
    private VehicleService vehicleservice;

    @ResponseBody
    @RequestMapping("getVehicleModel")
    public List<String> getVehicleModel() {
        return vehicleservice.getVehicleModel();
    }
}
