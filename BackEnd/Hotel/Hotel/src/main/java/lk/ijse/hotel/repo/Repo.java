package lk.ijse.hotel.repo;


import lk.ijse.hotel.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<HotelEntity,String> {
}
