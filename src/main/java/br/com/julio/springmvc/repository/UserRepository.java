package br.com.julio.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.julio.springmvc.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
	public User findUserByEmail(String email); 
	
	/* @Query("SELECT u FROM users u JOIN FETCH u.authorities WHERE u.email = (:email)")
	public User findUserByEmail(String email);*/

}
