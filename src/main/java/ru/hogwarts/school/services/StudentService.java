package ru.hogwarts.school.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.models.Student;
import ru.hogwarts.school.models.StudentDTO;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.*;

@Service

public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;
    Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student newStudent) {
        logger.debug("Добавление нового студента: {}", newStudent.getName());
        return studentRepository.save(newStudent);

    }

    public StudentDTO getStudentByID(long id) {
        logger.debug("Вызов поиска студента по ID: {}",id);
        Student student = studentRepository.findById(id).orElse(null);
        return StudentDTO.fromStudent(student);
    }

    public List<StudentDTO> getAllStudents(Integer page, Integer size) {
        logger.info("Вызов списка всех студентов.");
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Student> students = studentRepository.findAll(pageRequest);
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student s : students) {
            StudentDTO studentDTO = StudentDTO.fromStudent(s);
            studentDTOS.add(studentDTO);
        }
        logger.info("Найдено {} студентов", studentDTOS.size());

        return studentDTOS;
    }

    public Student updateStudent(Student updatedStudent) {
        logger.debug("Обновление данных студента {}", updatedStudent.getId());
        return studentRepository.save(updatedStudent);
    }

    public void deleteStudent(Student deleteStudent) {
        logger.debug("Удаление файла студента {}", deleteStudent.getId());
        studentRepository.delete(deleteStudent);
    }

    public List<Student> findStudentsByAge(int age) {
        logger.debug("Запрос на получение студентов с возрастом: {}", age);
        return studentRepository.findStudentsByAge(age);
    }

    public List<Student> findByAgeBetween(int min, int max) {
        logger.debug("Запрос на получение студентов с возрастом междку {} и {} лет.", min,max);
        return studentRepository.findByAgeBetween(min, max);
    }

    public int amountOfStudents() {
        logger.info("Запрос на получение общего количества студентов.");
        return studentRepository.getAmountOfStudents();
    }

    public int getAverageAge() {
        logger.info("Запрос на получение среднего возраста всех студентов.");
        return studentRepository.getAverageAgeOfStudents();
    }

    public List<Student> getYoungestStudents() {
        logger.info("Запрос на получение пяти самых молодых студентов.");
        return studentRepository.getYoungestStudents();
    }
}
