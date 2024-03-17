package com.jackson.service.impl;

import com.jackson.entity.Category;
import com.jackson.mapper.CategoryMapper;
import com.jackson.result.PageResult;
import com.jackson.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void updateCategory(Category category) {
        categoryMapper.updateCategory(category);
    }

    @Override
    public PageResult selectListCategory(String name, Integer type, Integer pageSize, Integer page) {
        Integer total = categoryMapper.getTotal();
        Integer start = (page - 1) * pageSize;
        List<Category> list = categoryMapper.selectListCategory(name, type, pageSize, start);
        return new PageResult(total, list);
    }

    @Override
    public void updateStatus(Integer status) {
        categoryMapper.updateStatus(status);
    }
}
