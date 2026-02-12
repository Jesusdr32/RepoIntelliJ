package jesusdr.services;

import jakarta.persistence.EntityNotFoundException;
import jesusdr.entities.Module;
import jesusdr.entities.Student;
import jesusdr.repositories.ModuleRepository;
import jesusdr.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleServiceImpl implements ModuleService {
    private final ModuleRepository moduleRepository;
    private final StudentRepository studentRepository;

    public ModuleServiceImpl(ModuleRepository moduleRepository, StudentRepository studentRepository) {
        this.moduleRepository = moduleRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void addStudent(String moduleId, Long studentId) {
        // Bucar el módulo que quiero cambiar
        Module module = moduleRepository.findById(moduleId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No se ha encontrado el módulo con id %d.", moduleId)));

        // Ya tengo el módulo. Busco el estudiante
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No se ha encontrado el estudiante con id %d.", studentId)));

        // Añado el estudiante al módulo
        module.getStudents().add(student);

        // Guardar cambios
        moduleRepository.save(module);
    }

    @Override
    public List<Module> findAll() {
        return moduleRepository.findAll();
    }
}
