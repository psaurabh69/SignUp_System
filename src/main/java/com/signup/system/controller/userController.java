package com.signup.system.controller;

import com.signup.system.entity.UserInfo;
import com.signup.system.services.userServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    public userServicesImpl userServices;

    @GetMapping("/fetchAllUser")
    public ResponseEntity<List<UserInfo>> getUser(){
        List<UserInfo> userList = userServices.fetchAllUser();
        return new ResponseEntity(userList,HttpStatus.OK);
    }

    @GetMapping("/getUserById")
    public ResponseEntity<UserInfo> getUserById(@RequestParam(name="id") Integer id){
        Optional<UserInfo> userInfo = userServices.getuserByID(id);
        if(userInfo.isPresent()){
            return new ResponseEntity(userInfo,HttpStatus.OK);
        }else{
            return new ResponseEntity("User Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/saveUser")
    public ResponseEntity<String> getUserById(@RequestBody UserInfo userInfo){
        UserInfo user = userServices.saveUser(userInfo);
        if(!ObjectUtils.isEmpty(user)){
            return new ResponseEntity("User successfully added in DB.",HttpStatus.OK);
        }else{
            return new ResponseEntity("USer not able to added in DB.",HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUserById(@RequestParam Integer id, @RequestBody UserInfo userInfo){
        UserInfo user = userServices.updateUser(id,userInfo);
        if(!ObjectUtils.isEmpty(user)){
            return new ResponseEntity("User successfully updated in DB.",HttpStatus.OK);
        }else{
            return new ResponseEntity("USer not able to updated in DB.",HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUserById(@RequestParam Integer id){
        boolean deleteUser = userServices.deleteUser(id);
        if(deleteUser){
            return new ResponseEntity("User deleted Successfully",HttpStatus.OK);
        }else{
            return new ResponseEntity("User Not found db", HttpStatus.NOT_FOUND);
        }
    }
}
