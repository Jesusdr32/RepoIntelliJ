package jesusdr.services;

import jesusdr.entities.Module;

import java.util.List;

public interface ModuleService {
    void addStudent(String moduleId, Long studentId);

    List<Module> findAll();
}
