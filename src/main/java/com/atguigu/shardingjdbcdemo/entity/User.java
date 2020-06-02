package com.atguigu.shardingjdbcdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@TableName(value = "t_user")
@Accessors(chain = true)
public class User {
    private Long userId;
    private String username;
    private String ustatus;
}
