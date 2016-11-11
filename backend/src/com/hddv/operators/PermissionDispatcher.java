package com.hddv.operators;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

public class PermissionDispatcher {
    public boolean changePermission(String path, String permission) {
        File f = new File(path);
        Set<PosixFilePermission> set = new HashSet<>();
        set.add(PosixFilePermission.OWNER_READ);
        try {
            Files.setPosixFilePermissions(f.toPath(), set);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
