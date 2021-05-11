package com.ojas.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ojas.model.Address;
@Repository
public interface AddressDao extends JpaRepository<Address,Integer>{

}
