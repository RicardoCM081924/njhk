package com.hhu.service;


import com.hhu.model.VehicleBase;

import java.util.List;

public interface VehicleService {
     List<String> getVehicleType();

     List<String> getVehicleModel();

     List<String> getVehicleFactory();

     List<String> getVehicleSim();

     List<VehicleBase> getVehicleBase(String type, String model, String id, String rackid, String vendors, String sim, String vehicleowners);
}
