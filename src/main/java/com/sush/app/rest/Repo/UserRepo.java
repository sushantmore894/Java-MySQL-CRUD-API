package com.sush.app.rest.Repo;

import com.sush.app.rest.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Long>{

}
