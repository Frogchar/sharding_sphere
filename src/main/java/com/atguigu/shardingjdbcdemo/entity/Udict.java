package com.atguigu.shardingjdbcdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@TableName(value = "t_udict")
@Accessors(chain = true)
public class Udict {
    private Long dictid;
    private String ustatus;
    private String uvalue;
}
