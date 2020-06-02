package com.atguigu.shardingjdbcdemo;

import com.atguigu.shardingjdbcdemo.entity.Course;
import com.atguigu.shardingjdbcdemo.entity.Udict;
import com.atguigu.shardingjdbcdemo.entity.User;
import com.atguigu.shardingjdbcdemo.mapper.CourseMapper;
import com.atguigu.shardingjdbcdemo.mapper.UdictMapper;
import com.atguigu.shardingjdbcdemo.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Resource
    private CourseMapper courseMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private UdictMapper udictMapper;

    /**
     *
     */
    @Test
    public void test5() {
//        int insert = udictMapper.insert(new Udict().setUstatus("是你").setUvalue("123"));
        QueryWrapper<Udict> wrapper = new QueryWrapper<>();
        wrapper.eq("dictid", 474601378661007361L);
        Udict udict = udictMapper.selectOne(wrapper);
        System.err.println(udict);
    }

    /**
     * 垂直
     */
    @Test
    public void test4() {
        int insert = userMapper.insert(new User().setUsername("秋秋").setUstatus("是你吧"));
    }

    /**
     * 水平分库测试
     */
    @Test
    public void test2() {
        int insert = courseMapper.insert(new Course().setUserId(200L).setCstatus("世界上只有一种病").setCname("穷病"));
        int insert1 = courseMapper.insert(new Course().setUserId(201L).setCstatus("埃博拉").setCname("要人命"));
    }

    @Test
    public void test3() {
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.eq("cid", 474582912184877057L);
        Course course = courseMapper.selectOne(wrapper);
        System.err.println(course);

    }

    /**
     * 水平分表测试
     */
    @Test
    public void test1() {
        for (int i = 0; i < 10; i++) {
            int insert = courseMapper.insert(new Course().setCname("JAVA").setCstatus("跳出舒适圈"+i).setUserId(100L));
        }

    }

}
