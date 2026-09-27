import java.io.IOException;


public class Lanzador {
    
    public int lanzar(String nivel, String parametro){

        if (nivel.equals("1")){

            int codigoSalida = 0;

            try{

                ProcessBuilder proceso = new ProcessBuilder("factor", parametro);
                Process factorizacion = proceso.start();
                codigoSalida = factorizacion.waitFor();
            
            } catch (IOException | InterruptedException e){
                e.printStackTrace();
            }

            return codigoSalida;
        } 
    }
}
