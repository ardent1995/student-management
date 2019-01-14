package se.indpro.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.indpro.model.Student;
@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {

}
