package com.example.demo.mapper;

import com.example.demo.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    public User login(User user);
    public List<User> getUserListAllInOne(UserListParam userListParam);
    public Integer register(User user);
    public Integer selectCount(UserListParam userListParam);
    public Integer deleteUser2(List<Integer> id);
    public int updateUserList(User user);

    @Select("select * from user where id=#{id}")
    public User getUserByid(Integer id);

//    public void timerTest(String dataStr);

    public List<Level> getlevelList();
    public List<Major> getmajorList();
    public List<Class_> getclassList();
    public List<Department> getdepartmentList();



}
