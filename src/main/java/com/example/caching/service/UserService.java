package com.example.caching.service;

import com.example.caching.model.AppUser;

public interface UserService {

    AppUser getUserByUserName(String username);

    AppUser getUserByUsernameCached(String username);

    AppUser saveNewUser(AppUser appUser);

    AppUser updateUserStatus(String username, String status);

    AppUser updateUserStatusWithEvict(String username, String status);
}
