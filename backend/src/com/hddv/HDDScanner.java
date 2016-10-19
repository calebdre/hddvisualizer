package com.hddv;

import java.io.File;
//import static spark.Spark.get;

public class HDDScanner
{

    public static void main( String[] args )
    {
        System.out.println("Starting Scan");
        list(new File("/Users/HarshaGoli/"));
    }

    public static void list(File file) {
        System.out.println(file.getName());
        File[] children = file.listFiles();
        for (File child : children) {
            //TODO: Add if statement to stop recursive if the child is not a folder

            if (child.isDirectory()){
                list(child);
            } else {
                System.out.println(child.getTotalSpace());
            }
        }
    }

}
