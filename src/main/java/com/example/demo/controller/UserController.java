package com.example.demo.controller;

import com.example.demo.pojo.*;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController //默认所有contrller返回的都是json对象
//@Controller //注解该类时控制器 dispacter会自动过滤
public class UserController {
    @Autowired //自动装配userService对象
    UserService userService;

    /**
     * 用户登录
     * @param user
     * @return
     */
    @PostMapping("login")
//    @ResponseBody
    public  Map<String,Object> Login(@RequestBody User user){
        Map<String,Object> map = new HashMap<>();
        User loginUser = userService.login(user);
        if (loginUser != null){
            String token = JwtUtil.sign(loginUser);//登录成功之后生成token
            map.put("code",1);
            map.put("msg","登录成功");
            map.put("data",loginUser);
            map.put("token",token);//传给前端
        }else{
            map.put("code",-1);
            map.put("msg","登录失败");
            map.put("data",null);
        }
        return map;
    }
//    @RequestMapping("/")
//    public String loginPage(){
//        return "login";
//    }    //不推荐这种方式 因为前后端开发没有完全分开


//用户管理
    /**
     * 列表 分页 查询
     * @param userListParam
     * @return
     */
    //   @RequestMapping("getUserList") //包括get post delte
    //   @ResponseBody //返回的是对象不是路径
    @PostMapping("getUserListAllInOne") //请求的映射   //将参数封装成userListParam对象
    public Map<String,Object> getUserListAllInOne(UserListParam userListParam){ //返回必须是json对象(键值)
        Map<String,Object> remap = new HashMap<>();
        Integer count = userService.selectCount(userListParam);
        List<User> userListPage = userService.getUserListAllInOne(userListParam);
        remap.put("rows",userListPage);
        remap.put("total",count);
        return remap;
    }

//  @GetMapping("getUserByid/{id}") //通过路径传参，跟@PathVariable中的id名字一致
//    public User getUserByid(@PathVariable("id") Integer id){ //通过PathVariable注解进行映射
//        User userByid = userService.getUserByid(id);
//        return userByid;
//    }

    @PostMapping("getUserByid")
    public Map<String,Object> getUserByid(Integer id){
        Map<String,Object> map = new HashMap<>();
        User userByid = userService.getUserByid(id);
        if (userByid != null){
            map.put("code",1);
            map.put("data",userByid);
        }else{
            map.put("code",-1);
            map.put("data",null);
        }
        return map;
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("register")
    public Map<String,Object> register(User user){
        Map<String,Object> map=new HashMap<>();
        Integer result=userService.register(user);
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
     * 添加
     * @param user
     * @return
     */
    @PostMapping("addUser")
    public Map<String,Object> addUser(User user){
        Map<String,Object> map=new HashMap<>();
        Integer result=userService.register(user);
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
    @PostMapping("deleteUser2")
    public int deleteUser(String[] ids) { //ids是前台参数的名字
        //因为前台传的是数组所以用String[]
        List<Integer> ids_l = new ArrayList<>();
        for (String id : ids){
                ids_l.add(Integer.parseInt(id));//String转成int放入list对象
        }
        return userService.deleteUser2(ids_l);
    }

    /**
     * 根据id修改用户信息
     * @param user
     * @return
     */
    @PostMapping("updateUserList")
    public Map<String,Object> updateUserList(User user) {
        Map<String,Object> map=new HashMap<>();
        map.put("code",userService.updateUserList(user));
        return map;
    }

//    @GetMapping("testTimerTask")
//    public String timerTest(){
//        String dataStr = "2020-03-11 22:39:17.250";
//        userService.timerTest(dataStr);
//        return "成功了";
//    }

    @GetMapping("getlevelList")
    public List<Level> getlevelList(){
        return userService.getlevelList();
    }
    @GetMapping("getmajorList")
    public List<Major> getmajorList(){
        return userService.getmajorList();
    }
    @GetMapping("getclassList")
    public List<Class_> getclassList(){
        return userService.getclassList();
    }@GetMapping("getdepartmentList")
    public List<Department> getdepartmentList(){
        return userService.getdepartmentList();
    }


}
