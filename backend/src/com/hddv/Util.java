package com.hddv;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Util {

    public static String getUserDataPath(){
        return Util.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "../src/userdata";
    }

    public static String readFile(File f) throws IOException {
        return new String(Files.readAllBytes(f.toPath()));
    }
}
