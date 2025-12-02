package dwes.ejemplo05schoolspecificrepo.services;

import dwes.ejemplo05schoolspecificrepo.entities.Teacher;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TeacherService {
    List<Teacher> findAll();
    Optional<Teacher> findById(UUID id);
    Teacher save(Teacher teacher);
    void delete(Teacher teacher);
}
