package com.igate.entity;

import java.util.*;

public class Student {
  private int id;
  private String info;
  private Group parent;    // only one Group it can belong
  
  public void setParent(Group g) {
    parent = g;
  }
  public Group getParent() {
    return parent;
  }
  public Student(){
  }

  public Student(String info) {
    this.info = info;
  }

  public void setId(int i) {
    id = i;
  }

  public int getId() {
    return id;
  }

  public void setInfo(String n) {
    info = n;
  }

  public String getInfo() {
    return info;
  }
}