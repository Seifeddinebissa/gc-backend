package com.gc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gc.entity.User;
import java.lang.String;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByPseudo(String pseudo);

}
