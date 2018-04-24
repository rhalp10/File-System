/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class File_function {

    public  void mkDirectory(String pathName) {
        File file = new File(pathName);
        if (!file.exists()) {
            if (file.mkdir()) {
               echo("Directory created in ");
               echo(file.getAbsolutePath());
            } else {
                echo("Problem occured creating directory.");
            }
        } else {
           echo("Directory " + file.getAbsolutePath() + " already exists.");
        }
    }
    public  void mkMulipleDirectory(String pathName) {
        File files = new File(pathName);
        if (!files.exists()) {
            if (files.mkdirs()) {
                echo("Multiple directories are created:");
                echo(files.getAbsolutePath());
            } else {
                echo("Failed to create multiple directories!");
            }
        } else {
            echo("Directory " + files.getAbsolutePath() + " already exists.");
        }
    }
    public  void mkFile(String directory, String fileName, String fileFormat) {
        try {
            File file = new File(directory + "\\" + fileName + fileFormat);
            boolean isCreated = file.createNewFile();
            if (isCreated) {
                echo("File " + file.getName() + " has been created:");
                echo(file.getPath());
            } else {
               echo("File " + file.getName() + " already exists in ");
                System.out.println(file.getParentFile());
            }
        } catch (IOException e) {
            echo("Exception Occurred:");
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
            echo("File already exists.");
        } else {
            if (file.renameTo(newFile)) {
                echo(file.getAbsolutePath() + " is renamed to: " + newFile);
            } else {
                echo("Nothing was renamed!");
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
                echo("File copied :" + dest);
            } catch (IOException e) {
                echo("Problem occured.");
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
            echo(source.getAbsolutePath() + " is moved in " + destPath);
        } catch (IOException ex) {
            echo("Unable to find file!");
            System.err.println(ex);
        }
    }
     
     public  void hideFile(String path){
        try {
            Path hiddenpath = Paths.get(path);
            Files.setAttribute(hiddenpath, "dos:hidden", true);
            echo(hiddenpath + " is hidden");
        } catch (IOException e){
            System.err.println(e);
        }
    }
    
    public  void unHideFile(String path) {
        try {
            Path hiddenpath = Paths.get(path);
            Files.setAttribute(hiddenpath, "dos:hidden", false);
            echo(hiddenpath + " is now unhide");
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    
     public  void viewfile() {
        SimpleDateFormat sdf = new SimpleDateFormat("mm-dd-yyyy hh:mm:ss");
        
        File files = new File("C:");
        for (File file : files.listFiles()) {
            Date date = new Date(file.lastModified());
            echo(file + " Last modified: " + date);
        }
    }
     public void readCSV() throws FileNotFoundException{
        try (Scanner scanner = new Scanner(new File("C:/Sample/employees.csv"))) {
            scanner.useDelimiter(",");
            while(scanner.hasNext()){
                
                echo(scanner.next()+"|");
            }
        }
       }
     public void readCSV1() throws FileNotFoundException{
        DataOutputStream dataOut = new DataOutputStream(new
        BufferedOutputStream(new FileOutputStream("C:/Sample/employees.csv", true)));
        }
     
     public void searchbyID() throws FileNotFoundException{
         try (Scanner scanner = new Scanner(new File("C:/Sample/employees.csv"))) {
            scanner.useDelimiter(",");
            while(scanner.hasNext()){
               
                     System.out.print(scanner.next()+"|");
                
                   
            }
        }
     }
     public int genID(){
         return new Random().nextInt(1000);
     }
    protected int ID;
    protected String Name;
    protected int Age;
    protected double Salary;
     public void addemployee(int ID,String Name,int Age,String Job,double Salary){
        this.ID = ID;
        this.Name = Name;
        this.Age = Age;
        this.Salary = Salary;

        try
        {
            String filename= "C:/Sample/employees.csv";
                    try (FileWriter fw = new FileWriter(filename,true) //the true will append the new data
                    ) 
                    {
                        fw.write(ID+","+Name+","+Age+","+Salary+"\n");//appends the string to the file
                    echo("Successfully Added!");
                    } //appends the string to the file
                    
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
        
     }
     
     public void echo(String data){
      System.out.println(data);
     }

    void mkFile(String c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
