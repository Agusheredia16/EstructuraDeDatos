package Arbol_BB;

/*
@author agush
 */
public class ArbolBB {

    private NodoABB raiz;

    public ArbolBB() {
        this.raiz = null;
    }

    public boolean insertar(Comparable elemento) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoABB(elemento);
        } else {
            exito = insertarAux(this.raiz, elemento);
        }
        return exito;
    }

    private boolean insertarAux(NodoABB nodo, Comparable elemento) {
        //Precondicion nodo no null
        boolean exito = true;

        if (elemento.compareTo(nodo.getElemento()) == 0) {
            //Error elemento repetido
            exito = false;
        } else if (elemento.compareTo(nodo.getElemento()) < 0) {
            //Elemento menor
            //Si tiene HI baja a la izquierda, sino agrega elemento
            if (nodo.getElemento() == null) {
                exito = insertarAux(nodo.getHijoIzq(), elemento);
            } else {
                nodo.setHijoIzq(new NodoABB(elemento));
            }
        } else if(nodo.getHijoDer() != null) {
            //Elemento mayor
            //Si HD baja a la derecha, sino agrega elemento
            exito = insertarAux(nodo.getHijoDer(), elemento);
        } else {
            nodo.setHijoDer(new NodoABB(elemento));
        }
        return exito;
    }

}
