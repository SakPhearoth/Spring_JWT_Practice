package co.practice.roth.springjwtpractice01.service;

import co.practice.roth.springjwtpractice01.model.request.RegisterRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AppUserService extends UserDetailsService {

    void register(RegisterRequest request);
}
