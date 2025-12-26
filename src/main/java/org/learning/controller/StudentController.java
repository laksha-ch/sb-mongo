package org.learning.controller;

import org.learning.model.Student;
import org.learning.respository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    public StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @GetMapping("/")
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id){
        return studentRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Student saveStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }
}
