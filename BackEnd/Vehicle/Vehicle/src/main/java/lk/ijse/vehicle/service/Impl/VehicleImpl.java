package lk.ijse.vehicle.service.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.vehicle.dto.VehicleDTO;
import lk.ijse.vehicle.entity.VehicleEntity;
import lk.ijse.vehicle.repo.Repo;
import lk.ijse.vehicle.service.VehicleService;
import lk.ijse.vehicle.utilConfig.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class VehicleImpl implements VehicleService {
    @Autowired
    Repo repo;

    @Autowired
    Converter converter;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void save(VehicleDTO vehicleDTO) {
        if (repo.existsById(vehicleDTO.getId()))
            throw new RuntimeException(vehicleDTO.getId()+"Vehicle does not exist!");
        converter.vehicalDtoToVehicleEntity(vehicleDTO);
    }

    @Override
    public void update(VehicleDTO vehicleDTO) {
        if (!repo.existsById(vehicleDTO.getId()))
            throw new RuntimeException(vehicleDTO.getId()+" Vehicle does not exist!");
        converter.vehicalDtoToVehicleEntity(vehicleDTO);
    }

    @Override
    public void delete(String id) {
        if (!repo.existsById(id))
            throw new RuntimeException(id+" Vehicle does not exists !");
        repo.deleteById(id);
    }

    @Override
    public VehicleDTO findId(String id) {
        if(!repo.existsById(id))
            throw new RuntimeException(id+" Vehicle does not exists ");
        return converter.vehicleEntityToVehicleDto(repo.findById(id).get());
    }

    @Override
    public List<VehicleDTO> getAll() {
        return converter.vehicleEntityListToVehicleDtoList(repo.findAll());
    }

}
