package com.board.boardserver.service.impl;

import com.board.boardserver.dto.PostDTO;
import com.board.boardserver.dto.UserDto;
import com.board.boardserver.mapper.PostMapper;
import com.board.boardserver.mapper.UserProfileMapper;
import com.board.boardserver.service.PostService;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Log4j2
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private UserProfileMapper userProfileMapper;


    @Override
    public void register(String id, PostDTO postDTO) {
        UserDto userDto = userProfileMapper.getUserProfile(id);

        postDTO.setUserId(userDto.getId());
        postDTO.setCreateTime(new Date());

        if (userDto != null) {
            postMapper.register(postDTO);
        } else {
            log.error("Member ERROR {}", postDTO);
            throw new RuntimeException("register Error");
        }


    }

    @Override
    public List<PostDTO> getMyPosts(int accountId) {
        List<PostDTO> postDTOList = postMapper.selectMyPosts(accountId);
        return postDTOList;

    }

    @Override
    public void updatePosts(PostDTO postDTO) {
        if (postDTO != null && postDTO.getId() != 0) {
            postMapper.updatePosts(postDTO);
        } else {
            log.error("{}", postDTO);
            throw new RuntimeException("{}" + postDTO);
        }
    }

    @Override
    public void deletePosts(int userId, int postId) {
        if (userId != 0 &&  postId!= 0) {
            postMapper.deletePosts(postId);
        } else {
            log.error("{}", userId);
            throw new RuntimeException("{}" + userId);
        }
    }
}
