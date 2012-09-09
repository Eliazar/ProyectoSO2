/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;
import java.util.Scanner;

/**
 *
 * @author Familia Melendez
 */
public class FileSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner lea = new Scanner(System.in);
        String comando;
        System.out.println("Benji File System!!\n");
        comando = lea.nextLine();
        System.out.println("Lo que se taipeo: " + comando);
    }
}
