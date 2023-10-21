package lk.ijse.vehicle.utilConfig;

import lk.ijse.vehicle.dto.VehicleDTO;
import lk.ijse.vehicle.entity.VehicleEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Converter {

    @Autowired
    ModelMapper modelMapper;

    public VehicleEntity vehicalDtoToVehicleEntity(VehicleDTO vehicleDTO){
       return modelMapper.map(vehicleDTO, VehicleEntity.class);
    }

    public VehicleDTO vehicleEntityToVehicleDto( VehicleEntity vehicleEntity){
        return modelMapper.map(vehicleEntity, VehicleDTO.class);
    }
    public List<VehicleDTO> vehicleEntityListToVehicleDtoList(List<VehicleEntity> vehicleEntity){
        return modelMapper.map(vehicleEntity,new TypeToken<List<VehicleDTO>>(){}.getType());
    }
}
