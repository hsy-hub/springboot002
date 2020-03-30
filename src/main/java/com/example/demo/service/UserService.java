package com.example.demo.service;

import com.example.demo.pojo.*;

import java.util.List;

public interface UserService {
    public User login(User user);
    public List<User> getUserListAllInOne(UserListParam userListParam);
    public Integer register(User user);
    public Integer selectCount(UserListParam userListParam);
    public Integer deleteUser2(List<Integer> id);
    public int updateUserList(User user);
    public User getUserByid(Integer id);

//    public void timerTest(String dataStr);
    public List<Level> getlevelList();
    public List<Major> getmajorList();
    public List<Class_> getclassList();
    public List<Department> getdepartmentList();

}