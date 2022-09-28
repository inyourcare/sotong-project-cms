package com.sotong.projectcms.web.auth.controller;

import com.sotong.projectcms.config.anotation.AdminController;
import com.sotong.projectcms.persistence.repository.auth.UserRepository;
import com.sotong.projectcms.utills.JwtTokenUtil;
import com.sotong.projectcms.web.auth.controller.parent.AuthAbstractController;
import com.sotong.projectcms.web.auth.form.SignInForm;
import com.sotong.projectcms.web.cmmn.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@AdminController
@RequestMapping("/auth")
public class AuthController extends AuthAbstractController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public ResponseEntity<?> getAuthenticationToken(@Valid @RequestBody SignInForm form) throws Exception {
        final String token;
        authenticate(form.getSignInId(), form.getPassword());
        token = JwtTokenUtil.generateToken(userRepository.findBySignInId(form.getSignInId()).orElseThrow());
        return new ResponseEntity<>(new ApiResponse("getAuthenticationToken successfully done", HttpStatus.OK), HttpStatus.OK);
    }
    private void authenticate(String loginId, String password) throws Exception {
        try {
            // get user info from loadUserByUsername in userDetailsService
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginId, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
//    private void validate(SignInForm form) throws Exception {
////        AuthUtil.isRegexName(signUpRequest.getName());
//        AuthUtil.isRegexEmail(form.getEmail());
////        AuthUtil.isRegexPhoneNo(form.getPhoneNo());
//    }
}
