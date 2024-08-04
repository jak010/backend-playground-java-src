package com.board.boardserver.controller;

import com.board.boardserver.aop.LoginCheck;
import com.board.boardserver.dto.PostDTO;
import com.board.boardserver.dto.UserDto;
import com.board.boardserver.dto.response.CommonResponse;
import com.board.boardserver.service.impl.PostServiceImpl;
import com.board.boardserver.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private final UserServiceImpl userService;

    private final PostServiceImpl postService;

    public PostController(UserServiceImpl userService, PostServiceImpl postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    @LoginCheck(type = LoginCheck.UserType.USER)
    public ResponseEntity<CommonResponse<PostDTO>> registerPost(String accountId,
                                                                @RequestBody PostDTO postDTO
    ) {
        postService.register(accountId, postDTO);
        CommonResponse<PostDTO> commonResponse = new CommonResponse<>(
                HttpStatus.OK,
                "SUCCESS",
                "registerPost"
                , postDTO
        );
        return ResponseEntity.ok(commonResponse);
    }

    @GetMapping("my-posts")
    @LoginCheck(type = LoginCheck.UserType.USER)
    public ResponseEntity<CommonResponse<List<PostDTO>>> myPostInfo(String accountId) {
        UserDto memberinfo = userService.getUserInfo(accountId);
        List<PostDTO> postDTOList = postService.getMyPosts(memberinfo.getId());

        CommonResponse<List<PostDTO>> commonResponse = new CommonResponse<>(
                HttpStatus.OK, "SUCCESS", "myPostInfo", postDTOList
        );

        return ResponseEntity.ok(commonResponse);

    }


}
