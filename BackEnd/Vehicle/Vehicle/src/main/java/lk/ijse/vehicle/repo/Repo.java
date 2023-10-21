package lk.ijse.vehicle.repo;

import lk.ijse.vehicle.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<VehicleEntity,String> {
}
