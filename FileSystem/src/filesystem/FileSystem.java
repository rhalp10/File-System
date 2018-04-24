/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Administrator
 */
public class FileSystem {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        File_function f_func = new File_function ();

        Scanner sc = new Scanner(System.in);

        int option;

 	do {
            System.out.println("Please choose an option:");
            System.out.println("1. Create a directory\n" +
"2. Create multiple directory\n" +
"3. Create file\n" +
"4. Rename a directory/file\n" +
"5. Copy directory/file\n" +
"6. Move directory/file\n" +
"7. Hide directory/file\n" +
"8. Unhide directory/file\n" +
"9. Write to a text file\n" +
"10. Read text file\n"+
"11. Create CSV file\n"+
"12. Read CSV file Record Using Scanner\n"+
"13. Read CSV file Record Using DataOutputStream\n"+
"14. Search CSV file Record by Row ID \n"+
"15. Append New Record On CSV File \n"+
"0. Exit\n");
            option = sc.nextInt();
            switch (option) {
                case 0:
                        System.out.println("System Exit");
			System.exit(0);
                    break;
                case 1:
                    System.out.println("Path Source:");
                    String user_path1 = sc.next();
                    Path path = Paths.get("C:\\"+user_path1);
                    f_func.mkDirectory(path.toString());
                    break;
                case 2:
                    System.out.println("Path Source:");
                    //\\sample2\\sub1\\sub2
                    String user_path2 = sc.next();
                    f_func.mkMulipleDirectory("C:\\"+user_path2);
                    break;
                case 3:
                    System.out.println("Path Source:");
                    String user_path3 = sc.next();
                    f_func.mkFile("C:\\"+user_path3, "sample", ".txt");
                    break;
                case 4:
                    File src = new File("C:\\sample");
                    System.out.println("New File Name:");
                    String user_fname = sc.next();
                    f_func.renameDir(src, user_fname);
                    break;
                case 5:
                    File src1 = new File("C:\\sample");
                    File dest = new File("C:\\sample2\\sub1");
                    f_func.copyFile(src1, dest);
                    break;
                case 6:
                    File src2 = new File("C:\\sample");
                    File dest1 = new File("C:\\sample2\\sub1");
                    f_func.moveFile(src2, dest1);
                    break;
                case 7:
                    f_func.mkDirectory("C:\\sample");
                    break;
                case 8:
                    
                    System.out.println("Path Source:");
                    String user_path8 = sc.next();
                    String path8 = "C:\\"+user_path8;
                    f_func.hideFile(path8);
                    break;
                case 9:
                    System.out.println("Path Source:");
                    String user_path9 = sc.next();
                    String path9 = "C:\\"+user_path9;
                    f_func.unHideFile(path9);
                    break;
                case 10:
                    f_func.viewfile();
                    break;
                case 11:
                    f_func.mkDirectory("C:\\sample");
                    f_func.mkFile("C:\\sample", "employees", ".csv");
                    System.out.println("Salary:");
                    break;
                case 12:
                    f_func.readCSV();
                    break;
                case 13:
                    f_func.readCSV1();
                    break;
                case 14:
                    f_func.searchbyID();
                    break;
               case 15:
                    System.out.println("Enter name:");
                    String Name = sc.next();
                    System.out.println("Enter age:");
                    int Age = sc.nextInt();
                    System.out.println("Enter position:");
                    String Job = sc.next();
                    System.out.println("Enter salary:");
                    double Salary = sc.nextDouble();
                    f_func.addemployee(f_func.genID(),Name,Age,Job,Salary);
                   
                    break;
                default:
                    System.out.println("Invalid input!");
            }
        } while (option != 0);
        
    }
    
}
