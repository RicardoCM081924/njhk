package com.hhu.service;

import com.hhu.dao.VehicleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleDao vehicledao;

    @Override
    public List<String> getVehicleModel() {
        return vehicledao.getVehicleModel();
    }


}
