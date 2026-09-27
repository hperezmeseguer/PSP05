import java.util.Scanner;

public class Interfaz {
    
    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);

        while (true){

            System.out.println("Dime un número:");

            String parametro = teclado.nextLine();

            if(parametro.equals("salir")){
                System.out.println("Saliendo...");
                
                break;
            }
        }













        teclado.close();
    }

    
}
