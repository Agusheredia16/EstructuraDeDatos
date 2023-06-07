package Lista_Dinamica;

/*
@author agush
 */
public class Lista {

    private Nodo cabecera;

    public Lista() {
        this.cabecera = null;
    }

    public boolean insertar(Object elemento, int posicion) {
        //Inserta el nuevo elemento en la posicion pos
        //Detecta y reporta error posicion invalida
        boolean exito = true;
        if (posicion < 1 || posicion > this.longitud() + 1) {
            exito = false;
        } else {
            if (posicion == 1) { //crea un nuevo nodo y se enlaza en la cabecera
                this.cabecera = new Nodo(elemento, this.cabecera);
            } else { //avanza hasta el elemento pos - 1
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < posicion - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                //Crea el nodo y lo enlaza
                Nodo nuevo = new Nodo(elemento, aux.getEnlace());
                aux.setEnlace(nuevo);
            }
        }
        //Nunca hay error de lista llena, entonces devuelve true
        return exito;
    }

    public boolean eliminar(int posicion) {
        boolean exito = true;
        if (posicion < 1 || posicion > this.longitud()) {
            exito = false;
        } else {
            if (posicion == 1) {
                cabecera = cabecera.getEnlace();
            } else {
                Nodo aux = cabecera;
                int i = 1;
                while (i < posicion - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
        }
        return exito;
    }

    public Object recuperar(int posicion) {
        Object elemento = null;
        Nodo aux;
        if (posicion >= 1 && posicion <= longitud()) {
            aux = cabecera;
            int i = 1;
            while (i != posicion) {
                aux = aux.getEnlace();
                i++;
            }
            elemento = aux.getElemento();
        }
        return elemento;
    }

    public int localizar(Object elemento) {
        int posicion = -1;
        Nodo aux = cabecera;
        int i = 1;
        while (aux.getElemento() != elemento || i <= longitud()) {
            aux = aux.getEnlace();
            i++;
        }
        if (i <= longitud()) {
            posicion = i;
        }
        return posicion;
    }

    public int longitud() {
        Nodo aux = cabecera;
        int contador = 0;
        while (aux != null) {
            aux = aux.getEnlace();
            contador++;
        }
        return contador;
    }

    public void vaciar() {
        cabecera = null;
    }

    public boolean esVacia() { // Partir de la base :3
        boolean resultado = true;
        if (cabecera != null) {
            resultado = false;
        }
        return resultado;
    }

    public Lista clonar() {
        Lista copia = new Lista();
        Nodo aux = cabecera;
        int i = 1;
        while (aux != null) {
            copia.insertar(aux.getElemento(), i);
            aux = aux.getEnlace();
            i++;
        }
        return copia;
    }

    @Override
    public String toString(){
        String retorno = "Lista Vacia";
        //evaluamos que la lista no este vacia
        if(this.cabecera != null){
            retorno = "[";
            Nodo aux = this.cabecera;
            
            while(aux != null){
                retorno = retorno + aux.getElemento().toString();
                if(aux.getEnlace() != null){
                    retorno += ",";
                }
                aux = aux.getEnlace();
            }
            
            retorno += "]";
        }
        return retorno;
    }

    //Modulos de parciales
    public Lista obtenerMultiplos(int num) {
        //Ejercicio de Simulacro de parcial. INCOMPLETO

        Lista listaMult = new Lista();
        Nodo aux = cabecera;
        int contador = 1;
        while (aux != null) {
            if (contador % num == 0) {
                if (listaMult.cabecera == null) {
                    listaMult.cabecera = aux;
                }
                //listaMult.cabecera.setEnlace(Nodo newNodo = );
                //listaMult.cabecera = newNodo;
            }
            aux = aux.getEnlace();
            contador++;
        }
        return listaMult;
    }

    public void agregarElem(Object nuevo, int x) {

        Nodo aux = this.cabecera;

        while (aux != null) {

        }
    }
}
