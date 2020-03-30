package com.example.demo.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Course {
    private Integer id;
    private Integer courselistId;
    private Integer credit;
    private String address;
    private Integer majorId;
    private String userName;
    private Major major;
    private CourseList courseList;
}
