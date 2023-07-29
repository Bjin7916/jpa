package com.jpa.intermediate.repository;

import com.jpa.intermediate.entity.file.MemberFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberFileRepository extends JpaRepository<MemberFile, Long> {
//    파일의 이름을 여러 개 전달받아서 전체 정보 조회
    @Query("select m from MemberFile m where m.fileName in :fileNames")
    public List<MemberFile> findAllByFileNames(List<String> fileNames);

}




















