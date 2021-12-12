package com.jsfspring.kerdoiv.utills;

import javax.faces.bean.RequestScoped;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Component(value = "userInfo")
@RequestScoped
public class UserInfo {
    public String getUserName(){
        Authentication authentication =
            SecurityContextHolder.getContext().getAuthentication();
        if (!isLoggedIn()) {
            return "";
        }
        return authentication.getName();
    }
    
    public Boolean isLoggedIn(){
        Authentication authentication =
            SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
    }
}
