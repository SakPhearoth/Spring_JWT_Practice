package co.practice.roth.springjwtpractice01.utils;


import co.practice.roth.springjwtpractice01.model.AppUser;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    public static AppUser getCurrentUser() {
        AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return appUser;
    }

    public static String getCurrentEmail() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
    }
}
