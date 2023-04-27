package Cola_Dinamica;
/*
@author Agustin Ezequiel
 */

//No deberia ser public. 
public class Nodo {

    private Object elemento;
    private Nodo enlace;

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
    
    public void setEnlace(Nodo enlace){
        this.enlace = enlace;
    }

}