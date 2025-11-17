package com.example.demo.service;

import com.example.demo.converter.StudentConverter;
import com.example.demo.dao.Student;
import com.example.demo.dao.StudentRepository;
import com.example.demo.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public StudentDTO getStudentDTOById(long id) {
        Student student = studentRepository.findById(id).orElseThrow(RuntimeException::new);
        return StudentConverter.convertStudent(student);
    }

    @Override
    public Long addNewStudent(StudentDTO studentDTO) {
        List<Student> students = studentRepository.findByEmail(studentDTO.getEmail());
        if (!CollectionUtils.isEmpty(students)) {
            throw new IllegalStateException("email: " + studentDTO.getEmail() + " has been taken");
        }
        Student student = studentRepository.save(StudentConverter.convertStudent(studentDTO));
        return student.getId();
    }

    @Override
    public void deleteStudentById(long id) {
        studentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("id: " + id + " doesn't exist!"));
        studentRepository.deleteById(id);
    }

    @Override
    // @Transactional 是用于声明事务管理的核心注解，
    // 它可以简化数据库事务的控制，确保一系列数据库操作要么全部成功提交，要么全部失败回滚，从而保证数据的一致性。
    @Transactional
    public StudentDTO updateStudentDTO(long id, String name, String email) {
        Student studentDB = studentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("id: " + id + " doesn't exist!"));
        if (StringUtils.hasLength(name) && !studentDB.getName().equals(name)) {
            studentDB.setName(name);
        }
        if (StringUtils.hasLength(email) && !studentDB.getEmail().equals(email)) {
            studentDB.setEmail(email);
        }
        Student student = studentRepository.save(studentDB);
        return StudentConverter.convertStudent(student);
    }

}
