package com.hafsaelakhdar.springbootproject.repositories;

import com.hafsaelakhdar.springbootproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByEmail(String email);
}
