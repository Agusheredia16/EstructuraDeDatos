package Arbol_Binario;
/*
@author agush
*/
public class NodoArb {
    //Atributos
    private Object elemento;
    private NodoArb izq;
    private NodoArb der;
    
    //Constructor
    public NodoArb(Object elemento, NodoArb izq, NodoArb der){
        this.elemento = elemento;
        this.izq = izq;
        this.der = der;
    }
    
    //Observadores
    public Object getElemento(){
        return this.elemento;
    }
    
    public NodoArb getIzq(){
        return this.izq;
    }
    
    public NodoArb getDer(){
        return this.der;
    }
        
    //Modificadores
    public void setElemento(Object elemento){
        this.elemento = elemento;
    }
    
    public void setIzq(NodoArb izq){
        this.izq = izq;
    }
    
    public void setDer(NodoArb der){
        this.der = der;
    }    
}
