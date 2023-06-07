package Arbol_BB;
/*
@author agush
*/
public class NodoABB {
    private Comparable elemento;
    private NodoABB hijoIzq;
    private NodoABB hijoDer;
    
    public NodoABB(Comparable elemento){
        this.elemento = elemento;
        this.hijoIzq = null;
        this.hijoDer = null;
    }
    public NodoABB(){
        this.elemento = null;
        this.hijoIzq = null;
        this.hijoDer = null;
    }
    
    public Comparable getElemento(){
        return this.elemento;
    }
    
    public NodoABB getHijoIzq(){
        return this.hijoIzq;
    }
    
    public NodoABB getHijoDer(){
        return this.hijoDer;
    }
    
    public void setElemento(Comparable elemento){
        this.elemento = elemento;
    }
    
    public void setHijoIzq(NodoABB nodo){
        this.hijoIzq = nodo;
    }
    
    public void setHijoDer(NodoABB nodo){
        this.hijoDer = nodo;
    }
    
    
    
}
