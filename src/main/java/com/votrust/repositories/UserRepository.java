package com.votrust.repositories;

import com.votrust.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Optional: custom query methods like findByEmail, etc.
    public User findByUsername(String username);
}
