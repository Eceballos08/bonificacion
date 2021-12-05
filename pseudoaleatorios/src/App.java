import javax.swing.*;
import java.lang.Math;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class App {
    public static void main(String[] args) throws Exception {
        menuPrincipal();
    }

    public static void menuPrincipal(){
        //Declaracion de variables
        //int opcion = 0; //para seleccionar una opcion del menu

        String menuPp = "MENU PRINCIPAL\n"
                        + "1. Método de cuadrados centrales\n"
                        + "2. Método de productos centrales\n"
                        + "3. Salir\n"
                        + "\n Digite una opción: ", opcion;

        opcion = JOptionPane.showInputDialog(null, menuPp);
        acciones(opcion);
    }

    public static String ingresoSemilla1(){
        String semilla = "Ingresa el valor de la semilla: ";
        String semilla1 = JOptionPane.showInputDialog(semilla);
        return semilla1;
    }

    public static String ingresoSemilla2(){
        String semilla = "Ingresa el valor de la semilla: ";
        String semilla2 = JOptionPane.showInputDialog(semilla);
        return semilla2;
    }

    public static String ingresoCantidadAGenerar(){
        String cantidad = "Ingresa el valor de la cantidad a generar: ";
        String cantidad1 = JOptionPane.showInputDialog(cantidad);
        return cantidad1;
    }

    public static void metodoCuadradosCentrales(String semilla1, String cantidad1){
        int semillaEntero = Integer.parseInt(semilla1); //convertir de string a entero
        int cantidadEntero = Integer.parseInt(cantidad1);
        double m = 10;
        int k = semilla1.length();
        m = Math.pow(m, k);
        double xn = 0;
        int resultadoCentro = 0;
        boolean XnEsPar;
        boolean KEsPar;
        int primerCaracter = 0;
        int ultimoCaracter = 0;
        int acumulador = 0;
        acumulador = semillaEntero;

        //ciclo para ejecutar el proceso del metodo de cuadrados centrales
        //para i = 0 hasta la cantidad de digitos a generar por el usuario
        for (int i=1; i <= cantidadEntero;i++){
            xn = Math.pow(acumulador, 2);

            NumberFormat nf = DecimalFormat.getInstance();
            nf.setMaximumFractionDigits(0);
            String str = nf.format(xn);
            String x = str.replaceAll("[.]", "");

            //Validar si k y x son par o impar
            XnEsPar = x.length() % 2 == 0;
            KEsPar = k % 2 == 0;
            if((XnEsPar && !KEsPar) || (!XnEsPar && KEsPar) ){
                x = x + "0";
            }
            //proceso para extraer las cifras centrales
            primerCaracter = (x.length() - k) / 2;
            ultimoCaracter = x.length() - (x.length() - k) / 2;

            String centro = x.substring(primerCaracter, ultimoCaracter);
            resultadoCentro = Integer.parseInt(centro);
            //String.format("%.1f", );

            System.out.println(xn);
            System.out.println(resultadoCentro);
            acumulador = (int) xn;
            System.out.println(acumulador);
            //Sacar RI
        }//end for
    }//end metodoCuadradosPerfectos

    public static void metodoProductosCentrales(String semilla, String semilla2, String cantidad){
        
    }

    public static void acciones(String opcion){
        String semilla1, cantidad1, semilla2;

        switch(opcion){
            //Metodo de cuadrados centrales
            case "1":
                semilla1 = ingresoSemilla1();
                cantidad1 = ingresoCantidadAGenerar();
                metodoCuadradosCentrales(semilla1, cantidad1);
            break;
            //Metodo de productos centrales
            case "2":
                semilla1 = ingresoSemilla1();
                semilla2 = ingresoSemilla2();
                cantidad1 = ingresoCantidadAGenerar();
                //se inicializan dos variables para contar la cantidad de digitos de las semillas
                int cantidadDigitosSemilla1 = semilla1.length();
                int cantidadDigitosSemilla2 = semilla2.length();
                    //condicion para validar la cantidad de digitos de las semillas
                    if(cantidadDigitosSemilla1 != cantidadDigitosSemilla2){
                        JOptionPane.showMessageDialog(null, "Las semillas deben tener la misma cantidad de dígitos");
                        menuPrincipal();
                    } else{
                        //metodoProductosCentrales();
                    }
            break;

            case "3":
                System.exit(0);
            break;

            case "4":
                JOptionPane.showMessageDialog(null, "Ha ingresado una opción inválida");
                menuPrincipal();
                
        }
    }
}//end app
