package com.example.studentappnew_backend.Controller;

import com.example.studentappnew_backend.Model.Students;
import com.example.studentappnew_backend.dao.StudentsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/")
    public String Homepage() {
        return " Welcome to my website";
    }
@Autowired
private StudentsDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path="/add",consumes = "application/json",produces ="application/json" )
    public String Addpage(@RequestBody Students s) {
        System.out.println(s.getName().toString());
        dao.save(s);
        return " Welcome to  Add";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Students> Viewpage() {
        return (List<Students>) dao.findAll();
    }
}
