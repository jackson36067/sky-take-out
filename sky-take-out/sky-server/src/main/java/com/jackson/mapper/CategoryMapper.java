package com.jackson.mapper;

import com.jackson.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CategoryMapper {
    void updateCategory(Category category);

    @Select("select count(*) from category;")
    Integer getTotal();

    List<Category> selectListCategory(String name, Integer type, Integer pageSize, Integer start);

    @Update("update category set status = #{status} where id = #{id}")
    void updateStatus(Integer status);
}
