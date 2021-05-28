package com.zipper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author owzi
 */
public class Zipper {

    public static void main(String[] args) {

        String zipFile = "/home/owzi/testePC2/ola.zip";
        String srcFilename = "/home/owzi/testePC2/ola.txt";

        try {

            // create byte buffer
            byte[] buffer = new byte[4096];

            FileOutputStream fos = new FileOutputStream(zipFile);

            ZipOutputStream zos = new ZipOutputStream(fos);

            File srcFile = new File(srcFilename);

            FileInputStream fis = new FileInputStream(srcFile);

            // begin writing a new ZIP entry, positions the stream to the start of the entry data
            zos.putNextEntry(new ZipEntry(srcFile.getName()));

            int length;

            while ((length = fis.read(buffer)) > 0) {
                zos.write(buffer, 0, length);
            }

            zos.closeEntry();

            // close the InputStream
            fis.close();

            // close the ZipOutputStream
            zos.close();

        } catch (IOException ioe) {
            System.out.println("Error creating zip file" + ioe);
        }

    }

}
