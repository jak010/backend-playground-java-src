package com.board.boardserver.mapper;

import com.board.boardserver.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

@Mapper
public interface UserProfileMapper {

    public UserDto getUserProfile(@Param("id") String id);

    int insertUserProfile(
            @Param("userID") String userID,
            @Param("userPassword") String userPassword,
            @Param("nickName") String nickName,
            @Param("isAdmin") boolean isAdmin,
            @Param("createTime") Date createTime,
            @Param("status") UserDto.Status status
    );

    int deleteUserProfile(@Param("id") String id);

    public UserDto findByIdAndPassword(@Param("id") String id, @Param("password") String password);

    int idCheck(@Param("id") String id);

    public int updatePassword(UserDto userDto);


    int register(UserDto userDto);
}
