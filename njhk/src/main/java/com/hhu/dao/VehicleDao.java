package com.hhu.dao;

import com.hhu.model.VehicleBase;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Ricardo
 */
public interface VehicleDao {
    List<String> getVehicleType();

    List<String> getVehicleModel();

    List<String> getVehicleFactory();

    List<String> getVehicleSim();

    List<VehicleBase> getVehicleBase(@Param("type") String type, @Param("model") String model, @Param("id") String id, @Param("rackid") String rackid, @Param("vendors") String vendors, @Param("sim") String sim, @Param("vehicleowners") String vehicleowners);
}
