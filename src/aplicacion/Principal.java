package aplicacion;
import dominio.Tablero;
import java.util.concurrent.TimeUnit;

public class Principal {
    public static void main(String[] args){

        Tablero tablero1 = new Tablero();

            System.out.println("\n" + "*******************************************************" + "\n" +
                    "SIMULACIÓN CON EL TABLERO GENERADO POR MONTECARLO:" + "\n" +
                    "*******************************************************" +"\n");
                tablero1.imprimirEstadoActualPorMontecarlo();
                System.out.println();

            for(int a = 0; a < 5; a++){
                TimeUnit.SECONDS.sleep(1);
                System.out.println(" La matriz siguiente es igual a:" + "\n");
                tablero1.transitarAlEstadoSiguiente();
                System.out.println();
            }