package com.manish.interview.practice.misc;


import java.util.*;

class A{
	int a;
	int b;

	public A(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public String toString() {
		return "A{" +
				"a=" + a +
				", b=" + b +
				'}';
	}
}
public class TestClient {
	public static void main(String[] args) {
//		final int []ar = {100,100,50,40,40,20,10};
//		final int []alice = {5,25,50,120};
//        preProcessScoreArray(ar);
//        System.out.println(Arrays.toString(climbingLeaderboard(ar,alice)));

        String [] strings = {"Mail App, Authentication API, v6",
                "Video Call App, Authentication API, v7",
                "Mail App, Data Storage API, v10",
                "Chat App, Data Storage API, v11",
                "Mail App, Search API, v6",
                "Chat App, Authentication API, v8",
                "Chat App, Presence API, v2",
                "Video Call App, Data Storage API, v11",
                "Video Call App, Video Compression API, v3"};
        System.out.println(getAppName(strings));
	}

    static List<Integer> uniqueScoreList = new ArrayList<Integer>();
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] res = new int[alice.length];
        for (int i = 0; i < alice.length; i++) {
            int j=0;
            for (; j < uniqueScoreList.size(); j++) {
                if (alice[i]>= uniqueScoreList.get(j)){
                    break;
                }
            }
            res[i] = j+1;
        }
        return res;
    }

    static void preProcessScoreArray(int []scores){
        int currentElement = scores[0];
        for(int i=1;i<scores.length;i++){
            if(currentElement != scores[i]){
                uniqueScoreList.add(currentElement);
                currentElement = scores[i];
            }
        }
        uniqueScoreList.add(currentElement);

        System.out.println(Arrays.toString(uniqueScoreList.toArray()));
    }

    static int[] climbingLeaderboard1(int[] scores, int[] alice) {
        int []res = new int[alice.length];

        return res;
    }
	private static void changeMe(final A a) {
		a.a= 30;
	}


	static class APIVersion{
        String apiName;
        String lowestVersion;
        int versionCount;
        public APIVersion(String name, String version,int versionCount){
            this.apiName =  name;
            this.lowestVersion = version;
            this.versionCount = versionCount;
        }
    }
	public static String getAppName(String []logLine){
        String res="";

        Map<String, APIVersion> versionMap = new HashMap<>();
        Map<String, String> appMap = new HashMap<>();

        for (int i=0;i<logLine.length;i++){

            String []strArr = logLine[i].split(",");

            if(versionMap.get(strArr[1]) !=null){

                APIVersion apiVersion = versionMap.get(strArr[1]);
                int versionNumber = Integer.parseInt(apiVersion.lowestVersion.substring(1));
                int currentVersionNumber = Integer.parseInt(strArr[2].trim().substring(1));
                if (versionNumber > currentVersionNumber){
                    versionMap.put(strArr[1], new APIVersion(strArr[1], strArr[2].trim(), 1));
                }

            }else {
                versionMap.put(strArr[1], new APIVersion(strArr[1], strArr[2].trim(), 0));
            }

            appMap.put(strArr[1]+strArr[2],strArr[0]);
        }

        for (Map.Entry<String,APIVersion> entry:versionMap.entrySet()){
            if (entry.getValue().versionCount>0){
                res = appMap.get(entry.getValue().apiName+entry.getValue().lowestVersion);
            }
        }


        return res;
    }
}
