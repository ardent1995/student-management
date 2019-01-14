package se.indpro.service;

import se.indpro.model.Student;

import java.util.List;

public interface StudentService {
    void addAStudent(Student student);
    void deleteAStudent(int rollNo);
    void updateAStudent(int rollNo, Student student);
    List<Student> retrieveStudents();
}
