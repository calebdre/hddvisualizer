package com.hddv;

import com.hddv.value.HDDVFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
            list.addAll(parseFile(file));
        }
       
		return list;
	}

    private List<HDDVFile> parseDirectory(File directory) {
        File[] files = new File(directory.getAbsolutePath()).listFiles();
        List<HDDVFile> hddvFiles = new ArrayList<>();
        if(files == null) return hddvFiles;
        for(File f: files){
            hddvFiles.addAll(parseFile(f));
        }

        return hddvFiles;
    }

    private List<HDDVFile> parseFile(File file) {
        if(file.isDirectory()){
            return parseDirectory(file);
        }

        String fileName = file.getName();

        String extension = "";
        int extensionIndex = fileName.lastIndexOf(".");
        if(extensionIndex > 1){
            extension = fileName.substring(extensionIndex);
        }

        String absolutePath = file.getAbsolutePath();

        return Collections.singletonList(new HDDVFile(
                fileName,
                file.length(),
                String.valueOf(file.lastModified()),
                absolutePath,
                extension));
    }
}


    
