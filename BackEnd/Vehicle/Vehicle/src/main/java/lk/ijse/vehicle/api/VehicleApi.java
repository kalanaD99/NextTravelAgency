package lk.ijse.vehicle.api;


import lk.ijse.vehicle.dto.VehicleDTO;
import lk.ijse.vehicle.entity.VehicleEntity;
import lk.ijse.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleApi {
    @Autowired
    VehicleService service;

    @PostMapping
    public ResponseEntity<String>saveVehicle(@RequestBody VehicleDTO vehicleDTO){
        service.save(vehicleDTO);
    return new  ResponseEntity<>(vehicleDTO.getId()+" Vehicle Saved Successfully! ", HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<String>update(@RequestBody VehicleDTO vehicleDTO){
        service.update(vehicleDTO);
        return new ResponseEntity<>(vehicleDTO.getId()+" Updated Successfully!",HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<String>delete(String id){
        service.delete(id);
        return new ResponseEntity<>(id+" Successfully Deleted!",HttpStatus.OK);
    }
    @GetMapping(params = "id")
    public ResponseEntity<VehicleDTO>findById(String id){
        return new ResponseEntity<>(service.findId(id),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<VehicleDTO>>geAll(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }




}
