package com.githungo.thymeleaf.config;

import com.githungo.thymeleaf.controller.CourseController;
import com.githungo.thymeleaf.model.Course;
import com.githungo.thymeleaf.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CourseConfig {
    @Bean
    CommandLineRunner commandLineRunner(CourseRepository courseRepository){
        return args -> {
            Course CompSci = new Course(
                    "Computer Science",
                    "COSC"
            );
            Course AppliedCompSci = new Course(
                    "Applied Computer Science",
                    "ACSC"
            );
            Course Law = new Course(
                    "Law",
                    "LAW"
            );
            Course BusinessMng = new Course(
                    "Business Management",
                    "BCMS"
            );
            Course ElectricalEng = new Course(
                    "Electrical Engineering",
                    "ELCI"
            );

            courseRepository.saveAll(
                    List.of(CompSci, AppliedCompSci, Law, BusinessMng, ElectricalEng )
            );
        };

    }
}
