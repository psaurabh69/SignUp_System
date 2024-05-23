package com.signup.system.services;

import com.signup.system.entity.UserInfo;

import java.util.List;
import java.util.Optional;

public interface userServices {

    public List<UserInfo> fetchAllUser();

    public Optional<UserInfo> getuserByID(Integer id);

    public UserInfo saveUser(UserInfo userInfo);

    public UserInfo updateUser(Integer id, UserInfo userInfo);

    public boolean deleteUser(Integer id);

}
