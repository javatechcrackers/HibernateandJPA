package com.igate.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.*;

@Entity
public class Department {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;

    @OneToMany(mappedBy="department")
    private Collection<Student> students;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String deptName) {
        this.name = deptName;
    }

    public Collection<Student> getStudents() {
      return students;
    }

    public void setStudent(Collection<Student> students) {
      this.students = students;
    }

    public String toString() {
        return "Department id: " + getId() + 
               ", name: " + getName();
    }
}