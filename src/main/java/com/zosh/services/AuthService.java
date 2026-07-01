package com.zosh.services;

import com.zosh.response.SignupRequest;

public interface AuthService {

    String createUser(SignupRequest req) throws Exception;
}
