/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
import bash.Create;


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
        boolean continuar = true;
        String shell;
        StringTokenizer tokenizador;
        ArrayList<String> parametros = new ArrayList<String>();

        do{

            try{
                System.out.print("Benji-FS:");
                shell = lea.nextLine();
                tokenizador = new StringTokenizer(shell);

                while(tokenizador.hasMoreTokens()){
                   String comando = tokenizador.nextToken();

                   if(comando.equals("create")){
                       
                       while(tokenizador.hasMoreTokens()){
                           parametros.add(tokenizador.nextToken());
                       }
                       
                       Create create = new Create(parametros);
                       //create.imprimir();
                       parametros.clear();
                       continue;
                       
                   }if (comando.equals("exit")){
                       continuar = false;
                       break;
                   }else{
                       System.out.println("Comando " + comando + " no es reconocido por el bash.");
                   }

                }
                
            }catch(Exception error){
                System.out.println(error.getMessage());
                parametros.clear();
            }    
                
        }while(continuar);
    }
}
