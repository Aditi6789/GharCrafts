package com.gharcraft.service;

import com.gharcraft.model.AppUser;
import com.gharcraft.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

@Component
public class CurrentUser {
    private final UserRepository users;
    public CurrentUser(UserRepository users){this.users=users;}
    public AppUser require(HttpSession session){
        Object id=session.getAttribute("USER_ID");
        if(id==null) throw new IllegalStateException("Please log in to continue.");
        return users.findById((Long)id).orElseThrow(()->new IllegalStateException("User session not found."));
    }
}
