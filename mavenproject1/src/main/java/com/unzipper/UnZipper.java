package com.unzipper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author owzi
 */
public class UnZipper {
    public static void main(String[] args) {
        try {  
            String zipFileName = "/home/owzi/testePC2/ola.zip";
            String destination = "/home/owzi/testePC2/";
            File destDirectoryFolder = new File(destination);
            if (!destDirectoryFolder.exists()) {
			destDirectoryFolder.mkdir();
            }
            byte[] buffer = new byte[4096];
            ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFileName));
            ZipEntry zipEntry = zis.getNextEntry();
            while (zipEntry != null){
                String filePath = destination + File.separator + zipEntry.getName();
                if(!zipEntry.isDirectory()) {
                    FileOutputStream fos = new FileOutputStream(filePath); 
                    int len;
                    while((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
                    fos.close();
                } else {
                    File dir = new File(filePath);
                    dir.mkdir();
                }
                zis.closeEntry();
                zipEntry = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
