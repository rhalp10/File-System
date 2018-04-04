/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.text.SimpleDateFormat;
import java.util.Date;

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
     public  void renameDir(File file, String newFilename) {
        String extension = "";
        int i = file.getAbsolutePath().lastIndexOf('.');
        if (i >= 0) {
            extension = file.getAbsolutePath().substring(i + 1);
        }
        File newFile = new File(file.getParent() + "\\" + newFilename + "." + extension);
        if (newFile.exists()) {
            System.out.println("File already exists.");
        } else {
            if (file.renameTo(newFile)) {
                System.out.println(file.getAbsolutePath() + " is renamed to: " + newFile);
            } else {
                System.out.println("Nothing was renamed!");
            }
        }
    }
     void copyFile(File source, File dest) {
        if (source.isDirectory()){
            if (!dest.exists()) {
                dest.mkdir();
            }
            for (String file : source.list()) {
                copyFile(new File(source, file), new File(dest, file));
            }
        } else {
            try {
                Files.copy(source.toPath(), dest.toPath());
                System.out.println("File copied :" + dest);
            } catch (IOException e) {
                System.out.println("Problem occured.");
                System.err.println(e);
            }
        }
    }
     public  void moveFile(File source, File dest) {
        try {
            Path destPath = Paths.get(dest.getAbsolutePath());
            if (source.isFile()) {
                destPath = Paths.get(dest.getAbsolutePath() + "\\" + source.getName());
            } else if (source.isDirectory()) {
                String lastDirectory = "";
                int i = source.getAbsolutePath().lastIndexOf('\\');
                if (i >= 0) {
                    lastDirectory = source.getAbsolutePath().substring(i + 1);
                }
                destPath = Paths.get(dest.getAbsolutePath() + "\\" + lastDirectory);
            }
            Files.move(source.toPath(), destPath, REPLACE_EXISTING);
            System.out.println(source.getAbsolutePath() + " is moved in " + destPath);
        } catch (IOException ex) {
            System.out.println("Unable to find file!");
            System.err.println(ex);
        }
    }
     
     public  void hideFile(String path){
        try {
            Path hiddenpath = Paths.get(path);
            Files.setAttribute(hiddenpath, "dos:hidden", true);
            System.out.println(hiddenpath + " is hidden");
        } catch (IOException e){
            System.err.println(e);
        }
    }
    
    public  void unHideFile(String path) {
        try {
            Path hiddenpath = Paths.get(path);
            Files.setAttribute(hiddenpath, "dos:hidden", false);
            System.out.println(hiddenpath + " is now unhide");
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    
     public  void viewfile() {
        SimpleDateFormat sdf = new SimpleDateFormat("mm-dd-yyyy hh:mm:ss");
        
        File files = new File("C:");
        for (File file : files.listFiles()) {
            Date date = new Date(file.lastModified());
            System.out.println(file + " Last modified: " + date);
        }
    }

    
}
