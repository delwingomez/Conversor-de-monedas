import java.util.Scanner;

public class Menu {
    ConsultaAPI consulta = new ConsultaAPI();
    public boolean iniciar = true;

    void menuPrincipal(){
        Scanner lectura = new Scanner(System.in);
        System.out.println(
                """
                        
                        ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\
                        
                        Elija el número de la conversión que desea realizar o 10 para salir: \
                        
                       \n 1.  Dolar Estadounidense USD a Peso Colombiano COP.\
                        
                        2.  Peso Mexicano MXN a Peso Argentino ARS.\
                        
                        3.  Real Brasileño BRL a Dolar Estadounidense USD.\
                        
                        4.  Peso Colombiano COP a Peso Costarricense CRC.\
                        
                        5.  Yen Japonés JPY a Peso Mexicano MXN.\
                        
                        6.  Dolar Estadounidense USD a Real Brasileño BRL.\
                        
                        7.  Euro EUR a Dolar Estadounidense USD.\
                        
                        8.  Peso Colombiano a Euro EUR.\
                        
                        9.  Dolar Estadounidense USD a Euro EUR.\
                        
                        10. Salir.\
                        
                        ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"""
        );
        try {
            var valor = Integer.parseInt(lectura.nextLine());

            if (valor == 1) {
                System.out.print("\nIngrese la cantidad de dólares a convertir: ");
                Double cantidad = Double.valueOf(lectura.next());
                System.out.println("\nEsto equivale a " + consulta.buscaMoneda("USD", "COP", cantidad) + " pesos colombianos.");
            } else if (valor == 2) {
                System.out.print("\nIngrese la cantidad de pesos a convertir: ");
                Double cantidad = Double.valueOf(lectura.next());
                System.out.println("\nEsto equivale a " + consulta.buscaMoneda("MXN", "ARS", cantidad) + " pesos argentinos.");
            } else if (valor == 3) {
                System.out.print("\nIngrese la cantidad de reales a convertir: ");
                Double cantidad = Double.valueOf(lectura.next());
                System.out.println("\nEsto equivale a " + consulta.buscaMoneda("BRL", "USD", cantidad) + " reales brasileños");
            } else if (valor == 4) {
                System.out.print("\nIngrese la cantidad de pesos a convertir: ");
                Double cantidad = Double.valueOf(lectura.next());
                System.out.println("\nEsto equivale a " + consulta.buscaMoneda("COP", "CRC", cantidad) + " pesos costarricenses.");
            } else if (valor == 5) {
                System.out.print("\nIngrese la cantidad de yenes a convertir: ");
                Double cantidad = Double.valueOf(lectura.next());
                System.out.println("\nEsto equivale a " + consulta.buscaMoneda("JPY", "MXN", cantidad) + " pesos mexicanos.");
            } else if (valor == 6) {
                System.out.print("\nIngrese la cantidad de dólares a convertir: ");
                Double cantidad = Double.valueOf(lectura.next());
                System.out.println("\nEsto equivale a " + consulta.buscaMoneda("USD", "BRL", cantidad) + " reales brasileños.");
            } else if (valor == 7) {
                System.out.print("\nIngrese la cantidad de euros a convertir: ");
                Double cantidad = Double.valueOf(lectura.next());
                System.out.println("\nEsto equivale a " + consulta.buscaMoneda("EUR", "USD", cantidad) + " dólares estadounidences.");
            } else if (valor == 8) {
                System.out.print("\nIngrese la cantidad de pesos a convertir: ");
                Double cantidad = Double.valueOf(lectura.next());
                System.out.println("\nEsto equivale a " + consulta.buscaMoneda("COP", "EUR", cantidad) + " euros.");
            } else if (valor == 9) {
                System.out.print("\nIngrese la cantidad de dólares a convertir: ");
                Double cantidad = Double.valueOf(lectura.next());
                System.out.println("\nEsto equivale a " + consulta.buscaMoneda("USD", "EUR", cantidad) + " euros.");
            } else if (valor == 10) {
                System.out.println("\nTe esperamos pronto, adiós.");
                iniciar = false;
            }

        } catch (Exception e) {
            System.out.println("\nError: Debes introducir un número válido.");
        }

    }
}
