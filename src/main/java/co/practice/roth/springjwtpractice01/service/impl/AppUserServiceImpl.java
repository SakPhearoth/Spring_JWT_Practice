package co.practice.roth.springjwtpractice01.service.impl;

import co.practice.roth.springjwtpractice01.model.AppUser;
import co.practice.roth.springjwtpractice01.repository.AppUserRepository;
import co.practice.roth.springjwtpractice01.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        AppUser appUser = appUserRepository.findUserByEmail(email);

        if(appUser == null){
            System.out.println("User not found");
        }
        return appUser;
    }
}
