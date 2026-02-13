package jesusdr.controllers;

import jakarta.persistence.EntityNotFoundException;
import jesusdr.entities.Department;
import jesusdr.entities.Teacher;
import jesusdr.mappers.TeacherMapper;
import jesusdr.models.NewTeacherModel;
import jesusdr.services.DepartmentService;
import jesusdr.services.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;
    private final DepartmentService departmentService;

    public TeacherController(TeacherService teacherService, DepartmentService departmentService) {
        this.teacherService = teacherService;
        this.departmentService = departmentService;
    }

    @GetMapping({"", "/"})
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView("teachers/index");
        mv.addObject("teachers", teacherService.findAll());
        return mv;
    }

    @GetMapping("{teacherId}")
    public ModelAndView findById(@PathVariable Integer teacherId){
        ModelAndView mv = new ModelAndView("teachers/detail");
        Teacher teacher = teacherService.findById(teacherId).orElseThrow();
        mv.addObject("teacher", teacher);
        return mv;
    }

    @GetMapping("/new")
    public String newTeacherGet(Model model) {
        model.addAttribute("teacher", new NewTeacherModel());
        return "teachers/new";
    }

    @PostMapping("/new")
    public String newTeacherPost(@ModelAttribute("teacher") NewTeacherModel newTeacherModel, Model model) {
        try {
            teacherService.createNew(newTeacherModel);
        } catch (Exception e) {
            model.addAttribute("error", String.format("Se ha producido un error: %s", e.getMessage()));
            return "teachers/new";
        }
        return "redirect:/teachers";
    }

    @GetMapping("{teacherId}/edit")
    public String editTeacherGet(@PathVariable Integer teacherId,
                                 Model model) {
        Teacher teacher = teacherService
                .findById(teacherId)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("No se encuentra el profesor con id %d", teacherId)
                ));
        NewTeacherModel teacherModel = TeacherMapper.map(teacher);

        model.addAttribute("teacher", teacherModel);
        model.addAttribute("teacherId", teacherId);

        return "teachers/edit";
    }

    @PostMapping("{teacherId}/edit")
    public String editTeacherPost(@PathVariable Integer teacherId, @ModelAttribute("teacher") NewTeacherModel newTeacherModel, Model model) {
        try {
            teacherService.update(teacherId, newTeacherModel);
        } catch (Exception e) {
            model.addAttribute("error", String.format("Se ha producido un error: %s", e.getMessage()));
            return "teachers/edit";
        }
        return "redirect:/teachers";
    }

    @ModelAttribute("departments")
    public List<Department> getAllDepartments() {
        return departmentService.findAll();
    }
}