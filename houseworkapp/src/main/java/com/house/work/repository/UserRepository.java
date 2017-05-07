package com.house.work.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.house.work.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
	
	public User findById(Long Id);
	
	@Query(value="select u from User u where u.active=?1 and u.registerAsCustomer = ?2")
	Page<User> findByActiveAndByRegisterAsCustomer(int active, int registerAsCustomer, Pageable pageable);
	
	@Query(value = "select u from User u where (lower(u.name) like ?1 or lower(u.lastName) like ?1 or lower(u.email) like ?1) and u.active = ?2 AND u.registerAsCustomer = ?3")
	Page<User> findByNameAndByActiveAndByRole(String searchString, int active, int customer, Pageable pageable);
	
}
