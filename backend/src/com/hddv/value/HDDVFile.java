package com.hddv.value;

public class HDDVFile {
    private String name;
    private double size;
    private String dateLastModified;
    private String path;
    private String extension;

    public HDDVFile(String name, double size, String dateLastModified, String path, String extension) {
        this.name = name;
        this.size = size;
        this.dateLastModified = dateLastModified;
        this.path = path;
        this.extension = extension;
    }

    public HDDVFile() {}

    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    public String getDateLastModified() {
        return dateLastModified;
    }

    public String getPath() {
        return path;
    }

    public String getExtension() {
        return extension;
    }
}
