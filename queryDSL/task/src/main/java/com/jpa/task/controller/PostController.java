package com.jpa.task.controller;

import com.jpa.task.domain.PostDTO;
import com.jpa.task.domain.PostSearch;
import com.jpa.task.service.PostService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/posts/api/*")
public class PostController {
    private final PostService postService;

//    게시글 목록
//    @GetMapping("list")
//    public List<PostDTO> getList(){
//        return postService.getList();
//    }
    @GetMapping("list")
    public Page<PostDTO> getList(@PageableDefault(size = 0) Pageable pageable, PostSearch postSearch){
        return postService.getList(pageable, postSearch);
    }

//    게시글 조회
    @GetMapping("{id}")
    public PostDTO getPost(@PathVariable Long id){
        return postService.getPost(id);
    }





}

