package com.example.async.web;

import com.example.async.domain.Student;
import com.example.async.servics.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAll() {
        return this.studentService.getStudents();
    }

    @GetMapping("/{id}")
    public Student getOne(@PathVariable("id") int id) {
        return this.studentService.getById(id);
    }

    @PostMapping
    public Student createNew(@RequestBody StudentDto studentDto) {
        return this.studentService.createStudent(studentDto.getName());
    }
}
