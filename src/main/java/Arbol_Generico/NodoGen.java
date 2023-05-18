package Arbol_Generico;

/*
@author agush
 */
public class NodoGen {

    private Object elemento;
    private NodoGen hijoIzq;
    private NodoGen hermanoDer;

    public NodoGen(Object elemento, NodoGen hijoIzq, NodoGen hermanoDer) {
        this.elemento = elemento;
        this.hijoIzq = hijoIzq;
        this.hermanoDer = hermanoDer;
    }
    
    public NodoGen(Object elemento){
        this.elemento = elemento;
        this.hijoIzq = null;
        this.hermanoDer = null;
    }

    public Object getElemento() {
        return elemento;
    }

    public NodoGen getHijoIzq() {
        return hijoIzq;
    }

    public NodoGen getHermanoDer() {
        return hermanoDer;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public void setHijoIzq(NodoGen hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public void setHermanoDer(NodoGen hermanoDer) {
        this.hermanoDer = hermanoDer;
    }
}
