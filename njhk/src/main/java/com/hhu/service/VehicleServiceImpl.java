package com.hhu.service;

import com.hhu.dao.VehicleDao;
import com.hhu.model.VehicleBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleDao vehicledao;

    @Override
    public List<String> getVehicleType() {
        return vehicledao.getVehicleType();
    }

    @Override
    public List<String> getVehicleModel() {
        return vehicledao.getVehicleModel();
    }

    @Override
    public List<String> getVehicleFactory() {
        return vehicledao.getVehicleFactory();
    }

    @Override
    public List<String> getVehicleSim() {
        return vehicledao.getVehicleSim();
    }

    @Override
    public List<VehicleBase> getVehicleBase(String type, String model, String id, String rackid, String vendors, String sim, String vehicleowners) {
        return vehicledao.getVehicleBase(type, model, id, rackid, vendors, sim, vehicleowners);
    }
}
