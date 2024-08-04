package com.board.boardserver.controller;

import com.board.boardserver.aop.LoginCheck;
import com.board.boardserver.dto.UserDto;
import com.board.boardserver.dto.request.UserDeleteId;
import com.board.boardserver.dto.request.UserLoginRequest;
import com.board.boardserver.dto.request.UserUpdatePasswordRequest;
import com.board.boardserver.dto.response.LoginResponse;
import com.board.boardserver.dto.response.UserInfoResponse;
import com.board.boardserver.service.impl.UserServiceImpl;
import com.board.boardserver.utils.SessionUtil;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@Log4j2
public class UserController {


    private final UserServiceImpl userService;
    private static LoginResponse loginResponse;


    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public void signup(@RequestBody UserDto userDto) {
        if (UserDto.hasNullDataBeforeRegister(userDto)) {
            throw new RuntimeException("회원가입 정보를 확인해주세요");
        }
        userService.register(userDto);
    }

    @PostMapping("/sign-in")
    @ResponseStatus(HttpStatus.CREATED)
    public HttpStatus login(
            @RequestBody UserLoginRequest userLoginRequest,
            HttpSession session
    ) {
        ResponseEntity<LoginResponse> responseEntity = null;
        String id = userLoginRequest.getUserId();
        String password = userLoginRequest.getPassword();
        LoginResponse loginResponse;

        UserDto userInfo = userService.login(id, password);

        if (userInfo == null) {
            return HttpStatus.NOT_FOUND;
        } else if (userInfo != null) {
            loginResponse = LoginResponse.success(userInfo);
            if (userInfo.getStatus() == (UserDto.Status.ADMIN)) {
                SessionUtil.setLoginAdminId(session, id);
            } else {
                SessionUtil.setLoginMemberId(session, id);
            }
            responseEntity = new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK);
        } else {
            throw new RuntimeException("로그인이 실패되었다.");
        }
        return HttpStatus.OK;
    }

    @GetMapping("my-info")
    public UserInfoResponse memberInfo(HttpSession session) {
        String id = SessionUtil.getLoginMemberId(session);
        if (id == null) {
            id = SessionUtil.getLoginAdminId(session);
        }
        UserDto memberInfo = userService.getUserInfo(id);
        return new UserInfoResponse(memberInfo);
    }

    @PutMapping("logout")
    public void logout(HttpSession session) {
        SessionUtil.clear(session);
    }


    @PatchMapping("password")
    @LoginCheck(type = LoginCheck.UserType.USER)
    public ResponseEntity<LoginResponse> updateUserPassword(
            String accountId,
            @RequestBody UserUpdatePasswordRequest userUpdatePasswordRequest,
            HttpSession session
    ) {
        ResponseEntity<LoginResponse> responseEntity = null;
        String id = accountId;
        String beforePassword = userUpdatePasswordRequest.getBeforePassword();
        String afterPassword = userUpdatePasswordRequest.getAfterPassword();

        try {
            userService.updatePassword(id, beforePassword, afterPassword);
            ResponseEntity.ok(new ResponseEntity<LoginResponse>(HttpStatus.OK));
        } catch (IllegalArgumentException e) {
            log.error("updatePassword 실패", e);
            responseEntity = new ResponseEntity<LoginResponse>(HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }


    @DeleteMapping("")
    public ResponseEntity<LoginResponse> deleteId(
            @RequestBody UserDeleteId userDeleteId,
            HttpSession session
    ) {
        ResponseEntity<LoginResponse> responseEntity = null;
        String id = SessionUtil.getLoginMemberId(session);

        try {
            userService.deleteId(id, userDeleteId.getPassword());
            responseEntity = new ResponseEntity<LoginResponse>(HttpStatus.OK);
        } catch (RuntimeException e) {
            log.error("delteId 실패");
            responseEntity = new ResponseEntity<LoginResponse>(HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }

}

