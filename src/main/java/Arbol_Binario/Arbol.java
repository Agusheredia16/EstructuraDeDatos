package Arbol_Binario;

import Lista_Dinamica.Lista;
import Cola_Dinamica.Cola;
import Cola_Dinamica.Nodo;

/*
@author agush
 */
public class Arbol {

    //Atributos
    private NodoArb raiz;

    public Arbol() {
        this.raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre, char lugar) {
        /*
        Inserta elemNuevo como hijo del primer nodo encontrado en preorden igual
        a elemPadre, como hijo I o D, segun lo indique "lugar"
         */
        boolean exito = true;
        if (this.raiz == null) {
            //Si el arbol esta vacio, pone el elemNuevo en la raiz
            this.raiz = new NodoArb(elemNuevo, null, null);
        } else {
            //Si arbol no esta vacio, busca el padre
            NodoArb nPadre = obtenerNodo(this.raiz, elemPadre);

            //Si padre existe y lugar no esta ocupado lo pone, si no da error
            if (nPadre != null) {
                if (lugar == 'I' && nPadre.getIzq() == null) {
                    nPadre.setIzq(new NodoArb(elemNuevo, null, null));
                } else if (lugar == 'D' && nPadre.getDer() == null) {
                    nPadre.setDer(new NodoArb(elemNuevo, null, null));
                } else {
                    exito = false;
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }

    public boolean esVacio() {
        return raiz == null;
    }

    public Object padre(Object elemento) {
        //Este modulo devuelve el elemento del nodo padre del elemento dado por parametro
        return busquedaPadre(raiz, elemento, null);
    }

    private Object busquedaPadre(NodoArb nodo, Object buscado, Object elemAnterior) {
        Object elemento = null;
        if (nodo != null) {
            //Si el nodo es nulo, devuelve null
            if (nodo.getElemento().equals(buscado)) {
                //Si encuentra, devuelve el elem del nodo anterior
                elemento = elemAnterior;
            } else {
                //Si no encuentra, se fija en el hijo izquierdo
                elemento = busquedaPadre(nodo.getIzq(), buscado, nodo.getElemento());

                if (elemento == null) {
                    //Si no esta en el hijo izq, se fija en el derecho
                    elemento = busquedaPadre(nodo.getDer(), buscado, nodo.getElemento());
                }
            }
        }
        return elemento;
    }

    public int altura() {
        //Este modulo devuelve la altura del arbol que lo llama
        int altura;
        if (esVacio()) {
            altura = 0;
        } else {
            altura = determinarAltura(raiz, 0, 0);
        }
        return altura;
    }

    private int determinarAltura(NodoArb nodoAct, int nivelAct, int altMax) {
        if (nodoAct.getIzq() != null) {
            if (nivelAct + 1 > altMax) {
                altMax = nivelAct + 1;
            }
            altMax = determinarAltura(nodoAct.getIzq(), nivelAct + 1, altMax);
        }
        if (nodoAct.getDer() != null) {
            if (nivelAct + 1 > altMax) {
                altMax = nivelAct + 1;
            }
            altMax = determinarAltura(nodoAct.getDer(), nivelAct + 1, altMax);
        }
        return altMax;
    }

    public int nivel(Object elem) {
        int n = -1;
        NodoArb aux = raiz;
        while (obtenerNodo(aux, elem) != null) {
            if (obtenerNodo(aux.getIzq(), elem) != null) {
                aux = aux.getIzq();
            } else {
                aux = aux.getDer();
            }
            n++;
        }
        return n;
    }

    public void vaciar() {
        raiz = null;
    }

    public Arbol clonar() {
        Arbol newArbol = new Arbol();
        newArbol.raiz = raiz;

        clonarArb(newArbol.raiz, raiz);
        return newArbol;
    }

    private void clonarArb(NodoArb nodoC, NodoArb nodoO) {
        if (nodoO.getIzq() != null) {
            nodoC.setIzq(nodoO.getIzq());
            clonarArb(nodoC.getIzq(), nodoO.getIzq());
        }
        if (nodoO.getDer() != null) {
            nodoC.setDer(nodoO.getDer());
            clonarArb(nodoC.getDer(), nodoO.getDer());
        }
    }

    public String toString() {
        String texto = "El arbol esta vacio";

        if (this.raiz != null) {
            texto = auxToString(this.raiz);
        }
        return texto;
    }

    private String auxToString(NodoArb nodo) {
        String texto = "";

        texto = "Nodo: " + nodo.getElemento();
        //HI
        if (nodo.getIzq() != null) {
            texto += "\nHI: " + nodo.getIzq().getElemento();
        } else {
            texto += "\nHI: -";
        }
        //HD
        if (nodo.getDer() != null) {
            texto += " HD: " + nodo.getDer().getElemento() + "\n";
        } else {
            texto += "HD: -" + "\n";
        }

        if (nodo.getIzq() != null) {
            texto = texto + auxToString(nodo.getIzq());
        }
        if (nodo.getDer() != null) {
            texto = texto + auxToString(nodo.getDer());
        }

        return texto;
    }

    public NodoArb obtenerNodo(NodoArb n, Object buscado) {
        //Metodo PRIVADO que busca un elemento y devuelve el nodo que lo
        //contiene, si no se encuentra devuelve null
        NodoArb resultado = null;
        if (n != null) {
            if (n.getElemento().equals(buscado)) {
                //Si el buscado es n lo devuelve
                resultado = n;
            } else {
                //No es el buscado: Busca primero en el hijo izq
                resultado = obtenerNodo(n.getIzq(), buscado);
                //Si no lo encuentra, busca en el hijo der
                if (resultado == null) {
                    resultado = obtenerNodo(n.getDer(), buscado);
                }
            }
        }
        return resultado;
    }

    //Listados
    public Lista listarPreorden() {
        //Retorna una lista con los elementos del arbol en PREORDEN
        Lista lis = new Lista();
        listarPreordenAux(this.raiz, lis);
        return lis;
    }

    private void listarPreordenAux(NodoArb nodo, Lista lis) {
        //Metodo recursivo PRIVADO porque su parametro es de tipo NodoArbol
        if (nodo != null) {
            //Visita el elemento del nodo
            lis.insertar(nodo.getElemento(), lis.longitud() + 1); //1
            //Recorre a sus hijos en preorden
            listarPreordenAux(nodo.getIzq(), lis); //2
            listarPreordenAux(nodo.getDer(), lis); //3
        }
    }

    public Lista listarNiveles() {
        Lista lis = new Lista();
        listarNivelesAux(this.raiz, lis);
        return lis;
    }

    private void listarNivelesAux(NodoArb nodo, Lista lis) {

    }

    //Recorridos
    public void porNiveles() {
        Cola cola = new Cola();
        cola.poner(this.raiz);
        Nodo nodoAct = cola.obtenerNodoIni();

        while (!cola.esVacia()) {
            cola.poner(nodoAct);

        }

    }

    //Modulos de parcial
    public boolean equalss(Arbol arb2) {
        boolean resultado;
        resultado = iguales(this.raiz, arb2.raiz);
        return resultado;
    }

    private boolean iguales(NodoArb nodo1, NodoArb nodo2) {
        boolean result = false;
        
        if (nodo1 != null && nodo2 != null) {
            //if
        }

        
        return result;
    }

}
