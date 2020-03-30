package com.example.demo.service;

import com.example.demo.pojo.*;

import java.util.List;

public interface CourseService {
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
    public CourseList getCourseByid(Integer id);

}
