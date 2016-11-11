package com.hddv;

import com.hddv.operators.DeleteDispatcher;
import com.hddv.operators.PermissionDispatcher;
import com.hddv.operators.ShareDispatcher;
import com.hddv.value.HDDVFile;

public class FileOperator {

    public static String share(HDDVFile file){
        ShareDispatcher dispatcher = new ShareDispatcher();
        return dispatcher.share(file);
    }

    public static boolean delete(String file){
        DeleteDispatcher dispatcher = new DeleteDispatcher();
        return dispatcher.deleteFile(file);
    }

    public static boolean changePermission(String file, String permission){
        PermissionDispatcher dispatcher = new PermissionDispatcher();
        return dispatcher.changePermission(file, permission);
    }
}
