package com.example.studentmanagement.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private int standard;
    private char section;
    private char gender;

    /*public StudentEntity(String name,int standard,char section,char gender){
        this.name = name;
        this.standard = standard;
        this.section = section;
        this.gender = gender;
    }

    public StudentEntity() {
    }*/

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getStandard(){
        return standard;
    }

    public void setStandard(int standard){
        this.standard = standard;
    }

    public char getSection(){
        return section;
    }

    public void setSection(char section){
        this.section = section;
    }

    public char getGender(){
        return gender;
    }

    public void setGender(char gender){
        this.gender = gender;
    }

    
}
