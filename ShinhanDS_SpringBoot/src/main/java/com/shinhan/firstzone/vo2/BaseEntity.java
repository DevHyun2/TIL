package com.shinhan.firstzone.vo2;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@MappedSuperclass //table 생성은 안됨
@EntityListeners(value = AuditingEntityListener.class)
public abstract class BaseEntity {
	
	//@CreatedDate - spring
		@CreationTimestamp //hibernate
		@Column(name = "regdate", updatable = false) // 수정불가
		LocalDateTime regDate;
		//LastModifiedDate - spring
		@UpdateTimestamp //hibernate
		@Column(name = "moddate")
		LocalDateTime modDate;
}
