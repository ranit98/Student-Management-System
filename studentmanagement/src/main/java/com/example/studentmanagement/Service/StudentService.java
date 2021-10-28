package com.example.studentmanagement.Service;

import com.example.studentmanagement.Repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.studentmanagement.Entity.StudentEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;

    public List<StudentEntity> getStudentEntities(){
        List<StudentEntity> studentEntities = new ArrayList<>();
        for(StudentEntity studentEntity : studentRepository.findAll()){
            studentEntities.add(studentEntity);
        }
        return studentEntities;
    }

    public Optional<StudentEntity> getStudentEntitybyId(Long id){
        return studentRepository.findById(id);
    }

    public StudentEntity insert(StudentEntity studentEntity){
        return studentRepository.save(studentEntity);
    }

    public void updateStudent(Long id,StudentEntity studentEntity){
        StudentEntity student = studentRepository.findById(id).get();
        student.setName(studentEntity.getName());
        student.setStandard(studentEntity.getStandard());
        student.setSection(studentEntity.getSection());
        student.setGender(studentEntity.getGender());
        studentRepository.save(student);
    }

    public void deleteStudentEntity(Long id){
        studentRepository.deleteById(id);
    }

}
