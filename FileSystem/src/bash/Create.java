/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bash;

import java.util.ArrayList;
import Estructuras.superBloque;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;

/**
 *
 * @author eliazar
 */
public class Create {
    
    private ArrayList<String> listaParametros;
    
    public Create(ArrayList<String> lista) throws Exception{
        try{
            listaParametros = lista;
            validarParametros();
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
        
    }
    
    private void validarParametros() throws Exception{
        if(!(listaParametros.size() == 3)){
            throw new Exception("Demasiado o pocos argumentos.");
        }else{
            crearDisco();
        }    
    }
    
    private void crearDisco() throws Exception{
        try{
            String nombreArchivo = listaParametros.get(0);
            superBloque.tamanio_bloque = Integer.parseInt(listaParametros.get(1));
            superBloque.cantidad_bloques = Integer.parseInt(listaParametros.get(2));

            ByteBuffer buffer = ByteBuffer.allocate(superBloque.tamanio_bloque);
            FileOutputStream imagenDisco = new FileOutputStream(nombreArchivo);
            BufferedOutputStream bufferOut = new BufferedOutputStream(imagenDisco);

            for(int i = 0; i < superBloque.cantidad_bloques;  i++){
                bufferOut.write(buffer.array(), 0, superBloque.tamanio_bloque);
            }
        }catch(Exception error){
            throw new Exception(error.getMessage());
        }
        
    }
    
    public void imprimir(){
        for(int i = 0; i < listaParametros.size(); i++)
            System.out.println(listaParametros.get(i));
    }
    
}
