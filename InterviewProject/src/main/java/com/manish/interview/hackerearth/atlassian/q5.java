package com.manish.interview.hackerearth.atlassian;

public class q5 {

    public static void main(String[] args) {
        String str = "|name|address|~n|Patrick|patrick@test.com|pat@test.com|~n|Annie||annie@test.com|~n";

        String str1="|name|address|~n|Patrick|patrick@test.com|pat@test.com|~n|Annie~~~|annie@test.com|~n|Zoe|~n";

        System.out.println(validate1(str1));
    }

    static String validate(String str){

        String res= "0:0:0:format_error";
        if(str.contains("~~~")){
            return res;
        }
        str = str.replaceAll("~~","");
        String []lines = str.split("~n");
        String []headerFields = null;
        String []fields = null;
        int noOfRecord = 0;
        int noOfFields = 0;
        int noOfEmptyFileds = 0;
        String lastFiledName="format_error";
        if(lines[0].startsWith("|")) {
            String firstLine = lines[0].substring(1, lines[0].length() - 1);
            headerFields = firstLine.split("\\|");
            noOfRecord = lines.length - 1;
            lastFiledName = headerFields[headerFields.length - 1];
            noOfFields = headerFields.length;
            for (int i = 1; i < lines.length; i++) {

                if (!lines[i].startsWith("|")) {
                    return res;
                }

                String currentLine = lines[i].substring(1, lines[i].length() - 1);
                fields = currentLine.split("\\|");
                if (headerFields.length < fields.length) {
                    noOfFields = fields.length;
                    int noOfExtraFields = fields.length - headerFields.length;
                    lastFiledName = headerFields[headerFields.length - 1] + "_" + noOfExtraFields;
                }
                if(fields.length<noOfFields){
                    noOfEmptyFileds +=noOfFields-fields.length;
                }else {
                    for (int j = 0; j < fields.length; j++) {
                        if (fields[j].isEmpty()) {
                            noOfEmptyFileds++;
                        }
                    }
                }
            }
        }
        res = noOfRecord +":"+ noOfFields+":"+noOfEmptyFileds+":"+lastFiledName;
        return res;
    }


    static String validate1(String str){

        String res= "0:0:0:format_error";
        String []lines = str.split("~n");
        String []headerFields = null;
        String []fields = null;
        int noOfRecord = 0;
        int noOfFields = 0;
        int noOfEmptyFileds = 0;
        String lastFiledName="format_error";
        if(lines[0].startsWith("|")) {
            String firstLine = lines[0].substring(1, lines[0].length() - 1);
            headerFields = firstLine.split("\\|");
            noOfRecord = lines.length - 1;
            lastFiledName = headerFields[headerFields.length - 1];
            noOfFields = headerFields.length;
            for (int i = 1; i < lines.length; i++) {

                if (!lines[i].startsWith("|")) {
                    return res;
                }

                String currentLine = lines[i].substring(1, lines[i].length() - 1);
                fields = currentLine.split("\\|");
                if (headerFields.length < fields.length) {
                    noOfFields = fields.length;
                    int noOfExtraFields = fields.length - headerFields.length;
                    lastFiledName = headerFields[headerFields.length - 1] + "_" + noOfExtraFields;
                }
                lines[i] = currentLine;
            }

        }

        for (int i=1;i<lines.length;i++){
            fields = lines[i].split("\\|");
            if(fields.length<noOfFields){
                noOfEmptyFileds +=noOfFields-fields.length;
            }
                for (int j = 0; j < fields.length; j++) {
                if (fields[j].contains("~~~"))  {
                    return res;
                }
                if (fields[j].isEmpty()) {
                        noOfEmptyFileds++;
                    }
                }

        }
        res = noOfRecord +":"+ noOfFields+":"+noOfEmptyFileds+":"+lastFiledName;
        return res;
    }
}
