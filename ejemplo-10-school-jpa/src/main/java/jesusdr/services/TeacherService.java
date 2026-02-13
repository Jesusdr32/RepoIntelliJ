package jesusdr.services;

import jesusdr.entities.Teacher;
import jesusdr.models.NewTeacherModel;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    List<Teacher> findAll();
    Optional<Teacher> findById(Integer teacherId);

    Teacher createNew(NewTeacherModel newTeacherModel);

    Teacher update(Integer teacherId, NewTeacherModel newTeacherModel);
}
