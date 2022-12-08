package com.example.studentappnew_backend.dao;

import com.example.studentappnew_backend.Model.Students;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentsDao extends CrudRepository<Students,Integer> {

    @Query(value = "SELECT * FROM `student` WHERE `name`Like %:name%",nativeQuery = true)
    List<Students>SearchStudents(@Param("name") String name);
@Modifying
@Transactional
    @Query(value = "DELETE FROM `student` WHERE `name`=:name",nativeQuery = true)
   void DeleteStudents(@Param("name") String name);



}
