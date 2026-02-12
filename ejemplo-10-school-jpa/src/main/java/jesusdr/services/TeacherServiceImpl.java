package jesusdr.services;

import jakarta.persistence.EntityNotFoundException;
import jesusdr.entities.Department;
import jesusdr.entities.Teacher;
import jesusdr.models.NewTeacherModel;
import jesusdr.repositories.DepartmentRepository;
import jesusdr.repositories.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final DepartmentRepository departmentRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository, DepartmentRepository departmentRepository) {
        this.teacherRepository = teacherRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Teacher> findAll(){
        return teacherRepository.findAll();
    }

    @Override
    public Optional<Teacher> findById(Integer teacherId) {
        return teacherRepository.findById(teacherId);
    }

    @Override
    public Teacher createNew(NewTeacherModel newTeacherModel) {
        Department department = departmentRepository.findById(newTeacherModel.getDepartmentId())
                .orElseThrow(() -> new EntityNotFoundException(String.format("No se encuentra el departamento con ID %s", newTeacherModel.getDepartmentId())));

        Teacher teacher = Teacher.builder()
                .email(newTeacherModel.getEmail())
                .firstName(newTeacherModel.getFirstName())
                .lastName(newTeacherModel.getLastName())
                .birthDate(newTeacherModel.getBirthDate())
                .startDate(newTeacherModel.getStartDate())
                .department(department)
                .build();

        return teacherRepository.save(teacher);
    }
}
