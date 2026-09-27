import java.util.Scanner;

public class Interfaz {
    
    public static void main(String[] args){
        
        Scanner teclado = new Scanner(System.in);


        System.out.println("Qué nivel quieres usar: 1, 2, 3 o 4?");
        String nivel = teclado.nextLine();

        if (nivel.equals("1")){
            System.out.println("Se ejecutará el nivel 1");

        } else if (nivel.equals("2")){
            System.out.println("Se ejecutará el nivel 2");

        } else if (nivel.equals("3")){
            System.out.println("Se ejecutará el nivel 3");

        } else if (nivel.equals("4")){
            System.out.println("Se ejecutará el nivel 4");
        } else {
            System.out.println("Nivel no válido");
        }


        Lanzador lanza = new Lanzador();


        while (true){

            System.out.println("Dime un número (o escribe salir para abandonar el bucle):");

            String parametro = teclado.nextLine();

            if(parametro.equals("salir")){
                System.out.println("Saliendo...");

                break;
            }

            int codigoSalida = lanza.lanzar(nivel, parametro);
            System.out.println("Operación completada. Código de salida: " + codigoSalida);
        }

        teclado.close();
    } 
}
