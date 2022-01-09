package com.example.demo.service;



import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentServiceImpl implements  StudentService{

    @Autowired
    private StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public void save(Student student) {
        studentDao.save(student);
    }

    @Override
    public Student get(long id) {
        return studentDao.getById(id);
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        Iterator<Student> studentIterator = studentDao.findAll().iterator();
        while (studentIterator.hasNext()) {
            students.add(studentIterator.next());
        }
        return students;
    }

    @Override
    public List<Student> getAllStudentsByGroup(long groupId) {
        return studentDao.findByGroupId(groupId);
    }

    @Override
    public boolean update(Student student) {
        if(studentDao.existsById(student.getId())){
            studentDao.save(student);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        if(studentDao.existsById(id)){
            studentDao.deleteById(id);
            return true;
        }else {
            return false;
        }

    }

}
