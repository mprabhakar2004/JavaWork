package com.home.test.secondfactorauthenticator.controller;

import com.google.zxing.WriterException;
import com.home.test.secondfactorauthenticator.dao.UserDao;
import com.home.test.secondfactorauthenticator.model.User;
import com.home.test.secondfactorauthenticator.util.TOTPUtil;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/totptester")
public class TOTPController {

    @Autowired
    private UserDao userDao;

    @PostMapping("/{userId}/generate-secret")
    public String generateSecretKey(@PathVariable String userId){
        User user = userDao.getUser(userId);
        String secretKey = user.getSecretKey();
        if(StringUtils.isEmpty(secretKey)) {
            secretKey = TOTPUtil.getRandomSecretKey();
            user.setSecretKey(secretKey);
            userDao.saveUser(user);
        }
        return secretKey;
    }

    @GetMapping(value = "/bar-code/{userId}/{issuer}",produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getBarCode(@PathVariable String userId, @PathVariable String issuer, HttpServletResponse response, HttpServletRequest request) throws IOException {

        String secretKey = generateSecretKey(userId);

        String barCodeData = TOTPUtil.getGoogleAuthenticatorBarCode(secretKey,userId,issuer);
        try {
            TOTPUtil.createQRCode(barCodeData,"test.png",200,200);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Get your file stream from wherever.
        InputStream myStream = null;
        try {
            myStream = new FileInputStream("test.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return new ResponseEntity<>(IOUtils.toByteArray(myStream), headers, HttpStatus.CREATED);
    }

    @GetMapping("/totp/{userId}")
    public String getTOTP(@PathVariable String userId){

       String secretKey = generateSecretKey(userId);
       return TOTPUtil.getTOTPCode(secretKey);
    }



    @PostMapping("/validate/{userId}/{totp}")
    public String validate(@PathVariable String userId, @PathVariable String totp){

        return getTOTP(userId).equals(totp) || getPrevTOTP(userId).equals(totp)?"Valid":"Invalid";
    }

    private String getPrevTOTP(String userId) {
        String secretKey = generateSecretKey(userId);
        return TOTPUtil.getPrevTOTP(secretKey);
    }

}
