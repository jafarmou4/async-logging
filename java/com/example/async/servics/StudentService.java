package com.example.async.servics;

import com.example.async.Initializer;
import com.example.async.aop.Loggable;
import com.example.async.domain.Student;
import com.example.async.repo.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final List<String> loggableAPIs;

    public StudentService(StudentRepository studentRepository, Initializer initializer) {
        this.studentRepository = studentRepository;
        this.loggableAPIs = initializer.getLoggableAPIs();
    }

    @Async
    public Student createStudent(String name) {
        System.out.println("111");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("222");
        return this.studentRepository.save(new Student(name));
    }

//    @Async
//    public CompletableFuture<Student> createStudent(String name) {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return CompletableFuture.completedFuture(this.studentRepository.save(new Student(name)));
//    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Loggable
    public Student getById(int id) {
        return studentRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
