import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner lectorMenu=new Scanner(System.in);
        int salir = 0;

        while(salir!=7){
            System.out.println("***************************************");
            System.out.println("Bienvenid@ al conversor de monedas");
            System.out.println("");
            System.out.println("1) Dólar =>> Peso Argentino");
            System.out.println("2) Peso Argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real Brasileño");
            System.out.println("4) Real Brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso Colombiano");
            System.out.println("6) Peso Colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.println("Elija una opción válida");
            System.out.println("***************************************");
            salir= lectorMenu.nextInt();

            if(salir !=7){
                Scanner opcion= new Scanner(System.in);
                System.out.println("Ingrese por favor el valor que desa convertir");
                double opcionMenu= opcion.nextDouble();
                ConsultaConversion miConsulta= new ConsultaConversion(salir,opcionMenu);
            }
        }


    }
}