package com.hddv;

import com.hddv.value.HDDVFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Parser {

	public List<HDDVFile> parse(String path) throws IOException, IllegalArgumentException{
		File f = new File(path);
        File[] primitiveList = f.listFiles();

        if(primitiveList == null){
            throw new IllegalArgumentException("Your file path is incorrect.");
        }

        ArrayList<File> files = new ArrayList<>(Arrays.asList(primitiveList));
		List<HDDVFile> list = new ArrayList<>();

        for (File file : files) {
            if(file.isDirectory()){
                list.addAll(parseDirectory(file));
            }else{
                list.add(parseFile(file));
            }
        }
       
		return list;
	}

    private List<HDDVFile> parseDirectory(File directory) throws IOException {
        File[] files = new File(directory.getAbsolutePath()).listFiles();
        return new ArrayList<>(Arrays.asList(files))
                .stream()
                .map(this::parseFile)
                .collect(Collectors.toList());
    }

    private HDDVFile parseFile(File file) {
        String fileName = file.getName();

        String extension = "";
        int extensionIndex = fileName.lastIndexOf(".");
        if(extensionIndex > 1){
            extension = fileName.substring(extensionIndex);
        }

        String absolutePath = file.getAbsolutePath();

        return new HDDVFile(
                fileName,
                file.length(),
                String.valueOf(file.lastModified()),
                absolutePath,
                extension);
    }
	
}


    
