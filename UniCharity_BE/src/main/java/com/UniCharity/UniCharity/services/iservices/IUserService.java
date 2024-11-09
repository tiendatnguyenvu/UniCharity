package com.UniCharity.UniCharity.services.iservices;

import com.UniCharity.UniCharity.dto.request.UserCreateRequest;
import com.UniCharity.UniCharity.dto.request.UserUpdateRequest;
import com.UniCharity.UniCharity.dto.response.user.UserResponse;
import com.UniCharity.UniCharity.entities.User;

import java.util.List;

public interface IUserService {
    public UserResponse createUser(UserCreateRequest request);
    public User createUserWithEmail(String email, String name);
    public List<UserResponse> getUsers();
    public UserResponse getUser(int userId);
    public UserResponse updateUser(int userId, UserUpdateRequest request);
    public UserResponse updateUserStatus(int userId);
}
