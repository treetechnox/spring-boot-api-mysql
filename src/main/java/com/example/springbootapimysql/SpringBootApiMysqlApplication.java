package com.example.springbootapimysql;

import com.example.springbootapimysql.models.Lecturer;
import com.example.springbootapimysql.models.Student;
import com.example.springbootapimysql.repositories.LecturerRepository;
import com.example.springbootapimysql.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Arrays;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootApiMysqlApplication{

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApiMysqlApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(LecturerRepository lecturerRepository, StudentRepository studentRepository){
        return args -> {
            Lecturer lecturer = new Lecturer("Khireddine","Tarek",3000);

            lecturerRepository.save(lecturer);

            Student student1 = new Student("Treetechnox1","Trek1",(float)101.0);
            Student student2 = new Student("Treetechnox2","Trek2",(float)102.0);
            Student student3 = new Student("Treetechnox3","Trek3",(float)103.0);

            studentRepository.saveAll(Arrays.asList(student1,student2,student3));

            lecturer.getStudents().addAll(Arrays.asList(student1,student2,student3));

            lecturerRepository.save(lecturer);
        };
    }

}
