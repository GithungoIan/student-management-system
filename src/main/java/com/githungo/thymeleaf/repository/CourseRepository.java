package com.githungo.thymeleaf.repository;

import com.githungo.thymeleaf.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository  extends JpaRepository<Course, Long> {
    List<Course> findByName(String name);
}
