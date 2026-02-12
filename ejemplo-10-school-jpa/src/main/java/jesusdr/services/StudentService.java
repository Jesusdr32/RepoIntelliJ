package jesusdr.services;

import jesusdr.entities.Student;
import jesusdr.models.NewStudentModel;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();
    Optional<Student> findById(Long studentId);

    void addModule(Long studentId, String moduleId);

    Student createNew(NewStudentModel newStudentModel);
}
