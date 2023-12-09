package com.example.demo6.Service;

import com.example.demo6.Model.Student;
import com.example.demo6.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public void insertStudent(Student student)
    {
        studentRepository.save(student);
    }
    public List<Student> getStudentsMark()
    {
        return studentRepository.findAll();
    }
}
