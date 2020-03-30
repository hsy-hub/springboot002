package com.example.demo.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
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
}
