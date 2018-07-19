package com.home.test.secondfactorauthenticator.controller;

import com.google.zxing.WriterException;
import com.home.test.secondfactorauthenticator.util.TOTPUtil;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/totptester")
public class TOTPController {

    @GetMapping("/generate-secret")
    public String getSecretKey(){
        return TOTPUtil.getRandomSecretKey();
    }

    @GetMapping("/bar-code/{account}/{issuer}")
    public void getBarCode(@PathVariable String account, @PathVariable String issuer, HttpServletResponse response, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        String secretKey = (String)session.getAttribute("secretKey");
        if(StringUtils.isEmpty(secretKey)) {
            secretKey = getSecretKey();
            session.setAttribute("secretKey", secretKey);
        }

        String barCodeData = TOTPUtil.getGoogleAuthenticatorBarCode(secretKey,account,issuer);
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

        // Set the content type and attachment header.
        response.addHeader("Content-disposition", "inline");
        response.setContentType("image/png");

        // Copy the stream to the response's output stream.
        try {
            IOUtils.copy(myStream, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/totp/{secret-key}")
    public String getTOTP(@PathVariable(name = "secret-key",value = "") String secretKey, HttpServletRequest request){
        if (org.springframework.util.StringUtils.isEmpty(secretKey)){
            HttpSession session = request.getSession(true);
            secretKey = (String)session.getAttribute("secretKey");
        }
        return TOTPUtil.getTOTPCode(secretKey);
    }

    @GetMapping("/totp")
    public String getTOTP(HttpServletRequest request){
        return getTOTP(null,request);
    }


    @PostMapping("/validate/{totp}")
    public String validate(@PathVariable String totp, HttpServletRequest request){
        HttpSession session = request.getSession(true);
        String secretKey = (String)session.getAttribute("secretKey");

        return getTOTP(secretKey,request).equals(totp) || TOTPUtil.getPrevTOTP(secretKey).equals(totp)?"Valid":"Invalid";
    }

}
