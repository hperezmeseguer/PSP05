import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class Lanzador {
    
    //Método que recibe el nivel y el número del usuario
    public int lanzar(String nivel, String parametro){
        
        //Según el nivel seleccionado se ejecuta un fragmento de codigo
        if (nivel.equals("1")){

            int codigoSalida = 0; //variable que guarda el codigoSalida del proceso


            try{

                //Preparación para ejecutar el comando factor con el número del usuario 
                ProcessBuilder proceso = new ProcessBuilder("factor", parametro);
                
                //Ejecuta el proceso
                Process factorizacion = proceso.start();
                
                //Obtenemos la salida o el error del proceso para leerla
                BufferedReader salidaFinal = new BufferedReader(new InputStreamReader(factorizacion.getInputStream()));
                BufferedReader error = new BufferedReader(new InputStreamReader(factorizacion.getErrorStream()));
               
                //Variable que guarda las líneas leídas
                String linea;

                //Lee y muestra todas las líneas que lea
                //readLine() lee una línea de salidaFinal y linea la guarda
                //Si no es null, muestra la línea y lee otra
                //Muestra las líneas por pantalla
                while ((linea = salidaFinal.readLine()) != null){
                    System.out.println(linea);
                    
                }
                
                //Lo mismo, pero con los errores
                while ((linea = error.readLine()) != null){
                    System.out.println(linea);
                }

                //waitFor() espera a que acabe el proceso y devuelve el código
                //codigoSalida lo guarda y asi obtenemos el valor real del código
                codigoSalida = factorizacion.waitFor();
            
            } catch (IOException | InterruptedException e){
                e.printStackTrace();
            }

            //retorna el código de Salida y está disponible para Interfaz
            return codigoSalida;

        } else if (nivel.equals("2")){

            int codigoSalida = 0; 


            try{

                
                ProcessBuilder proceso = new ProcessBuilder("factor", parametro);
                
                
                Process factorizacion = proceso.start();
                
               
                BufferedReader salidaFinal = new BufferedReader(new InputStreamReader(factorizacion.getInputStream()));
                BufferedReader error = new BufferedReader(new InputStreamReader(factorizacion.getErrorStream()));
               
                
                String linea;

                //añado OK
                while ((linea = salidaFinal.readLine()) != null){
                    System.out.println("[OK] " + linea);
                    
                }
                
                // añado ERROR
                while ((linea = error.readLine()) != null){
                    System.out.println("[ERROR] " + linea);
                }

                
                codigoSalida = factorizacion.waitFor();
            
            } catch (IOException | InterruptedException e){
                e.printStackTrace();
            }

            
            return codigoSalida;

        } else if(nivel.equals("3")){

            int codigoSalida = 0; 


            try{

                
                ProcessBuilder proceso = new ProcessBuilder("factor", parametro);
                
                
                Process factorizacion = proceso.start();
                
                //Creación de los ficheros nuevos donde se guardará la información
                //true hace que el contenido se añada al final sin borrar lo anterior
                BufferedReader salidaFinal = new BufferedReader(new InputStreamReader(factorizacion.getInputStream()));
                BufferedReader error = new BufferedReader(new InputStreamReader(factorizacion.getErrorStream()));
               
                PrintWriter factorOutput = new PrintWriter(new FileWriter("factor_output.log", true));
                PrintWriter factorError = new PrintWriter(new FileWriter("factor_error.log", true));

                String linea;

                //Lee las líneas y las escribe en el fichero
                while ((linea = salidaFinal.readLine()) != null){
                    factorOutput.println(linea);
                    
                }
                
                //Lee las líneas y las escribe en el fichero
                while ((linea = error.readLine()) != null){
                    factorError.println(linea);
                }

                
                codigoSalida = factorizacion.waitFor();

                //Se cierran los ficheros tras escribir en ellos
                factorOutput.close();
                factorError.close();
            
            } catch (IOException | InterruptedException e){
                e.printStackTrace();
            }

            
            return codigoSalida;
        }
        return 0;

    } 
    
}
