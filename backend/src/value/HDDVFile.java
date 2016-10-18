package value;

public class HDDVFile {
    private String name;
    private double size;
    private String dateLastModified;
    private String dateCreated;
    private String path;
    private String extension;

    public HDDVFile(String name, double size, String dateLastModified, String dateCreated, String path, String extension) {
        this.name = name;
        this.size = size;
        this.dateLastModified = dateLastModified;
        this.dateCreated = dateCreated;
        this.path = path;
        this.extension = extension;
    }

    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    public String getDateLastModified() {
        return dateLastModified;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public String getPath() {
        return path;
    }

    public String getExtension() {
        return extension;
    }
}
