package cn.happyOnion801.SSMMusic.service;

import cn.happyOnion801.SSMMusic.bean.User;
import cn.happyOnion801.SSMMusic.bean.UserExample;
import cn.happyOnion801.SSMMusic.dao.UserMapper;
import cn.happyOnion801.SSMMusic.utils.ResultEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.sql.Date;
import java.util.List;

/**
 * Project : SSMMusic
 * Author : HappyOnion801
 * Date : 2021-06-25
 * Blog : https://www.happyOnion801.cn
 */

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    public ResultEntity adminLogin(String username, String password) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(username);
        List<User> users = mapper.selectByExample(userExample);
        ResultEntity res = new ResultEntity();
        if (users.size() == 1) {
            User user = users.get(0);
            if (user.getType() == 1) {
                if (user.getStatus() == 1) {
                    if (user.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {
                        res.setDate(user);
                        res.setMsg("登录成功");
                    } else
                        res.setMsg("密码错误");
                } else {
                    res.setMsg("封号");
                }
            } else {
                res.setMsg("你等级不够");
            }
        } else if (users.size() == 0) {
            res.setMsg("用户名错误");
        } else {
            res.setMsg("多用户错误");
        }
        return res;
    }

    public ResultEntity login(String userName, String password) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(userName);
        List<User> users = mapper.selectByExample(userExample);
        ResultEntity res = new ResultEntity();
        if (users.size() == 1) {
            User user = users.get(0);
            if (user.getStatus() == 1) {
                if (user.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {
                    res.setDate(user);
                    res.setMsg("登录成功");
                } else
                    res.setMsg("密码错误");
            } else {
                res.setMsg("封号");
            }
        } else if (users.size() == 0) {
            res.setMsg("用户名错误");
        } else {
            res.setMsg("多用户错误");
        }
        return res;
    }

    public PageInfo<User> showAllUser(int pageNO) {
        PageHelper.startPage(pageNO, 6);
        UserExample userExample = new UserExample();
        userExample.createCriteria().andTypeEqualTo(0);
        List<User> users = mapper.selectByExample(userExample);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        pageInfo.setPrePage(pageInfo.getPrePage() == 0 ? 1 : pageInfo.getPrePage());
        return pageInfo;
    }

    public User getUserByPrimary(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    public boolean hasName(String name) {
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(name);
        List<User> users = mapper.selectByExample(example);
        return !users.isEmpty();
    }

    public boolean save(User user) {
        if (hasName(user.getUserName()))
            return false;
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        user.setCreateTime(new Date(System.currentTimeMillis()));
        user.setUpdateTime(new Date(System.currentTimeMillis()));
        user.setStatus(1);
        user.setType(0);
        int i = mapper.insertSelective(user);
        return i == 1;
    }

    public boolean deleted(Integer id) {
        return mapper.deleteByPrimaryKey(id) == 1;
    }

    public boolean update(User user) {
        if (!this.getUserByPrimary(user.getUid()).getPassword().equals(user.getPassword()))
            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        user.setUpdateTime(new Date(System.currentTimeMillis()));
        return mapper.updateByPrimaryKeySelective(user) == 1;
    }

    public boolean checkUser(User user) {
        if (user == null) return false;
        return mapper.selectByPrimaryKey(user.getUid()) != null;
    }
}