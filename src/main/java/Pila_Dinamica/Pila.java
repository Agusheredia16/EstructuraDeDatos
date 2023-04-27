package Pila_Dinamica;
/*
@author Agustin Ezequiel
 */
public class Pila {

    private Nodo tope;

    public Pila() {
        this.tope = null;
    }

    public boolean apilar(Object nuevoElemento) {
        //Crea un nuevo nodo delante de la antigua cabecera
        Nodo nuevo = new Nodo(nuevoElemento, this.tope);

        //actualiza el tope para que apunte al nuevo nodo
        this.tope = nuevo;

        //Nunca hay error de pila error de pila llena, entonces devielve true
        return true;
    }

    public boolean desapilar() {
        boolean resultado = false;
        if (this.tope != null) {
            this.tope = this.tope.getEnlace();
            resultado = true;
        }
        return resultado;
    }

    public Object obtenerTope() {
        Object resultado;
        if (this.tope == null) {
            resultado = null;
        } else {
            resultado = this.tope.getElemento();
        }
        return resultado;
    }

    public boolean esVacia() {
        //Devuelve TRUE si la pila es vacia, y FALSE si no esta vacia
        boolean resultado = true;
        if (this.tope != null) {
            resultado = false;
        }
        return resultado;
    }

    public void vaciar() {
        while (esVacia() == false) {
            desapilar();
        }
    }

    public Pila clonar() {
        //Este modulo clona una pila con ayuda de una pila auxiliar
        Pila pilaClon = new Pila();
        Pila pilaAux = new Pila();
        //Copiar los elementos de la pila original a la pila auxiliar
        while (esVacia() != true) {
            pilaAux.apilar(this.obtenerTope());
            this.desapilar();
        }
        //Copiar los elementos de la pila auxiliar a la pila clon
        while (pilaAux.esVacia() != true) {
            pilaClon.apilar(pilaAux.obtenerTope());
            this.apilar(pilaAux.obtenerTope());
            pilaAux.desapilar();
        }
        return pilaClon;
    }

    @Override
    public String toString() {
        String s = " ";
        if (this.tope == null) {
            s = "Pila Vacia";
        } else {
            //Se ubica para recorrer la pila
            Nodo aux = this.tope;
            s = "[";
            while (aux != null) {
                //agrega el texto del elem y avanza
                s += aux.getElemento().toString();
                aux = aux.getEnlace();
                if (aux != null) {
                    s += ";";
                }
            }
            s += "]";
        }
        return s;
    }

}
