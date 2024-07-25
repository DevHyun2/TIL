package com.shinhan.firstzone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shinhan.firstzone.vo2.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, String>{

}
