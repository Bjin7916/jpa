package com.jpa.task.service;

import com.jpa.task.domain.PostDTO;
import com.jpa.task.domain.PostSearch;
import com.jpa.task.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PostService {
//    게시글 목록
//    public List<PostDTO> getList();
public Page<PostDTO> getList(Pageable pageable, PostSearch postSearch);

//    게시글 조회
    public PostDTO getPost(Long id);

    public default PostDTO toDTO(Post post){
        return PostDTO.builder()
                .id(post.getId())
                .postTitle(post.getPostTitle())
                .postContent(post.getPostContent())
                .build();
    }
}
