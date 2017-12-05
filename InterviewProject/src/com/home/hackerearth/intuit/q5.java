package com.home.hackerearth.intuit;

import java.io.*;

public class q5 {
    public static void main(String[] args) {
        String filename="test";
        readFile(filename);
    }

    private static void readFile(String fileName){

        String line = null;

        long responseSize;
        long sumOfAllLargeResponseSize = 0l;
        int noOfLargeRequests = 0;

        try {
            FileReader fileReader =
                    new FileReader(fileName);

            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);


            while((line = bufferedReader.readLine()) != null) {
                String[] columns = line.split(" ");
                responseSize = Long.valueOf(columns[columns.length-1]);
                if(responseSize > 5000){
                    noOfLargeRequests++;
                    sumOfAllLargeResponseSize += responseSize;
                }
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }

        String outputFileName = "bytes_"+fileName;
        writeToFile(outputFileName, noOfLargeRequests, sumOfAllLargeResponseSize);
    }

    private static void writeToFile(String fileName, int noOfLargeRequests, long sumOfAllLargeResponseSize){
        try {
            FileWriter fileWriter =
                    new FileWriter(fileName);

            BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);

            bufferedWriter.write(Integer.valueOf(noOfLargeRequests).toString());
            bufferedWriter.newLine();
            bufferedWriter.write(Long.valueOf(sumOfAllLargeResponseSize).toString());

            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println("Error writing to file '" + fileName + "'");
        }
    }
}
