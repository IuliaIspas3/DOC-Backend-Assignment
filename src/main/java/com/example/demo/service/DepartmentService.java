package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Department;
import com.example.demo.model.Story;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public void init() {
        Department d1 = new Department("Department1");
        Department d2 = new Department("Department2");

        Story s1 = new Story("Story1", "Description1",d1);
        Story s2 = new Story("Story2", "Description2",d2);

        d1.getStories().add(s1);
        d2.getStories().add(s2);

        departmentRepository.save(d1);
        departmentRepository.save(d2);
    }

    public Department getDepartment(String name) {
        init();
        Department temp = null;
        try {
            temp = departmentRepository.findById(name).get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return temp;
    }

    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

}
