/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Administrator
 */
public class FileSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File_function f_func = new File_function ();

        Scanner sc = new Scanner(System.in);

        int option;

 	do {
            System.out.println("Choose transaction:");
            System.out.println("Press 'w' to withdraw");
            System.out.println("Press 'b' to check balance");
            System.out.println("Press 'd' to deposit");
            System.out.println("Press 'x' to exit");
            option = sc.nextInt();
            switch (option) {
                case 0:
			System.exit(0);
                    break;
                case 1:
                    String user_path = sc.next();
                    Path path = Paths.get("C:\\"+user_path);
                    f_func.mkDirectory(path.toString());
                    break;
                case 2:
                    f_func.mkDirectory("C:\\sample");
                    break;
                case 3:
                    f_func.mkDirectory("C:\\sample");
                    break;
                case 4:
                    f_func.mkDirectory("C:\\sample");
                    break;
                case 5:
                    f_func.mkDirectory("C:\\sample");
                    break;
                case 6:
                    f_func.mkDirectory("C:\\sample");
                    break;
                case 7:
                    f_func.mkDirectory("C:\\sample");
                    break;
                case 8:
                    f_func.mkDirectory("C:\\sample");
                    break;
                case 9:
                    f_func.mkDirectory("C:\\sample");
                    break;
                case 10:
                    f_func.mkDirectory("C:\\sample");
                    break;
                default:
                    System.out.println("Invalid input!");
            }
        } while (option != 0);
    }
    
}
