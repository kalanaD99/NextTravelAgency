package lk.ijse.guideserver.repo;

import lk.ijse.guideserver.entity.GuideEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<GuideEntity,String> {
}
