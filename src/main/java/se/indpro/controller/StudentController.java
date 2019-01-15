package se.indpro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import se.indpro.model.Student;
import se.indpro.repository.StudentRepository;
import se.indpro.service.StudentService;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;


    @GetMapping("/")
    public String studentHome(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "index";
    }

    @PostMapping("/")
    public String addStudent(@RequestParam("rollNo") int rollNo,
                             @RequestParam("name") String name,
                             @RequestParam("department") String department,
                             @RequestParam("phone") Long phone, Model model) {
        studentService.addAStudent(new Student(rollNo, name, department, phone));
        model.addAttribute("success", true);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateStudent(@RequestParam("rollNo") int rollNo,
                                @RequestParam(value = "name", required = false) String name,
                                @RequestParam(value = "department", required = false) String department,
                                @RequestParam(value = "phone", required = false) Long phone, Model model) {

        Student preExistingStudent = studentRepository.findById(rollNo).get();

        if (preExistingStudent == null) {
            model.addAttribute("success", false);
        } else {
            if (!StringUtils.isEmpty(name)) {
                preExistingStudent.setName(name);
            }

            if (!StringUtils.isEmpty(department)) {
                preExistingStudent.setDepartment(department);
            }

            if (!StringUtils.isEmpty(phone)) {
                preExistingStudent.setPhone(phone);
            }
            studentService.updateAStudent(rollNo, preExistingStudent);
            model.addAttribute("success", true);
        }
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteStudent(@RequestParam("rollNo") int rollNo, Model model) {

        Student preExistingStudent = studentRepository.findById(rollNo).get();

        if (preExistingStudent == null) {
            model.addAttribute("success", false);
        } else {
            studentService.deleteAStudent(rollNo);
            model.addAttribute("success", true);
        }
        return "redirect:/";
    }
}
