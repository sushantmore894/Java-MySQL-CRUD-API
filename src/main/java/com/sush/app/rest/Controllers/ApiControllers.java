package com.sush.app.rest.Controllers;

import com.sush.app.rest.Models.User;
import com.sush.app.rest.Repo.UserRepo;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
public class ApiControllers {

    @Autowired
    private UserRepo userRepo;

    //public ApiControllers(UserRepo userRepo) {
   //     this.userRepo = userRepo;
  //  }

    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome...";
    }

    @GetMapping(value = "/users")
    public List<User> getUser(){
         return userRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user){
       userRepo.save(user);
       return "Saved...";
    }

    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        User updateUser = userRepo.findById(id).get();
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setOccupation(user.getOccupation());
        updateUser.setAge(user.getAge());
        userRepo.save(updateUser);
        return "Updated...";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Deleted user with id:"+id;
    }

}

