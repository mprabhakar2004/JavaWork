package com.manish.interview.hackerearth.twilio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Solution {
  public static void main(String[] args) {
    for (String s: segments("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus")){
      System.out.println(s);
    }
  }

  public static List<String> segments(String message) {
    ArrayList<String> res = new ArrayList<String>();
    if(message.length()<160) {
      res.add(message);
    }else {
      StringBuilder sb = new StringBuilder();
      String [] messageArr = message.split(" ");
      int line=0;

      for (String s:messageArr){
        if (sb.length() + s.length()>=155){
          line ++;
          res.add(sb.toString());
          sb = new StringBuilder();

          if (s.contains(","))
            sb.append(" ").append(s);
          else
            sb.append(s);
        }else {
          if (sb.length()==0)
            sb.append(s);
          else
            sb.append(" ").append(s);
        }
      }
      res.add(sb.toString());
      line++;
      for (int i=1;i<=line-1;i++){
        String s = res.get(i-1);
        if (s.length()==155)
          res.set(i-1, s.concat(String.format("(%d/%d)", i, line)));
        else
         res.set(i-1, s.concat(String.format(" (%d/%d)", i, line)));
      }
      res.set(line-1, res.get(line-1).concat(String.format("(%d/%d)", line, line)));
    }
    return res;
  }

  public static int fourthBit(int number) {
    number = number >>3;
    return number &1;
  }

  public static List<String> funWithAnagrams(List<String> text) {
    Set<String> hashSet = new HashSet<>();
    ArrayList<String> res = new ArrayList<String>();
    for (String s : text) {
      String sortedStr = sorted(s);
      if (!hashSet.contains(sortedStr)) {
        res.add(s);
        hashSet.add(sortedStr);
      }
    }
   Collections.sort(res);
    return res;
  }

  private static String sorted(String s) {
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }



}
