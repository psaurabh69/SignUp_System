package com.signup.system.services;

import com.signup.system.entity.UserInfo;
import com.signup.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class userServicesImpl implements userServices {

    @Autowired
    public UserRepository userRepository;

    @Override
    public List<UserInfo> fetchAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserInfo> getuserByID(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public  UserInfo saveUser(UserInfo userInfo) {
        return userRepository.save(userInfo);
    }

    @Override
    public UserInfo updateUser(Integer id, UserInfo userInfo) {
        Optional<UserInfo> opt = userRepository.findById(id);
        if(opt.isPresent()){
            UserInfo oldUserInfo = opt.get();
            if(!Objects.isNull(oldUserInfo.getUserName()) && !"".equalsIgnoreCase(oldUserInfo.getUserName())){
                oldUserInfo.setUserName(userInfo.getUserName());
            }
            if(!Objects.isNull(oldUserInfo.getEmailID()) && !"".equalsIgnoreCase(oldUserInfo.getEmailID())) {
                oldUserInfo.setEmailID(userInfo.getEmailID());
            }
            UserInfo saveUserInfo = userRepository.save(oldUserInfo);
            return saveUserInfo;
        }
        return null;
    }

    @Override
    public boolean deleteUser(Integer id) {
        Optional<UserInfo> opt = userRepository.findById(id);
        if(opt.isPresent()){
            userRepository.delete(opt.get());
            return true;
        }else{
            return false;
        }
    }
}
