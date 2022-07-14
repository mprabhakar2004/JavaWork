package com.manish.interview.hackerearth.salesforce;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Vocabulary{
  static String [] dict = {"cat", "dog","catch","cake","apple","door"};
  List<String> getPrefixWord(final String prefix){
    List<String> dictList = Arrays.asList(dict);
    return dictList.stream().filter(x -> x.startsWith(prefix)).collect(Collectors.toList());

  }

  public static void main(String[] args) {
    Vocabulary vocabulary = new Vocabulary();
    System.out.println(vocabulary.getPrefixWord("ca"));
  }
}

class Autocomplete{
  List<String> getPrefixWord(final String prefix){
    return new Vocabulary().getPrefixWord(prefix);
  }
}