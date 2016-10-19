package com.hddv;

import java.io.File;
//import static spark.Spark.get;

public class HDDScanner
{

    public static void main( String[] args )
    {
        int totalData = 0;
        System.out.println("Starting Scan");
        list(new File("/Users/HarshaGoli/Applications/"), totalData);
    }

    public static long list(File file, long totalData) {
        File[] children = file.listFiles();
        for (File child : children) {
            if (child.isDirectory()){
                totalData += list(child, totalData);
            } else {
                totalData += child.getTotalSpace();
            }
        }

        System.out.println(file.getName()+" is "+ totalData);

        return totalData;
    }

}
