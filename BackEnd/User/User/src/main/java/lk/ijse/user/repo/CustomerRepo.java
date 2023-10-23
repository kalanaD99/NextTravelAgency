package lk.ijse.user.repo;

import lk.ijse.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<UserEntity,String> {
}
