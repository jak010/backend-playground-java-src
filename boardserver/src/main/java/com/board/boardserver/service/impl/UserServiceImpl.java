package com.board.boardserver.service.impl;

import com.board.boardserver.dto.UserDto;
import com.board.boardserver.exception.DuplicateIdException;
import com.board.boardserver.mapper.UserProfileMapper;
import com.board.boardserver.service.UserService;
import com.board.boardserver.utils.SHA256Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Log4j2
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserProfileMapper userProfileMapper;


    @Override
    public void register(UserDto userProfile) {
        boolean dupIdResult = isDuplicatedId(userProfile.getUserID());
        if (dupIdResult) {
            throw new DuplicateIdException("중복된 아이디입니다.");
        }
        userProfile.setCreateTime(new Date());
        userProfile.setUserPassword(SHA256Util.encryptionSHA256(userProfile.getUserPassword()));

        int insertCount = userProfileMapper.register(userProfile);

        if (insertCount != 1) {
            log.error("insertMember ERROR {}", userProfile);
            throw new RuntimeException("insertUser ERROR! 회원가입 메서드를 확인해주세요!");
        }
    }

    @Override
    public UserDto login(String id, String password) {
        String cryptoPassword = SHA256Util.encryptionSHA256(password);
        UserDto userDto = userProfileMapper.findByIdAndPassword(id, cryptoPassword);

        return userDto;
    }

    @Override
    public boolean isDuplicatedId(String Id) {
        return userProfileMapper.idCheck(Id) == 1;
    }

    @Override
    public UserDto getUserInfo(String userId) {
        return null;
    }

    @Override
    public void updatePassword(String id, String beforePassword, String afterPassword) {
        String cryptoPassword = SHA256Util.encryptionSHA256(beforePassword);
        UserDto memberInfo = userProfileMapper.findByIdAndPassword(id, cryptoPassword);

        if (memberInfo != null) {
            memberInfo.setUserPassword(afterPassword);
            int InsertCount = userProfileMapper.updatePassword(memberInfo);
        } else {
            log.error("updatePassword ERROR! {}", memberInfo);
            throw new RuntimeException("비밀번호가 일치하지 않습니다");
        }
    }

    @Override
    public void deleteId(String Id, String Password) {
        String cryptoPassword = SHA256Util.encryptionSHA256(Password);
        UserDto memberInfo = userProfileMapper.findByIdAndPassword(Id, cryptoPassword);

        if (memberInfo != null) {
            int deleteCount = userProfileMapper.deleteUserProfile(Id);
        } else {
            log.error("deleteId Error {}", memberInfo);
            throw new RuntimeException("비밀번호가 일치하지 않습니다");
        }
    }
}
