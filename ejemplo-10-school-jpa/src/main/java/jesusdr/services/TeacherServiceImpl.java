package jesusdr.services;

import jakarta.persistence.EntityNotFoundException;
import jesusdr.entities.Department;
import jesusdr.entities.Teacher;
import jesusdr.mappers.TeacherMapper;
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
    public Teacher createNew(NewTeacherModel teacherModel) {
        Department department = departmentRepository.findById(teacherModel.getDepartmentId())
                .orElseThrow(() -> new EntityNotFoundException(String.format("No se encuentra el departamento con ID %s", teacherModel.getDepartmentId())));

        Teacher teacher = TeacherMapper.map(teacherModel);
        teacher.setDepartment(department);

        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher update(Integer teacherId, NewTeacherModel teacherModel) {
        // 1 - Obtener el Teacher de la base de datos
        // 1.1 - ¿Si no está, excepción?
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("No se encuentra el profesor con id %d", teacherId)));
        // 2 - Actualizar campos
        teacher.setEmail(teacherModel.getEmail());
        teacher.setFirstName(teacherModel.getFirstName());
        teacher.setLastName(teacherModel.getLastName());
        teacher.setBirthDate(teacherModel.getBirthDate());
        teacher.setStartDate(teacherModel.getStartDate());

        // 3 - Actualizar departamento // Con GetReferenceById
        System.out.println("Antes de getReferenceById");
        Department department = departmentRepository.getReferenceById(teacherModel.getDepartmentId());
        System.out.println("Después de getReferenceById, pero antes de mostrar el nombre del departamento");
        System.out.printf("Nombre del departamento: %s", department.getName());
        System.out.println("Después de mostrar el nombre del departamento");
        teacher.setDepartment(department);

        // 4 - Guardar
        return teacherRepository.save(teacher);
    }
}
