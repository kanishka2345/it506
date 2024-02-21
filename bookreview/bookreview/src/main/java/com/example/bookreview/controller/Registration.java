package com.example.bookreview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookreview.model.User;
import com.example.bookreview.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@Service
public class Registration {

    @Autowired
    private UserService userService;

    @GetMapping("/getuser/{id}")
    public User showUserDetails(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping("/register")
    public User processRegistration(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRegiter(@PathVariable Long id) {
        try {
            userService.deleteRegiter(id);
            return ResponseEntity.ok("User with Id " + id + " successfully deleted");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PutMapping("/update")
    public ResponseEntity<User>updateUserService(@RequestBody User user) 
    User updateModel=UserService.updateU
    ser(user);
    if(updateModel==null){
        return ResponseEntity.notFound().build();
    }else{
        return ResponseEntity.ok(updateModel);
    }
    }
      
    }
}
