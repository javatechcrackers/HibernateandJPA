package com.igate.entity;

import java.util.*;

public class Group {
  private int id;
  private String name;
  private Set students;    // many students  in a group

  public Group(){
  }

  public Group(String name) {
    this.name = name;
  }

  public void setId(int i) {
    id = i;
  }

  public int getId() {
    return id;
  }

  public void setName(String n) {
    name = n;
  }

  public String getName() {
    return name;
  }

  public void setStudents(Set l) {
    students = l;
  }

  public Set getStudents() {
    return students;
  }
}