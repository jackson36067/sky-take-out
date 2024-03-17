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
public class Employee {
    //主键
    private Long id;
    //员工姓名
    private String name;
    //员工用户名
    private String username;
    //密码
    private String password;
    //员工电话
    private String phone;
    //员工性别
    private String sex;
    //员工身份证号
    private String idNumber;
    //员工状态
    private Integer status;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    //最后操作时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    //创建用户
    private Long createUser;
    //最后操作用户
    private Long updateUser;
}
