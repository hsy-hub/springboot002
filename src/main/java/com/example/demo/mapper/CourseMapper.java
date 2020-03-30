package com.example.demo.mapper;

import com.example.demo.pojo.*;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface CourseMapper {
//    选课
    public List<Course> getCourseAllInOne(CourseParam courseParam);
    public Integer selectCount(CourseParam courseParam);
    public List<Major> getMajorList();
    public List<CourseList> getCourseList(Integer majorId);
    public Integer addCourse(Course course);
    public Integer deleteCourse(List<Integer> id);


//    课程
    public List<CourseList> getCourseListAllInOne(CourseListParam courseListParam);
    public Integer selectCount1(CourseListParam courseListParam);
    public Integer addCourseList(CourseList courseList);
    public Integer deleteCourseList(List<Integer> id);
    public int updateCourseList(CourseList courseList);
    @Select("select * from courselist where id=#{id}")
    public CourseList getCourseByid(Integer id);
}
