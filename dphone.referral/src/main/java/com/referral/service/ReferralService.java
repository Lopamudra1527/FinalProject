package com.referral.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.referral.entity.Referral;
import com.referral.dao.ReferralRepository;

@Service
@Transactional
public class ReferralService {
	@Autowired
	private ReferralRepository repo;
	
	 public List<Referral> listAll() {
	        return repo.findAll();
	    }
	     
	    public void save(Referral referral) {
	        repo.save(referral);
	    }
	     
	    public Referral get(int id) {
	        return repo.findById(id).get();
	    }
	     
	    public void delete(int id) {
	        repo.deleteById(id);
	    }
}
