package co.practice.roth.springjwtpractice01.service.impl;

import co.practice.roth.springjwtpractice01.model.AppUser;
import co.practice.roth.springjwtpractice01.model.request.RegisterRequest;
import co.practice.roth.springjwtpractice01.repository.AppUserRepository;
import co.practice.roth.springjwtpractice01.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        AppUser appUser = appUserRepository.findUserByEmail(email);

        if(appUser == null){
            System.out.println("User not found");
        }
        return appUser;
    }


    public void register(RegisterRequest request){

        AppUser appUser = new AppUser();
        appUser.setFullName(request.getFullName());
        appUser.setEmail(request.getEmail());

        appUser.setPassword(passwordEncoder.encode(request.getPassword()));
        appUserRepository.insertUser(appUser);
        appUserRepository.insertUserRole(appUser.getUserId(), 2);
    }


}
