package gsonParser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
public class Parser {
	public static void main(String [] args) throws IOException{

		//Searches through directory and puts all contents in list "files"
		File f = new File("/Users/new/Desktop/");
		ArrayList<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));

		//grabs extension of file
		String ext1 = FilenameUtils.getExtension(files.get(3).toString());
		
		//grabs full path of file
		Path file = Paths.get(files.get(3).toString());
		
		//class that gets basic file attributes
		BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
		
		//print out info of file
		System.out.println("path: " + file);
		System.out.println("creationTime: " + attr.creationTime());
		System.out.println("lastAccessTime: " + attr.lastAccessTime());
		System.out.println("lastModifiedTime: " + attr.lastModifiedTime());
		System.out.println("size: " + attr.size());
		System.out.println("extension: " + ext1);
		    
        List<HDDVFile> list = new ArrayList<HDDVFile>();
        for (int i = 0; i < 20; i++) {
                list.add(new HDDVFile(files.get(3).toString(), attr.size(), attr.lastModifiedTime().toString(),attr.creationTime().toString(),files.get(3).toString(), ext1));
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<HDDVFile>>() {}.getType();
        String json = gson.toJson(list, type);
        System.out.println(json);
        List<HDDVFile> fromJson = gson.fromJson(json, type);
//
//        for (HDDVFile task : fromJson) {
//                System.out.println(task);
//        }
}
	

	/*
	 * ---------------This is for outputting to a json file ------------------------
	 * 
		creates the HDDFile object that contains all file info
		HDDVFile currentFile = new HDDVFile("files.get(3).toString()", attr.size(), attr.lastModifiedTime().toString(),attr.creationTime().toString(),files.get(3).toString(), ext1);
		 //converting to json
		Gson gson = new Gson();
	        String json = gson.toJson(currentFile);
	        System.out.println(json);
	        
	        //creates json file
	        try (FileWriter writer = new FileWriter("/Users/new/Desktop/out.json")) {

	            gson.toJson(file, writer);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	       */
	
	
	static long list(File file, long totalData) {
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
   


    