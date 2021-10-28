package com.example.studentmanagement.Controller;

import java.util.List;
import java.util.Optional;

import com.example.studentmanagement.Entity.StudentEntity;
import com.example.studentmanagement.Service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    
    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentEntity>> getStudentEntities() {
        List<StudentEntity> studentEntities = studentService.getStudentEntities();
        return new ResponseEntity<>(studentEntities, HttpStatus.OK);
    }

    @GetMapping({"/{Id}"})
    public Optional<StudentEntity> getStudent(@PathVariable Long Id) {
        Optional<StudentEntity> student = studentService.getStudentEntitybyId(Id);
        return student;
    }

    @PostMapping
    public StudentEntity saveTodo(@RequestBody StudentEntity studentEntity) {
        StudentEntity student = studentService.insert(studentEntity);
        return student;
    }

    @PutMapping({"/{Id}"})
    public ResponseEntity<StudentEntity> updateTodo(@PathVariable("Id") Long Id, @RequestBody StudentEntity studentEntity) {
        studentService.updateStudent(Id, studentEntity);
        Optional<StudentEntity> student = studentService.getStudentEntitybyId(Id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping({"/{Id}"})
    public ResponseEntity<StudentEntity> deleteTodo(@PathVariable("Id") Long Id) {
        studentService.deleteStudentEntity(Id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
