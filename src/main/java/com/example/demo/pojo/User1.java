package com.example.demo.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class User1 {
    private Integer id;
    private String loginName;
    private String password;
    private String studentId;
    private String nation;
    private String bloodType;
    private String email;
    private Integer levelId;
    private Integer majorId;
    private Integer classId;
    private Integer departmentId;
    private Integer courseId;
    private Level level;
    private Major major;
    private Class_ class_;
    private Department department;

}
