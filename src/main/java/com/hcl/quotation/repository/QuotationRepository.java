package com.hcl.quotation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.quotation.entity.Quotation;

@Repository
public interface QuotationRepository extends JpaRepository<Quotation, Integer> {

}
