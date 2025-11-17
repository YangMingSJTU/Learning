package com.example.demo.controller;

import com.example.demo.Response;
import com.example.demo.dao.Student;
import com.example.demo.dto.StudentDTO;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student/{id}")
    // @PathVariable 用于获取 URL 路径中的动态参数，是处理 RESTful 风格接口时的常用注解。
    public Student getStudentById(@PathVariable long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/studentDTO/{id}")
    // @PathVariable 用于获取 URL 路径中的动态参数，是处理 RESTful 风格接口时的常用注解。
    public Response<StudentDTO> getStudentDTOById(@PathVariable long id) {
        return Response.newSuccess(studentService.getStudentDTOById(id));
    }

    @PostMapping("/studentDTO")
    // @RequestBody 注解用于接收 HTTP 请求体中的数据，并将其自动绑定到控制器方法的参数上，
    // 通常用于处理非表单提交的结构化数据（如 JSON、XML 等）。
    public Response<Long> addNewStudent(@RequestBody StudentDTO studentDTO) {
        return Response.newSuccess(studentService.addNewStudent(studentDTO));
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudentById(@PathVariable long id) {
        studentService.deleteStudentById(id);
    }

    @PutMapping("/student/{id}")
    public Response<StudentDTO> updateStudentDTO(@PathVariable long id,
                                                 @RequestParam(required = false) String name,
                                                 @RequestParam(required = false) String email) {
        return Response.newSuccess(studentService.updateStudentDTO(id, name, email));
    }
}
