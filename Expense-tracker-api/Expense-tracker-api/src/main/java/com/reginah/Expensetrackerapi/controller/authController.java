package com.reginah.Expensetrackerapi.controller;
import com.reginah.Expensetrackerapi.entity.AuthModel;
import com.reginah.Expensetrackerapi.entity.User;
import com.reginah.Expensetrackerapi.entity.UserModel;
import com.reginah.Expensetrackerapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class authController {

    @Autowired
    private UserService userService;

//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @PostMapping("/login")
//    public ResponseEntity<HttpStatus> login(@RequestBody AuthModel authModel) {
//        Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authModel.getEmail(), authModel.getPassWord()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
//    }
    @PostMapping("/login")
    public ResponseEntity<String> login() {
        return new ResponseEntity<String>("user is logged in", HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<User> add(@Valid @RequestBody UserModel user) {
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
    }
}
