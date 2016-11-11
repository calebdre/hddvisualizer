package com.hddv.operators;

import java.io.File;

public class DeleteDispatcher {
    public boolean deleteFile(String file) {
        File f =  new File(file);
        return f.delete();
    }
}
