package com.example.demo.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Major {
    private Integer id;
    private String majorName;
    private Integer departmentId;
}
