package com.manish.interview.hackerearth.vmware;

import java.util.*;

public class q2 {

    public static void main(String[] args) {
        String [] sentence = {
                "it go will away",
                "go do art",
                "what to will east"
        };
        String []queries = {
                "it will",
                "go east will",
                "will"
        };

        textQueries(sentence,queries);
    }

    static void textQueries(String[] sentences, String[] queries) {

        Map<String, Set<Integer>> wordDict = new HashMap<>();

        for(int i=0;i<sentences.length;i++){
            String []array = sentences[i].split(" ");
            for (int j=0;j<array.length;j++){
                Set<Integer> set= null;
                if (wordDict.containsKey(array[j])){
                    set = wordDict.get(array[j]);
                    set.add(i);
                }else{
                    set = new HashSet<>();
                    set.add(i);
                }
                wordDict.put(array[j],set);
            }
        }

        for (int i=0;i<queries.length;i++){

            String [] array = queries[i].split(" ");
            Set<Integer> result = new HashSet<>();
            for (int j=0;j<array.length;j++){

                if (wordDict.containsKey(array[j])){

                    if (result.size() ==0 && j==0){
                        result.addAll(wordDict.get(array[j]));
                    }else {
                        result.retainAll(wordDict.get(array[j]));
                    }
                }
            }
            Iterator<Integer> res = result.iterator();
            if(!res.hasNext()){
                System.out.print("-1");
            }
            while (res.hasNext()) {
                System.out.print(res.next()+" ");
            }
            System.out.println("");
        }

    }
}
