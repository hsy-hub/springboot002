package com.example.demo.service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired //自动装配
    UserMapper userMapper; //在spring容器中加载mapper实例

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }


    @Override
    public List<User> getUserListAllInOne(UserListParam userListParam) {
        return userMapper.getUserListAllInOne(userListParam);
    }


    @Autowired
    JavaMailSenderImpl mailSender;
    //发送简单邮件
    @Override
    public Integer register(User user) {
        return userMapper.register(user);
//        Integer i = userMapper.register(user);
//        if (i>0){
//            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//            simpleMailMessage.setTo(user.getEmail());
//            simpleMailMessage.setFrom("3118068186@qq.com");
//            simpleMailMessage.setSubject("注册成功");
//            simpleMailMessage.setText("欢迎使用");
//            //发送简单邮件
//            mailSender.send(simpleMailMessage);
//        } else {
//            //失败逻辑
//        }
//        return i;
    }



//
//    //发送多媒体邮件
//    public void sendMimeMessageEmail() throws MessagingException {
//        MimeMessage mimeMessage = mailSender.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
//        mimeMessageHelper.setTo("3118068186@qq.com");
//        mimeMessageHelper.setFrom("3118068186@qq.com");
//        mimeMessageHelper.setSubject("发送邮件");
//        mimeMessageHelper.setText("<a href='http//localhost:8086/mytest/page/login.html'>发送邮件</a>");
//        mimeMessageHelper.addAttachment("cat.jpg",new File("C:\\Users\\爱笑的女孩\\Pictures\\Saved Pictures\\cat.jpg"));
//        mailSender.send(mimeMessage);
//    }


//java的定时任务等灵活 参数更简单 timertask
//    @Override
//    public void timerTest(String dataStr) {
//        //Timer计时器
//        Timer timer = new Timer();
//        Date d = null;
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
//        try {
//            d=format.parse(dataStr);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        //计时任务
////        timer.schedule(timerTask,0,1000);
//        TimerTask timerTask = new TimerTask() {
//            @SneakyThrows
//            @Override
//            public void run() {
//                sendMimeMessageEmail();
//                System.out.println("执行了发邮件");
//            }
//        };
//        timer.schedule(timerTask, d);
//    }






    @Override
    public Integer selectCount(UserListParam userListParam) {
        return userMapper.selectCount(userListParam);
    }


    @Override
    public Integer deleteUser2(List<Integer> id) {
        return userMapper.deleteUser2(id);
    }

    @Override
    public int updateUserList(User user) {
        return userMapper.updateUserList(user);
    }

    @Override
    public User getUserByid(Integer id) {
        return userMapper.getUserByid(id);
    }

    @Override
    public List<Level> getlevelList() {
        return userMapper.getlevelList();
    }

    @Override
    public List<Major> getmajorList() {
        return userMapper.getmajorList();
    }

    @Override
    public List<Class_> getclassList() {
        return userMapper.getclassList();
    }

    @Override
    public List<Department> getdepartmentList() {
        return userMapper.getdepartmentList();
    }


}
