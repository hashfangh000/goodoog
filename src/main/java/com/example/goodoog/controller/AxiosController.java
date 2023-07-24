package com.example.goodoog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.goodoog.dto.R;
import com.example.goodoog.entity.Student;
import com.example.goodoog.entity.StudentQueryDto;
import com.example.goodoog.mapper.StudentsMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: fanghao
 * @create: 2023/7/10
 **/
@RestController
@CrossOrigin(value = "http://localhost:7071", allowCredentials = "true")
public class AxiosController {

    @Resource
    private StudentsMapper studentsMapper;

    @PostMapping("/api/a3")
    public String testApiA3(@RequestHeader("Authorization")String authorization) {
        System.out.println("authorization : 头" + authorization);
        return "post request";
    }

    @PostMapping("/api/a4")
    public String testApiA4(String name, Integer age) {
        System.out.println("name:" + name + " ,age: " + age);
        return "post request";
    }
    // 创建A5 对象
//    @PostMapping("/api/a5")
//    public String testApiA5(@RequestBody A5 a5) {
//        System.out.println("name:" + name + " ,age: " + age);
//        return "post request";
//    }

    @PostMapping("/api/a5")
    public String testApiA5(String name, Integer age) {
        System.out.println("name:" + name + " ,age: " + age);
        return "post request";
    }

    @PostMapping("/api/a6set")
    public String testApiA6set(HttpSession session) {
        session.setAttribute("name", "章三");

        return "post request";
    }

    @PostMapping("/api/a6get")
    public String testApiA6get(HttpSession session) {
        System.out.println(session.getId());
        System.out.println(session.getAttribute("name"));
        return "post request";
    }

    @GetMapping("/api/students")
    public R students() {
        return R.ok(studentsMapper.selectList(null).toArray());
    }

    @GetMapping("/api/students/p")
    public R q(StudentQueryDto dto) {
        Page<Student> studentPage = new Page<>(dto.getPage(), dto.getSize());
        List<Student> records = studentsMapper.selectPage(studentPage, null).getRecords();
        return R.ok(
                new HashMap<String, Object>(){{
                    put("list", records);
                    put("total", records.size());}
                }
        );
    }
}
