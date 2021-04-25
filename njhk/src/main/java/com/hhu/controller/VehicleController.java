package com.hhu.controller;


import com.github.pagehelper.PageInfo;
import com.hhu.model.Tablemap;
import com.hhu.model.VehicleBase;
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
    @RequestMapping("getVehicleType")
    public List<String> getVehicleType() {
        return vehicleservice.getVehicleType();
    }

    @ResponseBody
    @RequestMapping("getVehicleModel")
    public List<String> getVehicleModel() {
        return vehicleservice.getVehicleModel();
    }

    @ResponseBody
    @RequestMapping("getVehicleFactory")
    public List<String> getVehicleFactory() {
        return vehicleservice.getVehicleFactory();
    }

    @ResponseBody
    @RequestMapping("getVehicleSim")
    public List<String> getVehicleSim() {
        return vehicleservice.getVehicleSim();
    }

    @ResponseBody
    @RequestMapping("getVehicleBase")
    public Tablemap<List<VehicleBase>> getVehicleBase(String type, String model, String id, String rackid, String vendors, String sim, String vehicleowners) {
        List<VehicleBase> getVehicleBase = vehicleservice.getVehicleBase(type, model, id, rackid, vendors, sim, vehicleowners);
        PageInfo<VehicleBase> pageInfo = new PageInfo<VehicleBase>(getVehicleBase);

        return new Tablemap<List<VehicleBase>>(0, "", getVehicleBase.size(), getVehicleBase);
    }
}
