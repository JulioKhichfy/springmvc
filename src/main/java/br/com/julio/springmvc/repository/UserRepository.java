package br.com.julio.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.julio.springmvc.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
	public User findUserByEmail(String email); 

}
