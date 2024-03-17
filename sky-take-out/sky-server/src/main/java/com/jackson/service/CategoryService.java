package com.jackson.service;

import com.jackson.entity.Category;
import com.jackson.result.PageResult;

import java.util.List;

public interface CategoryService {
    void updateCategory(Category category);

    PageResult selectListCategory(String name, Integer type, Integer pageSize, Integer page);

    void updateStatus(Integer status);
}
