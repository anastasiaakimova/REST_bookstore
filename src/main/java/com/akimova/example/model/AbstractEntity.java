package com.akimova.example.model;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.Instant;

/**
 * @author Anastasia Akimova.
 * 22.07.2022
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity implements Serializable {

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private Instant createdDate;

    @LastModifiedDate
    private Instant modifiedDate;
}
