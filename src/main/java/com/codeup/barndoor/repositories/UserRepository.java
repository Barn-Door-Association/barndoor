package com.codeup.barndoor.repositories;

import com.codeup.barndoor.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findById(long id);


    User findByEmail(String email);

    User findByRanchName(String ranchName);
}
