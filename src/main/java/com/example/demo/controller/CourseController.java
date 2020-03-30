package com.example.demo.controller;

import com.example.demo.pojo.*;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController //默认所有contrller返回的都是json对象
public class CourseController {
    @Autowired
    CourseService courseService;

//    选课列表
    /**
     * 列表 分页 查询
     * @param courseParam
     * @return
     */
    @PostMapping("getCourseAllInOne") //请求的映射   //将参数封装成userListParam对象
    public Map<String,Object> getCourseAllInOne(CourseParam courseParam){ //返回必须是json对象(键值)
        Map<String,Object> map = new HashMap<>();
        Integer count = courseService.selectCount(courseParam);
        List<Course> courseListPage = courseService.getCourseAllInOne(courseParam);
        map.put("rows",courseListPage);
        map.put("total",count);
        return map;
    }

    @GetMapping("getMajorList")
    public List<Major> getMajorList(){
        return courseService.getMajorList();
    }

    @GetMapping("getCourseList")
    public List<CourseList> getCourseList(Integer majorId){
        return courseService.getCourseList(majorId);
    }

    /**
     * 添加
     * @param course
     * @return
     */
    @PostMapping("addCourse")
    public Map<String,Object> addCourse(Course course){
        Map<String,Object> map=new HashMap<>();
        Integer result=courseService.addCourse(course);
        if (result > 0){
            map.put("code",1);
            map.put("msg","添加成功");
        }else {
            map.put("code",-1);
            map.put("msg","添加失败");
        }
        map.put("data",result);
        return map;
    }

    /**
     * 根据id删除
     * @param ids
     * @return
     */
    @PostMapping("deleteCourse")
    public int deleteUser(String[] ids) { //ids是前台参数的名字
        //因为前台传的是数组所以用String[]
        List<Integer> ids_l = new ArrayList<>();
        for (String id : ids){
            ids_l.add(Integer.parseInt(id));//String转成int放入list对象
        }
        return courseService.deleteCourse(ids_l);
    }




//课程列表
    /**
     * 列表 分页 查询
     * @param courseListParam
     * @return
     */
    @PostMapping("getCourseListAllInOne") //请求的映射   //将参数封装成userListParam对象
    public Map<String,Object> getCourseListAllInOne(CourseListParam courseListParam){ //返回必须是json对象(键值)
        Map<String,Object> map = new HashMap<>();
        Integer count = courseService.selectCount1(courseListParam);
        List<CourseList> courseListPage = courseService.getCourseListAllInOne(courseListParam);
        map.put("rows",courseListPage);
        map.put("total",count);
        return map;
    }

    @PostMapping("getCourseByid")
    public Map<String,Object> getCourseByid(Integer id){
        Map<String,Object> map = new HashMap<>();
        CourseList courseListByid = courseService.getCourseByid(id);
        if (courseListByid != null){
            map.put("code",1);
            map.put("data",courseListByid);
        }else{
            map.put("code",-1);
            map.put("data",null);
        }
        return map;
    }

    /**
     * 添加课程
     * @param courseList
     * @return
     */
    @PostMapping("addCourseList")
    public Map<String,Object> addCourseList(CourseList courseList){
        Map<String,Object> map=new HashMap<>();
        Integer result=courseService.addCourseList(courseList);
        if (result > 0){
            map.put("code",1);
            map.put("msg","注册成功");
        }else {
            map.put("code",-1);
            map.put("msg","失败");
        }
        map.put("data",result);
        return map;
    }
    /**
     * 根据id删除
     * @param ids
     * @return
     */
    @PostMapping("deleteCourseList")
    public int deleteCourseList(String[] ids) { //ids是前台参数的名字
        //因为前台传的是数组所以用String[]
        List<Integer> ids_l = new ArrayList<>();
        for (String id : ids){
            ids_l.add(Integer.parseInt(id));//String转成int放入list对象
        }
        return courseService.deleteCourseList(ids_l);
    }

    /**
     * 根据id修改用户信息
     * @param courseList
     * @return
     */
    @PostMapping("updateCourseList")
    public Map<String,Object> updateCourseList(CourseList courseList) {
        Map<String,Object> map=new HashMap<>();
        map.put("code",courseService.updateCourseList(courseList));
        return map;
    }
}
