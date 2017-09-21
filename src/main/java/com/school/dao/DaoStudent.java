package com.school.dao;
import com.school.models.User;

public class DaoStudent extends UserDao {

    private User student;

    public DaoStudent (User student) {this.student = student;}




    public void save(){
        save(student);
    }
}
