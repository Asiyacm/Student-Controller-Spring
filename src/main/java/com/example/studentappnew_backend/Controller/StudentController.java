package com.example.studentappnew_backend.Controller;

import com.example.studentappnew_backend.Model.Students;
import com.example.studentappnew_backend.dao.StudentsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> Addpage(@RequestBody Students s) {
        System.out.println(s.getName().toString());
        dao.save(s);
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Students> Viewpage() {
        return (List<Students>) dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search", consumes = "application/json", produces = "application/json")
    public List<Students> Searchpage(@RequestBody Students s) {
        String name = String.valueOf(s.getName());
        System.out.println(name);
        return (List<Students>) dao.SearchStudents(s.getName());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/delete", consumes = "application/json", produces = "application/json")
    public HashMap<String, String>  Deletepage(@RequestBody Students s) {
        String name = String.valueOf(s.getName());
        System.out.println(name);
        dao.delete(s);
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");
        return map;
    }
}
