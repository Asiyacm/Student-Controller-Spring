package com.example.studentappnew_backend.dao;

import com.example.studentappnew_backend.Model.Students;
import org.springframework.data.repository.CrudRepository;

public interface StudentsDao extends CrudRepository<Students,Integer> {
}
