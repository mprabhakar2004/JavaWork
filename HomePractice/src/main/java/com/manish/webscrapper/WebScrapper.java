package com.manish.webscrapper;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import sun.plugin2.main.client.CALayerProvider;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Some reference to go through
 *  - https://blog.ambar.cloud/author/ilya/
 *  - https://www.elastic.co/guide/en/elasticsearch/plugins/current/ingest-attachment.html
 *
 */
public class WebScrapper {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService =  Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()+1);

        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cl = new Calendar.Builder()
                .setDate(2018,0,1)
                .build();
        Calendar startDate = (Calendar) cl.clone();

        cl.add(Calendar.MONTH,1);
        Calendar endDate =(Calendar) cl.clone();
        cl = Calendar.getInstance();
        cl.add(Calendar.MONTH,-1);
        Calendar currentDate = cl;
        while( startDate.compareTo(currentDate)==-1){

            System.out.println("Processing detail for date range :"+ dateFormatter.format(startDate.getTime()) + " - " + dateFormatter.format(endDate.getTime()));
            Document document = Jsoup.connect("https://www.sci.gov.in/php/getJBJ.php")
                    .data("JBJfrom_date", dateFormatter.format(startDate.getTime()))
                    .data("JBJto_date", dateFormatter.format(endDate.getTime()))
                    .data("jorrop", "J")
                    .post();
            Elements downloadUrlLinks = document.select("a");

            for(Element link : downloadUrlLinks){
                String downloadUrl = "https://www.sci.gov.in" + link.attr("href");
                executorService.submit(new FileDownloader(downloadUrl));
                System.out.println(downloadUrl);
            }

            endDate.add(Calendar.DATE,1);
            startDate = (Calendar)endDate.clone();
            endDate.add(Calendar.DATE,-1);
            endDate.add(Calendar.MONTH,1);

        }

        while (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
            executorService.shutdownNow();
        }
    }

    static class FileDownloader implements Runnable{

        private String downloadUrl;
        FileDownloader(String downloadUrl){
            this.downloadUrl = downloadUrl;
        }

        @Override
        public void run() {
            try {
                writeToFile(downloadUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private  void writeToFile(String downloadUrl) throws IOException {

            URL url = new URL(downloadUrl);
            String fileName = downloadUrl.substring(downloadUrl.lastIndexOf("/"));
            String folderPath = "/Users/i347911/judgements1/";
            InputStream in = url.openStream();

            OutputStream out = new BufferedOutputStream(new FileOutputStream(folderPath + fileName));
            byte[] buffer = new byte[1024];
            int bufferLength;

            while ((bufferLength = in.read(buffer)) != -1) {
                out.write(buffer, 0, bufferLength);
            }
            out.flush();
            out.close();
            in.close();
        }
    }

}
