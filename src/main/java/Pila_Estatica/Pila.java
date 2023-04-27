package Pila_Estatica;
/*
@author agush
 */
public class Pila {
    //Private:  La constante solo es accesible dentro de la clase en la que está definida
    //static: La constante es compartida por todas las instancias de la clase y no es necesario crear una instancia de la clase para acceder a ella
    //final: La constante no puede ser modificada una vez que se ha inicializado

    private Object[] arreglo;   //Xq no solo creamos un arreglo de 20? porque no tendriamos a mano el atributo TAMANIO, y seria tedioso tener que hacer arreglo.length -1 cada vez que lo necesitemos
    private int tope;
    private static final int TAMANIO = 10;

    public Pila() {
        this.arreglo = new Object[TAMANIO];
        this.tope = -1;
    }

    public boolean apilar(Object nuevoElemento) {
        boolean exito;
        if (this.tope + 1 >= Pila.TAMANIO) {
            //error pila llena
            exito = false;
        } else {
            //Pone el elemento en el tope de la pila e incrementa el tope
            this.tope++;
            this.arreglo[tope] = nuevoElemento;
            exito = true;
        }
        return exito;
    }

    public boolean desapilar() {
        boolean exito = false;
        if (!esVacia()) {
            this.tope = this.tope - 1;
            exito = true;
        }
        return exito;
    }

    public Object obtenerTope() {
        Object resultado = null;

        if (!esVacia()) {
            resultado = arreglo[tope];
        }
        return resultado;
    }

    public boolean esVacia() {
        boolean resultado = false;
        if (this.tope == -1) {
            resultado = true;
        }
        return resultado;
    }

    public void vaciar() {
        while (!esVacia()) {
            desapilar();
        }
    }

    public Pila clonar() {
        Pila pilaClon = new Pila();
        Pila pilaAux = new Pila();

        while (!esVacia()) {
            pilaAux.apilar(obtenerTope());
            desapilar();
        }
        while (!pilaAux.esVacia()) {
            apilar(pilaAux.obtenerTope());
            pilaClon.apilar(pilaAux.obtenerTope());
            pilaAux.desapilar();
        }
        return pilaClon;
    }

    @Override
    public String toString() {
        String texto ="";

        for (int i = tope; i >= 0; i--) {
            texto += "Pos" + i + ": " + this.arreglo[i] + "\n";
        }

        return texto;
    }

}

