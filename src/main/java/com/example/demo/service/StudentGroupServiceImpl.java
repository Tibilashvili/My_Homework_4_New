package com.example.demo.service;


import com.example.demo.dao.StudentGroupDao;
import com.example.demo.model.StudentGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentGroupServiceImpl implements StudentGroupService {

    @Autowired
    private StudentGroupDao studentGroupDao;

    StudentGroupServiceImpl(StudentGroupDao studentGroupDaoImpl){
        this.studentGroupDao = studentGroupDaoImpl;
    }


    @Override
    public void save(StudentGroup studentGroup) {
        studentGroupDao.save(studentGroup);
    }

    @Override
    public StudentGroup get(long id) {
        return studentGroupDao.getById(id);
    }

    @Override
    public List<StudentGroup> getAll() {
        List<StudentGroup> groups = new ArrayList<>();
        Iterator<StudentGroup> studentGroupIterator = studentGroupDao.findAll().iterator();
        while (studentGroupIterator.hasNext()){
            groups.add(studentGroupIterator.next());
        }
        return groups;
    }


    @Override
    public boolean update(StudentGroup group, long id) {
        if (studentGroupDao.existsById(id)){
            group.setId(id);
            studentGroupDao.save(group);
             return true;
        }
        return false;
    }


    @Override
    public boolean delete(long id) {
        if (studentGroupDao.existsById(id)) {
            studentGroupDao.deleteById(id);
            return true;
        }
        return false;
    }
}
