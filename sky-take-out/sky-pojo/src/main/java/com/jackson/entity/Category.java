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
public class Category {
    //主键id
    private Long id;
    //分类类型 (1.菜品分类 2.套餐分类)
    private Integer type;
    //分类名称
    private String name;
    //分类顺序
    private Integer sort;
    //分类状态 (0.禁用 1.启用)
    private Integer status;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    //最后修改时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    //创建分类的用户
    private Long createUser;
    //最后修改分类的用户
    private Long updateUser;
}
