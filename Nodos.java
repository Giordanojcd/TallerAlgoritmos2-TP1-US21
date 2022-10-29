// Universidad Siglo XXI
// Trabajo practico Nº1
// Giordano, Juan Carlos Daniel
// Materia: Taller de Algoritmos 2
// VINF011353
import java.util.ArrayList;
import java.util.List;

public class Nodos { //declaramos que son los 'Nodos'
    private int value;
    private List<Nodos> hijos;

    public Nodos(int valor) {
        this.value = valor;
        this.hijos = new ArrayList<>(); //utilizamos el ArrayList para almacenar los hijos de forma secuencial
    }

    public Nodos agregarHijo(int valor) { //Nodos hijos nuevos
        Nodos nuevoNodo = new Nodos(valor);
        this.hijos.add(nuevoNodo);
        return nuevoNodo;
    }

    public List<Nodos> obtenerHijos(){
        return this.hijos;
    }

    public int getValue(){
        return this.value;
    }

    @Override
    public String toString() {
        String NombreHijos = "";
        for (Nodos child : this.hijos){
            NombreHijos = NombreHijos + Integer.toString(child.getValue() + 1) + " - ";
        }
        if(NombreHijos.length() > 3){
            NombreHijos = NombreHijos.substring(0,NombreHijos.length() - 3);
        }
        String resultado =
                "Del Nodo D" + Integer.toString(this.value + 1)
                        + " encontramos los hijos:  [" + NombreHijos + "]"; //imprimimos en pantalla los hijos segun el nodo

        return resultado;
    }
}