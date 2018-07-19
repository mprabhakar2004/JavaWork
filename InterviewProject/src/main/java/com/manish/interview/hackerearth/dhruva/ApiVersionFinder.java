package com.manish.interview.hackerearth.dhruva;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ApiVersionFinder {
    public static void main(String[] args) {

        ApiVersionFinder apiVersionFinder = new ApiVersionFinder();
        File file = null;
        FileReader fileReader = null;
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader("input.txt"))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                apiVersionFinder.processLine(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(apiVersionFinder.getAppName());
    }
    class APIVersion{
        String apiName;
        String lowestVersion;
        int versionCount;
        public APIVersion(String name, String version,int versionCount){
            this.apiName =  name;
            this.lowestVersion = version;
            this.versionCount = versionCount;
        }
    }
    private  Map<String, APIVersion> apiVersionMap = new HashMap<>();
    private Map<String, String> appApiMap = new HashMap<>();

    public  void processLine(String logLine){

            String []strArr = logLine.split(",");
            String appName = strArr[0].trim();
            String apiName = strArr[1].trim();
            String version = strArr[2].trim();

            if(apiVersionMap.get(apiName) !=null){

                APIVersion apiVersion = apiVersionMap.get(apiName);
                apiVersion.versionCount = 1;
                int versionNumber = Integer.parseInt(apiVersion.lowestVersion.substring(1));
                int currentVersionNumber = Integer.parseInt(version.substring(1));
                if (versionNumber > currentVersionNumber){
                    apiVersion.lowestVersion = version;
                }
                apiVersionMap.put(apiName, apiVersion);

            }else {
                apiVersionMap.put(apiName, new APIVersion(apiName, version, 0));
            }

            appApiMap.put(apiName+version,appName);
    }

    public  String getAppName(){
        String res="";
        for (Map.Entry<String,APIVersion> entry: apiVersionMap.entrySet()){
            if (entry.getValue().versionCount>0){
                res = appApiMap.get(entry.getValue().apiName+entry.getValue().lowestVersion);
            }
        }

        return res;
    }

}
