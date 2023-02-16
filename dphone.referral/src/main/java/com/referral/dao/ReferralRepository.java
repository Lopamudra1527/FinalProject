package com.referral.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.referral.entity.Referral;
@Repository
public interface ReferralRepository extends JpaRepository<Referral, Integer> {

}
