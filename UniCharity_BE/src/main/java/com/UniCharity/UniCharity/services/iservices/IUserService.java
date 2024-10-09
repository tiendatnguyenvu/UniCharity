package com.UniCharity.UniCharity.services.iservices;

import com.UniCharity.UniCharity.dto.request.UserCreateRequest;
import com.UniCharity.UniCharity.dto.request.UserUpdateRequest;
import com.UniCharity.UniCharity.dto.response.UserResponse;

import java.util.List;

public interface IUserService {
    public UserResponse createUser(UserCreateRequest request);
    public List<UserResponse> getUsers();
    public UserResponse getUser(int userId);
    public UserResponse updateUser(int userId, UserUpdateRequest request);
    public UserResponse updateUserStatus(int userId);
}
