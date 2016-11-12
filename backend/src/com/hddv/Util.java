package com.hddv;

import java.net.URL;

public class Util {

    public static String getUserDataPath(){
        return Util.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "../src/userdata";
    }
}
