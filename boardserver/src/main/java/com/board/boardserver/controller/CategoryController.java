package com.board.boardserver.controller;


import com.board.boardserver.aop.LoginCheck;
import com.board.boardserver.dto.CategoryDTO;
import com.board.boardserver.service.impl.CategoryServiceImpl;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@Log4j2
public class CategoryController {

    @Autowired
    private final CategoryServiceImpl categoryService;


    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @LoginCheck(type = LoginCheck.UserType.ADMIN)
    public void registerCategory(String accountId,
                                 @RequestBody CategoryDTO categoryDTO
    ) {
        categoryService.register(accountId, categoryDTO);
    }


    @PatchMapping("{categoryId}")
    @LoginCheck(type = LoginCheck.UserType.ADMIN)
    public void udpateCategories(String accountId,
                                 @PathVariable(name = "categoryId") int categoryId,
                                 @RequestBody CategoryRequest categoryRequest
    ) {
        CategoryDTO categoryDTO = new CategoryDTO(categoryId, categoryRequest.getName(), CategoryDTO.SortStatus.NEWEST, 10, 1);
        categoryService.update(categoryDTO);
    }

    @Getter
    @Setter
    private static class CategoryRequest {
        private int id;
        private String name;
    }


    @DeleteMapping("{categoryId}")
    @LoginCheck(type = LoginCheck.UserType.ADMIN)
    public void deleteCategories(String accountId,
                                 @PathVariable("categoryId") int categoryId
    ) {
        categoryService.delete(categoryId);
    }

}


