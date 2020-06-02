package com.atguigu.shardingjdbcdemo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author SC
 * @Date 2020/6/1 22:30
 **/
@Data
@Accessors(chain = true)
public class Course {
    private Long cid;
    private String cname;
    private Long userId;
    private String cstatus;
}
