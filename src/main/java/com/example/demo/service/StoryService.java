package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Story;
import com.example.demo.repository.StoryRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class StoryService {
    @Autowired
    StoryRepository storyRepository;

    public List<Story> getStoriesForDepartment(String departmentName) {
        return storyRepository.findByDepartmentName(departmentName);
    }
}
