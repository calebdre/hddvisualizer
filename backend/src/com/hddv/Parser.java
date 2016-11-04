package gsonParser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FilenameUtils;
public class Parser {
	public static void main(String [] args) throws IOException{

		System.out.println("enter full directory: ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(parse(input));
        in.close();
		
}

	static String parse(String filePath) throws IOException{
		
		//Searches through directory and puts all contents in list "files"
		File f = new File(filePath);
		ArrayList<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));
		
		//gets each file name in directory
		File f1 = new File(filePath);
		ArrayList<String> names = new ArrayList<String>(Arrays.asList(f1.list()));
		
		List<HDDVFile> list = new ArrayList<HDDVFile>();
		//grabs extension of file
		

		for (int i = 0; i < files.size(); i++) {
			
			//grabs extension of files
			String ext1 = FilenameUtils.getExtension(files.get(i).toString());
			
			//grabs full path of file
			Path file = Paths.get(files.get(i).toString());

			//class that gets basic file attributes
			BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
			
            list.add(new HDDVFile(names.get(i), attr.size(), attr.lastModifiedTime().toString(),attr.creationTime().toString(),file.toString(), ext1));

		}
		//converting to json
        Gson gson = new Gson();
        Type type = new TypeToken<List<HDDVFile>>() {}.getType();
        String json = gson.toJson(list, type);
       
		return json;
	}
	
	
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


    
