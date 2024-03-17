package com.jackson.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    //主键
    private Long id;
    //微信用户唯一标识
    private String openid;
    //用户姓名
    private String name;
    //用户电话号码
    private String phone;
    //用户性别
    private String sex;
    //用户身份证号
    private String idNumber;
    //用户头像
    private String avatar;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}
