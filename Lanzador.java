import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


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
                //Si no es null, lee más líneas
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
                    System.out.println("[OK] " + linea);
                    
                }
                
                //Lo mismo, pero con los errores
                while ((linea = error.readLine()) != null){
                    System.out.println("[ERROR] " + linea);
                }

                //waitFor() espera a que acabe el proceso y devuelve el código
                //codigoSalida lo guarda y asi obtenemos el valor real del código
                codigoSalida = factorizacion.waitFor();
            
            } catch (IOException | InterruptedException e){
                e.printStackTrace();
            }

            //retorna el código de Salida y está disponible para Interfaz
            return codigoSalida;

        }
        return 0;

    } 
    
}
