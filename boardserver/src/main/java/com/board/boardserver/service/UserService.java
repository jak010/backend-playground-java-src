package com.board.boardserver.service;

import com.board.boardserver.dto.UserDto;

public interface UserService {

    void register(UserDto userProfile);

    UserDto login(String id, String password);

    boolean isDuplicatedId(String Id);

    UserDto getUserInfo(String userId);

    void updatePassword(String id, String beforePassword, String afterPassword);

    void deleteId(String Id, String Password);

}
