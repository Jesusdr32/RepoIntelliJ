package dwes.ejemplo05schoolspecificrepo.repositories;

import dwes.ejemplo05schoolspecificrepo.entities.Teacher;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TeacherRepositoryImpl implements TeacherRepository {

    SortedMap<UUID, Teacher> teachers = new TreeMap<>();

    @Override
    public List<Teacher> findAll() { return new ArrayList<>(teachers.values()); }

    @Override
    public Optional<Teacher> findById(UUID id) { return Optional.ofNullable(teachers.get(id)); }

    @Override
    public Teacher save(Teacher teacher) {
        //Si el profesor llega con ID null es que es nuevo
        if (teacher.getId() == null) {
            synchronized (teachers) {
                teacher.setId(getNewId());
                teachers.put(teacher.getId(), teacher);
            }
            return teacher;
        }
        //Si no tenía ID null, pero no se encuentra, error
        if (teachers.get(teacher.getId()) == null) {
            throw new NoSuchElementException("No profesor with id " + teacher.getId());
        }
        //Actualizar el existente
        return teachers.put(teacher.getId(), teacher);
    }

    @Override
    public void delete(Teacher teacher) {
        if (!teachers.containsKey(teacher.getId())) {
            throw new NoSuchElementException("No profesor with id " + teacher.getId());
        }
        teachers.remove(teacher.getId());
    }

    private UUID getNewId() {
        //Long max = teacher.keySet().stream().mapToLong(k -> k).max.orElse(0);
        //return max + 1;
        return teachers.isEmpty() ? 1 :  teachers.lastKey() + 1;
    }
}
