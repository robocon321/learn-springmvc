package com.robocon321.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robocon321.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long>{
	AccountEntity findOneByUsernameAndStatus(String name, int status);
}
