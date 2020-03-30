package com.example.demo.service;


import com.example.demo.mapper.CourseMapper;
import com.example.demo.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<Course> getCourseAllInOne(CourseParam courseParam) {
        return courseMapper.getCourseAllInOne(courseParam);
    }

    @Override
    public Integer selectCount(CourseParam courseParam) {
        return courseMapper.selectCount(courseParam);
    }

    @Override
    public List<Major> getMajorList() {
        return courseMapper.getMajorList();
    }

    @Override
    public List<CourseList> getCourseList(Integer majorId) {
        return courseMapper.getCourseList(majorId);
    }

    @Override
    public Integer addCourse(Course course) {
        return courseMapper.addCourse(course);
    }

    @Override
    public Integer deleteCourse(List<Integer> id) {
        return courseMapper.deleteCourse(id);
    }



//    课程
    @Override
    public List<CourseList> getCourseListAllInOne(CourseListParam courseListParam) {
        return courseMapper.getCourseListAllInOne(courseListParam);
    }

    @Override
    public Integer selectCount1(CourseListParam courseListParam) {
        return courseMapper.selectCount1(courseListParam);
    }

    @Override
    public Integer addCourseList(CourseList courseList) {
        return courseMapper.addCourseList(courseList);
    }

    @Override
    public Integer deleteCourseList(List<Integer> id) {
        return courseMapper.deleteCourseList(id);
    }

    @Override
    public int updateCourseList(CourseList courseList) {
        return courseMapper.updateCourseList(courseList);
    }

    @Override
    public CourseList getCourseByid(Integer id) {
        return courseMapper.getCourseByid(id);
    }


}


