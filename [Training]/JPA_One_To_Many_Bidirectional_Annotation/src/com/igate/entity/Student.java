package com.igate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Student {
  @Id @GeneratedValue(strategy=GenerationType.AUTO)
  private int id;
  private String name;

  @ManyToOne (cascade=CascadeType.ALL)
  private Department department;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }



  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public String toString() {
    return "\n\nID:" + id + "\nName:" + name + "\n\n" + department;
  }
}