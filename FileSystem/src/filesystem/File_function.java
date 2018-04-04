/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Administrator
 */
public class File_function {
    public  void mkDirectory(String pathName) {
        File file = new File(pathName);
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("Directory created in ");
                System.out.println(file.getAbsolutePath());
            } else {
                System.err.println("Problem occured creating directory.");
            }
        } else {
            System.out.println("Directory " + file.getAbsolutePath() + " already exists.");
        }
    }
    public  void mkMulipleDirectory(String pathName) {
        File files = new File(pathName);
        if (!files.exists()) {
            if (files.mkdirs()) {
                System.out.println("Multiple directories are created:");
                System.out.println(files.getAbsolutePath());
            } else {
                System.out.println("Failed to create multiple directories!");
            }
        } else {
            System.out.println("Directory " + files.getAbsolutePath() + " already exists.");
        }
    }
    public  void mkFile(String directory, String fileName, String fileFormat) {
        try {
            File file = new File(directory + "\\" + fileName + fileFormat);
            boolean isCreated = file.createNewFile();
            if (isCreated) {
                System.out.println("File " + file.getName() + " has been created:");
                System.out.println(file.getPath());
            } else {
                System.out.println("File " + file.getName() + " already exists in ");
                System.out.println(file.getParentFile());
            }
        } catch (IOException e) {
            System.out.println("Exception Occurred:");
            System.err.println(e);
        }
    }
    
}
