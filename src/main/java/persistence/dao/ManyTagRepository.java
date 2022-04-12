package persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import persistence.model.ManyTag;

public interface ManyTagRepository extends JpaRepository<ManyTag, Long> {
}
