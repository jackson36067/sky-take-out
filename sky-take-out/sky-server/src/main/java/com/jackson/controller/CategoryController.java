package com.jackson.controller;

import com.jackson.entity.Category;
import com.jackson.result.PageResult;
import com.jackson.result.Result;
import com.jackson.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PutMapping("/admin/category")
    public Result<String> updateCategory(@RequestBody Category category) {
        log.info("修改分类:{}", category);
        categoryService.updateCategory(category);
        return Result.success();
    }

    @GetMapping(" /admin/category/page")
    public Result<PageResult> selectListCategory(String name, Integer type,
                                     @RequestParam(defaultValue = "10") Integer pageSize,
                                     @RequestParam(defaultValue = "10") Integer page) {
        PageResult pageResult = categoryService.selectListCategory(name, type, pageSize, page);
        log.info("条件查询分类:{}", pageResult);
        return Result.success(pageResult);
    }

    @PostMapping(" /admin/category/status/{status}")
    public Result<String> updateStatus(@PathVariable Integer status) {
        log.info("修改分类状态:{}", status);
        categoryService.updateStatus(status);
        return Result.success();
    }
}
