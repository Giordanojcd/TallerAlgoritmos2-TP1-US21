// Universidad Siglo XXI
// Trabajo practico Nº1
// Giordano, Juan Carlos Daniel
// Materia: Taller de Algoritmos 2
// VINF011353
import java.util.HashSet;
import java.util.Set;

public class ArbolTDA {

    private int[][] matriz;
    private Nodos raiz;

    public ArbolTDA(int raiz, int[][] matriz){
        this.matriz = matriz;
        boolean[] verticeYaProcesado = new boolean[this.matriz.length];
        for (int i = 0; i < this.matriz.length; i++) {
            verticeYaProcesado[i] = false;
        }

        //Genero el nodo raiz y se marca como ya procesado
        this.raiz = new Nodos(raiz);
        verticeYaProcesado[raiz] = true;
        Set<Nodos> nodos = new HashSet<>();
        nodos.add(this.raiz);

        this.cambiosEnArbol(nodos,verticeYaProcesado);
    }

    private void cambiosEnArbol(Set<Nodos> nodos, boolean[] verticeYaProcesado) {
        Set<Nodos> nodos_tmp = new HashSet<>();
        // Recorro todos los nodos hijos para generar el nodo del arbol correspondiente a cada uno
        for (Nodos nodo : nodos){
            for(int i = 0; i < this.matriz.length; i++){
                if (this.matriz[nodo.getValue()][i] != 0 && !verticeYaProcesado[i]){
                    // agrega los nodos al padre y los marca como procesados
                    nodos_tmp.add(nodo.agregarHijo(i));
                    verticeYaProcesado[i] = true;
                }
            }
        }
        // al no crear nodos nuevos se da por terminada la recursividad
        if(!nodos_tmp.isEmpty()){
            this.cambiosEnArbol(nodos_tmp,verticeYaProcesado);
        }
    }

    public void imprimirArbol() {
        this.imprimirArbol(this.raiz);
    }

    private void imprimirArbol(Nodos nodo) {
        if(!nodo.obtenerHijos().isEmpty()) {
            for (Nodos child : nodo.obtenerHijos()){
                this.imprimirArbol(child);
            }
        }
        System.out.println(nodo);
    }
}
