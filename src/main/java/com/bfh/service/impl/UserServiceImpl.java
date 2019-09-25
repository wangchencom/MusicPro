package com.bfh.service.impl;

import com.bfh.entity.Content;
import com.bfh.entity.User;
import com.bfh.entity.UserGrade;
import com.bfh.mapper.ContentMapper;
import com.bfh.mapper.UserGradeMapper;
import com.bfh.mapper.UserMapper;
import com.bfh.service.UserService;
import com.bfh.utils.ConstUtil;
import com.bfh.vo.RegisterVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @Author wcc
 * @Time 2019/09/24
 * @Description: 用户业务层
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserGradeMapper userGradeMapper;
    @Autowired
    private ContentMapper contentMapper;


    @Override
    public void updateUserGrade() {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        UserGrade userGrade = userGradeMapper.getUserGrade(user.getUid());

        int newGrade = 1;
        int score = userGrade.getScore();

        if (0 <= score && score <= ConstUtil.LV1) {
            newGrade = 1;
        } else if (ConstUtil.LV1 < score && score <= ConstUtil.LV2) {
            newGrade = 2;
        } else if (ConstUtil.LV2 < score && score <= ConstUtil.LV3) {
            newGrade = 3;
        } else if (ConstUtil.LV3 < score && score <= ConstUtil.LV4) {
            newGrade = 4;
        } else if (ConstUtil.LV4 < score && score <= ConstUtil.LV5) {
            newGrade = 5;
        } else if (ConstUtil.LV5 < score) {
            newGrade = 5;
        }
        userGradeMapper.updateUserGrade(newGrade, user.getUid());


    }

    @Override
    public UserGrade getUserGrade() {
        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        return userGradeMapper.getUserGrade(user.getUid());
    }

    @Override
    public Boolean insertComment(Content content) {

        if (!StringUtils.isEmpty(content.getContent()) && content.getUid() != 0 && content.getMid() != 0) {
            content.setContentTime(new Date());
            contentMapper.insertComment(content);
            return true;
        }
        return false;
    }


    @Override
    public Boolean register(RegisterVo registerVo) {
        User user = null;
        //非空判断，自只做部分非空判断
        if (!StringUtils.isEmpty(registerVo.getEmail()) || !StringUtils.isEmpty(registerVo.getFirst_password())) {
            //两次密码是否一致
            if (registerVo.getFirst_password().equals(registerVo.getSecond_password())) {
                user = new User();
                user.setUserName(registerVo.getUserName());
                user.setEmail(registerVo.getEmail());
                user.setUserPassword(registerVo.getFirst_password());
                user.setUserImage("/images/m0.jpg");
                user.setUserMood("太阳当空照，花儿对我笑");
                userMapper.insertUser(user);
                //初始化用户等级
                UserGrade userGrade = new UserGrade();
                userGrade.setUid(user.getUid());
                userGrade.setGrade(1);//用户初始等级为1
                userGrade.setScore(0);//用户初始积分为0
                userGradeMapper.insertUserGrade(userGrade);
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean checkEmailUsed(String email) {
        Integer uid = userMapper.checkEmailUsed(email);
        return uid != null;
    }

    @Override
    public User login(User user) {
        if (StringUtils.isEmpty(user.getEmail()) ||
                StringUtils.isEmpty(user.getUserPassword())) {
            return null;
        }
        return userMapper.login(user);
    }


    @Override
    public User getUserByUsername(String userName) {
        if (StringUtils.isEmpty(userName)) {
            return null;
        }
        return userMapper.getUserByUsername(userName);
    }
}
