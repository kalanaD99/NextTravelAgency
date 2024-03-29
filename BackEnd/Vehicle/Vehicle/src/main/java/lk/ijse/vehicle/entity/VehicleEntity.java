package lk.ijse.vehicle.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class VehicleEntity {
    @Id
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
