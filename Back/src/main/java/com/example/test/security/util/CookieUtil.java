package com.example.test.security.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpCookie;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

 

@Component
public class CookieUtil {
    
    
    @Value("${authentication-test.auth.accessTokenCookieName}")
    private String accessTokenCookieName;

 

    @Value("${authentication-test.auth.refreshTokenCookieName}")
    private String refreshTokenCookieName;
    
    
    public HttpCookie createAccessTokenCookie(String token, Long duration) {
        String encryptedToken = SecurityCipher.encrypt(token);
        return ResponseCookie.from(accessTokenCookieName, encryptedToken)
                .maxAge(-1)
                .httpOnly(true)
                .path("/")
                .build();
    }

 

    public HttpCookie createRefreshTokenCookie(String token, Long duration) {
        String encryptedToken = SecurityCipher.encrypt(token);
        return ResponseCookie.from(refreshTokenCookieName, encryptedToken)
                .maxAge(-1)
                .httpOnly(true)
                .path("/")
                .build();
    }

 

    public HttpCookie deleteAccessTokenCookie() {
        return ResponseCookie.from(accessTokenCookieName, "").maxAge(0).httpOnly(true).path("/").build();
    }

 

}
