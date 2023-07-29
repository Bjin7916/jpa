package com.jpa.intermediate.repository;

import com.jpa.intermediate.entity.file.PostFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostFileRepository extends JpaRepository<PostFile, Long> {
//    filePath를 여러 개 전달받은 뒤 존재하는 경로의 PostFile 조회
    @Query("select p from PostFile p where p.filePath in :filePaths")
    public List<PostFile> findAllByFilePaths(List<String> filePaths);

}
