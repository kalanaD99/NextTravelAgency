package lk.ijse.repo;

import lk.ijse.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<BookEntity,String> {
}
