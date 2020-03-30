package com.example.demo.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseList {
    private Integer id;
    private String courseName;
    private Integer credit;
    private String address;
    private Integer majorId;
    private Major major;
}
