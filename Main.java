// Universidad Siglo XXI
// Trabajo practico Nº1
// Giordano, Juan Carlos Daniel
// Materia: Taller de Algoritmos 2
// VINF011353
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static int datoDeEntrada(String msg){ // Se toma los registros de entrada y se guardan en la variable 'datazo'
        int datazo = 0;
        boolean correcto = false;
        Scanner in = new Scanner(System.in);
        try {
            while (!correcto) {
                System.out.println(msg);
                datazo = in.nextInt();
                if (datazo < 1 || datazo > 13) { // se limita que los datos de entrada sean entre los numeros 1 y 13
                    System.out.println("Favor de Ingresar un valor mayor que 0 y menor que 13!");
                } else {
                    correcto = true;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Los valores ingresados deben ser numericos entre 1 y 13");
            datoDeEntrada(msg);
        }
        return datazo;
    }

    public static void main(String[] args) {
        Grafo g = new Grafo(13); // Se insertan los vertices en el Grafo

        
        g.grafAri(0, 1, 200);
        g.grafAri(0, 8, 290);
        g.grafAri(0, 12, 250);
        g.grafAri(1, 2, 190);
        g.grafAri(1, 5, 360);
        g.grafAri(2, 0, 300);
        g.grafAri(2, 4, 190);
        g.grafAri(2, 5, 250);
        g.grafAri(3, 2, 180);
        g.grafAri(4, 5, 300);
        g.grafAri(4, 9, 400);
        g.grafAri(5, 10, 350);
        g.grafAri(5, 11, 300);
        g.grafAri(6, 0, 150);
        g.grafAri(6, 2, 250);
        g.grafAri(6, 3, 300);
        g.grafAri(7, 0, 220);
        g.grafAri(7, 6, 200);
        g.grafAri(8, 7, 180);
        g.grafAri(8, 12, 180);
        g.grafAri(9, 3, 200);
        g.grafAri(10, 4, 200);
        g.grafAri(10, 9, 700);
        g.grafAri(11, 1, 150);
        g.grafAri(12, 1, 200);
        g.grafAri(12, 11, 100);


  
        String ANSI_RED = "\u001B[31m"; // Poniendole colores al system.out.print
        String ANSI_GREEN = "\u001B[32m";// Poniendole colores al system.out.print
        String ANSI_RESET = "\u001B[0m";// Poniendole colores al system.out.print
        System.out.println(ANSI_RED + "            ______");
        System.out.println( "            _| _~-|___ ");
        System.out.println( "    =  = ==(____AA____D");
        System.out.println( "                |_____|___________________,-~~~~~~~`-.._");
        System.out.println( "                /     o O o o o o O O o o o o o o O o  ||_");
        System.out.println( "                `~-.__        ___..----..                  )");
        System.out.println( "                      `---~~|__________|------------`````");
        System.out.println( "                      =  ===(_________D");
        System.out.println("Bienvenidos al Aeropuerto Internacional de Denver"+ ANSI_RESET);
        System.out.println(ANSI_GREEN + "╔═════════════════════════════════════════════════════════╗ " + ANSI_RESET);
        System.out.println(ANSI_GREEN + "║SE GENERA EL GRAFO CON LA SIGUIENTE MATRIZ DE ADYACENCIA:║ " + ANSI_RESET);
        System.out.println(ANSI_GREEN + "╚═════════════════════════════════════════════════════════╝  " + ANSI_RESET);
        g.MostrarGrafo();      // Muestra en pantalla el Matriz de Adyacencia
        int origen = datoDeEntrada(ANSI_RED + "Para el Calculo de Km's Minimos: Ingrese el Nodo de Origen (Mayor o igual que 1 y menor o igual que 13)"+ ANSI_RESET);
        System.out.println(ANSI_GREEN + "╔═════════════════════════════════════════════════════════╗ " + ANSI_RESET);
        System.out.println(ANSI_GREEN + "║       CAMINOS CORTO SIN PESOS A TODOS LOS NODOS:        ║"+ ANSI_RESET);
        System.out.println(ANSI_GREEN + "╚═════════════════════════════════════════════════════════╝  " + ANSI_RESET);
        g.caminoMinimoSinPeso(g.mostrarMatAdy(), origen - 1);      // Muestra en pantalla segun el ingreso el camino sin peso de la seleccion.
        System.out.println(ANSI_GREEN + "╔═══════════════════╗ " + ANSI_RESET);
        System.out.println(ANSI_GREEN + "║     DIJKSTRA:     ║" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "╚═══════════════════╝ " + ANSI_RESET);
        int inicio = datoDeEntrada(ANSI_RED + "Ingresar Nodo de Origen:(Mayor o igual que 1 y menor o igual que 13)"+ ANSI_RESET);
        int fin = datoDeEntrada(ANSI_RED + "Ingresar Nodo Final: (Mayor o igual que 1 y menor o igual que 13)" + ANSI_RESET);
        g.dijkstra(inicio-1, fin-1);
        System.out.println(ANSI_GREEN + "╔════════════════════════════════════╗ " + ANSI_RESET);
        System.out.println(ANSI_GREEN + "║   ARBOL: Ver Hijos de cada Nodo    ║"+ ANSI_RESET);
        System.out.println(ANSI_GREEN + "╚════════════════════════════════════╝ " + ANSI_RESET);
        int raiz = datoDeEntrada(ANSI_RED + "Ingrese valor (Mayor o igual que 1 y menor o igual que 13)"+ ANSI_RESET);
        ArbolTDA arbol = new ArbolTDA(raiz-1, g.mostrarMatAdy());
        arbol.imprimirArbol();
    }
}