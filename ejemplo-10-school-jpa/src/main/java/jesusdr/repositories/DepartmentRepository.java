package jesusdr.repositories;

import jesusdr.entities.Department;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends ListCrudRepository<Department, Long> {
}
