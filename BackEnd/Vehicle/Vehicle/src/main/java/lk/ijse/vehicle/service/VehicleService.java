package lk.ijse.vehicle.service;

import lk.ijse.vehicle.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    public void save(VehicleDTO vehicleDTO);

    public void update(VehicleDTO vehicleDTO);

    public  void delete(String id);

    VehicleDTO findId(String id);

    List<VehicleDTO>getAll();
}
