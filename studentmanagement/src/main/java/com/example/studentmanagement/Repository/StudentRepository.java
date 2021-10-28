package com.example.studentmanagement.Repository;

import com.example.studentmanagement.Entity.StudentEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity,Long>{
    
}
