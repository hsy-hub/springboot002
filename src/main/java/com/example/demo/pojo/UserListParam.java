package com.example.demo.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data //系统默认的方式
@NoArgsConstructor
public class UserListParam extends User {
    private int page;
    private int rows;
    private Integer pagesize;
    private Integer pageStart;

    public Integer getPageStart(){ //自定义覆盖方式重写get
      return pageStart = (page - 1) * rows;
    }

    public Integer getPagesize(){
        return rows;
    }
}
