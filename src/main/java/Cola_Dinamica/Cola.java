package Cola_Dinamica;

/*
@author agush
 */
public class Cola {

    private Nodo ini;
    private Nodo fin;

    public Cola() {
        this.ini = null;
        this.fin = null;
    }

    public boolean poner(Object elemento) {
        boolean exito = true;
        if (esVacia()) {
            Nodo nuevito = new Nodo(elemento, null);
            ini = nuevito;
            fin = nuevito;
        } else {
            Nodo nuevo = new Nodo(elemento, null);
            fin.setEnlace(nuevo);
            fin = nuevo;
        }
        return exito;
    }

    public boolean sacar() {
        boolean exito = true;
        if (this.ini == null) {
            //Cola vacia ∴ ERROR
            exito = false;
        } else {
            //∃ elemento ∴ Quita el 1er elemento y actualiza el frente
            //tambien actualiza fin si ini queda vacia
            this.ini = this.ini.getEnlace();
            if (this.ini == null) {
                this.fin = null;
            }
        }
        return exito;
    }

    public Object obtenerIni() {
        Object resultado = null;
        if (!esVacia()) {
            resultado = ini.getElemento();
        }
        return resultado;
    }
    
    public Nodo obtenerNodoIni(){
        Nodo nodo = ini;
        return nodo;
    }

    public boolean esVacia() {
        boolean resultado = false;
        if (ini == null && fin == null) {
            resultado = true;
        }
        return resultado;
    }

    public void vaciar() {
        while (!esVacia()) {
            sacar();
        }
    }

    public Cola clonar() {
        Cola clon = new Cola();
        Nodo aux = this.ini;
        while (aux != null) {
            clon.poner(aux.getElemento());
            aux = aux.getEnlace();
        }
        return clon;
    }

    @Override
    public String toString() {
        String s = "[";
        Nodo aux = new Nodo(ini.getElemento(), ini.getEnlace());
        do {
            s = (s + aux.getElemento() + ", ");
            aux = aux.getEnlace();
        } while (aux.getEnlace() != null);
        s = s + aux.getElemento() + "]";
        return s;
    }

}
