package com.jpa.intermediate.repository.member;

import com.jpa.intermediate.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
