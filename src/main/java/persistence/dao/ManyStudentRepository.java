package persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import persistence.model.ManyStudent;

import java.util.List;

public interface ManyStudentRepository extends JpaRepository<ManyStudent, Long> {
    List<ManyStudent> findByManyTags_Name(String name);
}
