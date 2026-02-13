package jesusdr.mappers;

import jesusdr.entities.Teacher;
import jesusdr.models.NewTeacherModel;

public class TeacherMapper {

    private TeacherMapper(){}

    public static NewTeacherModel map(Teacher teacher) {
        return NewTeacherModel.builder()
                .email(teacher.getEmail())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .birthDate(teacher.getBirthDate())
                .startDate(teacher.getStartDate())
                .departmentId(teacher.getDepartment().getDepartmentId())
                .build();
    }

    public static Teacher map(NewTeacherModel teacherModel) {
        return Teacher.builder()
                .email(teacherModel.getEmail())
                .firstName(teacherModel.getFirstName())
                .lastName(teacherModel.getLastName())
                .birthDate(teacherModel.getBirthDate())
                .startDate(teacherModel.getStartDate())
                .build();
    }
}
