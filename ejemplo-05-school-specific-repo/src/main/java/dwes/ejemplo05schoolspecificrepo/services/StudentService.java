package dwes.ejemplo05schoolspecificrepo.services;

import dwes.ejemplo05schoolspecificrepo.entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAll();
    Optional<Student> findById(Long id);
    Student save(Student student);
    void delete(Student student);
}
