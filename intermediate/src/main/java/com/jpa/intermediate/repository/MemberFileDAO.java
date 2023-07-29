package com.jpa.intermediate.repository;

import com.jpa.intermediate.entity.file.MemberFile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberFileDAO {
    @PersistenceContext
    private EntityManager entityManager;

//    추가
    public MemberFile save(MemberFile memberFile){
        entityManager.persist(memberFile);
        return memberFile;
    }

//    조회
    public Optional<MemberFile> findById(Long id){
        return Optional.ofNullable(entityManager.find(MemberFile.class, id));
    }

//    전체 조회
    public List<MemberFile> findAll(){
        String query = "select m from MemberFile m";
        return entityManager.createQuery(query, MemberFile.class).getResultList();
    }

//    삭제
    public void delete(MemberFile memberFile){
        entityManager.remove(memberFile);
    }
}
