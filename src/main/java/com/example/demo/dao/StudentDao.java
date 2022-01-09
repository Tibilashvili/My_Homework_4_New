package com.example.demo.dao;


import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentDao extends JpaRepository<Student, Long> {

    List<Student> findByGroupId(long groupId);
}
