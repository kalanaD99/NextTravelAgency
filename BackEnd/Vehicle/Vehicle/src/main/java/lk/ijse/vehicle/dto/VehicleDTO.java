package lk.ijse.vehicle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {
    private String id;
    private String vehicleBrand;
    private String category;
    private String fuelType;
    private String hybridStatus;
    private int fuelUsage;
    private String images;
    private int seatCapacity;
    private String vehicleType;
    private String transmission;
    private String driverName;
    private String driverLicense;

}
