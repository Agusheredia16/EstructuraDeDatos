package Pila_Dinamica;
/*
@author Agustin Ezequiel
 */
class Nodo {

    private Object elemento;
    private final Nodo enlace;

    //constructor
    public Nodo(Object elemento, Nodo enlace) {
        this.elemento = elemento;
        this.enlace = enlace;
    }

    //observadoras
    public Object getElemento() {
        return this.elemento;
    }

    public Nodo getEnlace() {
        return this.enlace;
    }

    //Modificadoras
    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

}
