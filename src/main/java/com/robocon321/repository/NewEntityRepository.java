package com.robocon321.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robocon321.entity.NewEntity;

public interface NewEntityRepository extends JpaRepository<NewEntity, Long> {

}
