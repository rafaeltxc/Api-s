package com.rtxct.simple.schema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rtxct.simple.schema.model.BankModel;

@Repository
public interface BankRepository extends JpaRepository<BankModel, Long> {

}
