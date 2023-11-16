package com.codegym.service;

import com.codegym.model.Student;
import com.codegym.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IStudentService  {



        @Autowired
        IStudentRepository repository;

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Student student) {
        repository.save(student);
    }

    @Override
    public Student findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void remove(Long id) {
        repository.remove(id);
    }

    @Override
    public List<Student> search(String name) {
        return repository.search(name);
    }

}
