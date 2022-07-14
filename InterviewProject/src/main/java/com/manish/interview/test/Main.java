package com.manish.interview.test;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

class User {
    String name;
    String email;
    String team;
    String role;

    public User(String name, String email, String team, String role) {
        this.name = name;
        this.email = email;
        this.team = team;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

}

public class Main {

    public static void main(String[] args) {

        List<User> users = Arrays.asList(new User("manish", "manish@linkedin.onmicrosoft.com", "a", "admin")
                , new User("mohan", "mohan@linkedin.onmicrosoft.com", "a", "admin")
                , new User("manish", "manish@linkedin.onmicrosoft.com", "a", "teamadmin")
                , new User("rohan", "rohan@linkedin.onmicrosoft.com", "a", "dev"));

        Set<String> emailList = users.stream()
                .filter(x -> x.getRole().equals("admin") || x.getRole().equals("teamadmin"))
                .map(x -> x.getEmail().replace("onmicrosoft.", ""))
                .collect(Collectors.toSet());

        System.out.println(String.join(", ", emailList));
        System.out.println(getWord(new String[]{"111116121097121", "105110105102110105121116097121", "097100110097121", "111121101098100110097121"}));

        Long t= null;
        long t1=123l;
        System.out.println(t==t1);
    }

    private static int findSolution(long input) {
        int result;
        for (int i = 1; ; i++) {
            BigInteger res = BigInteger.valueOf(input).multiply(BigInteger.valueOf(i));
            String multiple = res.toString();
            if (multiple.matches("^4+0*")) {
                int a = multiple.replaceAll("[^4]", "").length();
                int b = multiple.replaceAll("[^0]", "").length();
                result = 2 * a + b;
                break;
            }
        }
        return result;
    }

    static String getWord(String []digitSeqList) {

        String res = "";
        for (String digitSeq:digitSeqList) {
            String tmpStr = new String(digitSeq);
            for (int i = 0; i < digitSeq.length(); i += 3) {
                String tmp = digitSeq.substring(i, i + 3);
                res += (char) (Integer.parseInt(tmp));
            }
            res+= " ";
        }
        return res;
    }
    /*
    111116121097121 105110105102110105121116097121 097100110097121 111121101098100110097121
    otyay inifniytay adnay oyebdnay
    toy infinity and beyond



     */
}
