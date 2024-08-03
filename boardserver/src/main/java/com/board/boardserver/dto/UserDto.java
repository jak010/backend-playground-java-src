package com.board.boardserver.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Getter
@Setter
@ToString
public class UserDto {

    public static boolean hasNullDataBeforeRegister(UserDto userDto) {
        return userDto.getUserID() == null || userDto.getUserPassword() == null || userDto.getNickName() == null;

    }

    public enum Status {
        DEFAULT, ADMIN, DELETE
    }


    private int id;
    private String userID;
    private String userPassword;
    private String nickName;
    private boolean isAdmin;
    private Date createTime;
    private Status status;

}
