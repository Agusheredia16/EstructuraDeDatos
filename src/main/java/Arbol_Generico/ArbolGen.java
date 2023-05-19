package Arbol_Generico;

import Lista_Dinamica.Lista;

/*
@author agush
 */
public class ArbolGen {

    /*
    Faltan:
        postOrden():Lista
        porNiveles():Lista
     */
    private NodoGen raiz;

    public ArbolGen() {
        raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre) {
        boolean exito = false;

        if (raiz == null) {
            raiz = new NodoGen(elemNuevo);
            exito = true;
        } else {
            NodoGen nodoPadre = buscarNodo(this.raiz, elemPadre);
            if (nodoPadre != null) {

                NodoGen nuevo = new NodoGen(elemNuevo);
                if (nodoPadre.getHijoIzq() == null) {
                    nodoPadre.setHijoIzq(nuevo);
                } else {
                    NodoGen hermano = nodoPadre.getHijoIzq();
                    while (hermano.getHermanoDer() != null) {
                        hermano = hermano.getHermanoDer();
                    }
                    hermano.setHermanoDer(nuevo);
                }
                exito = true;
            }
        }
        return exito;
    }

    public NodoGen buscarNodo(NodoGen nodo, Object elemento) {
        NodoGen buscado = null;

        if (nodo != null) {
            if (nodo.getElemento().equals(elemento)) {
                buscado = nodo;
            } else {
                buscado = buscarNodo(nodo.getHijoIzq(), elemento);
                if (buscado == null) {
                    buscado = buscarNodo(nodo.getHermanoDer(), elemento);
                }
            }
        }

        return buscado;
    }

    public boolean pertenece(Object buscado) {
        return perteneceAux(buscado, raiz);
    }

    private boolean perteneceAux(Object buscado, NodoGen n) {
        boolean encontrado = false;

        if (n != null) {
            if (n.getElemento().equals(buscado)) {
                encontrado = true;
            } else {
                NodoGen hijo = n.getHijoIzq();
                while (hijo != null && !encontrado) {
                    encontrado = perteneceAux(buscado, hijo);
                    hijo = hijo.getHermanoDer();
                }
            }
        }
        return encontrado;
    }

    public boolean esVacio() {
        return raiz == null;
    }

    public Object padre(Object elemento) {
        Object resultado = null;
        if (!esVacio()) {
            if (!raiz.getElemento().equals(elemento)) {
                resultado = padreAux(elemento, raiz);
            }
        }
        return resultado;
    }

    private Object padreAux(Object elemento, NodoGen nodo) {
        Object elemPadre = null;

        if (nodo.getHijoIzq() != null && nodo.getHijoIzq().getElemento().equals(elemento)) {//veo si el elemHijo es el del hijo izq
            elemPadre = nodo.getElemento();
        } else {//busco si alguno de sus hijos es el elemHijo (elemento)
            NodoGen nodoAux = nodo.getHijoIzq();
            while (elemPadre == null && nodoAux != null) {
                if (nodoAux.getHermanoDer() != null && nodoAux.getHermanoDer().getElemento().equals(elemento)) {
                    elemPadre = nodo.getElemento();//si alguno efectivamente lo es, listo.
                }
                nodoAux = nodoAux.getHermanoDer();
            }
            if (elemPadre == null) {//Recursivo, busco entre los hijos de los hijos hasta encontrarlo
                nodoAux = nodo.getHijoIzq();
                while (elemPadre == null && nodoAux != null) {
                    elemPadre = padreAux(elemento, nodoAux);
                    nodoAux = nodoAux.getHermanoDer();
                }
            }
        }
        return elemPadre;
    }

    public int altura() {
        return alturaAux(this.raiz);
    }

    private int alturaAux(NodoGen n) {
        int aux = -1;
        int res = -1;
        if (n != null) {
            NodoGen h = n.getHijoIzq();
            while (h != null) {
                aux = alturaAux(h);
                if (aux > res) {
                    res = aux;
                }
                h = h.getHermanoDer();
            }
            res++;
        }
        return res;
    }

    public int nivel(Object buscado) {
        int nivel = -1;

        if (!esVacio() && buscado != null) {
            nivel = nivelAux(raiz, buscado, 0);
        }

        return nivel;
    }

    private int nivelAux(NodoGen nodo, Object buscado, int profundidad) {
        int nivel = -1;

        if (nodo != null) {
            if (nodo.getElemento().equals(buscado)) {
                nivel = profundidad;
            } else {
                if (nodo.getHijoIzq() != null) { // Verificar si el hijo izquierdo no es nulo
                    nivel = nivelAux(nodo.getHijoIzq(), buscado, profundidad + 1);

                    if (nivel == -1) {
                        NodoGen hermano = nodo.getHijoIzq().getHermanoDer();
                        while (hermano != null && nivel == -1) {
                            nivel = nivelAux(hermano, buscado, profundidad + 1);
                            hermano = hermano.getHermanoDer();
                        }
                    }
                }
            }
        }

        return nivel;
    }

    public Lista ancestros(Object elemento) {
        Lista lista = new Lista();
        if (!esVacio()) {
            ancestrosAux(raiz, elemento, lista);
        }
        return lista;
    }

    private boolean ancestrosAux(NodoGen raiz, Object elemento, Lista lista) {
        boolean valor = false;
        if (raiz != null) {

            if (raiz.getElemento().equals(elemento)) {
                lista.insertar(raiz.getElemento(), 1);
                valor = true;
            } else {
                NodoGen aux = raiz.getHijoIzq();

                while (aux != null && !valor) {
                    if (valor || ancestrosAux(aux, elemento, lista)) {
                        valor = true;
                    }
                    aux = aux.getHermanoDer();
                }
                if (valor) {
                    lista.insertar(raiz.getElemento(), 1);
                }
            }
        }

        return valor;
    }

    public ArbolGen clonar() {
        ArbolGen clon = new ArbolGen();
        if (raiz != null) {
            clon.raiz = new NodoGen(raiz.getElemento(), null, null);
            auxClone(raiz, clon.raiz);
        }
        return clon;
    }

    private void auxClone(NodoGen nodo1, NodoGen nodo2) {
        //Entran dos nodo, un nodo raiz, y una copia de la raiz
        if (nodo1 != null && nodo2 != null) {
            //SI ambos son distintos de nulos, entonces:
            if (nodo1.getHijoIzq() != null) {
                //Al nodo copia de la raiz, se le asigna a su hijo izquierdo(que se inicializo en el publico con null) 
                // un nuevo nodo con el hijo izquierdo del nodo raiz original
                nodo2.setHijoIzq(new NodoGen(nodo1.getHijoIzq().getElemento(), null, null));
            }

            if (nodo1.getHermanoDer() != null) {
                nodo2.setHermanoDer(new NodoGen(nodo1.getHermanoDer().getElemento(), null, null));
            }
            //Hace el llamado recursivo pero con los dos hijos izquierdo, del original y de la copia
            //los cuales ya son distintos de nulos.
            auxClone(nodo1.getHijoIzq(), nodo2.getHijoIzq());
            auxClone(nodo1.getHermanoDer(), nodo2.getHermanoDer());

        }
    }

    public void vaciar() {
        raiz = null;
    }

    public Lista listarPreorden() {
        Lista valor = new Lista();
        if (this.raiz != null) {
            preOrdenAux(this.raiz, valor);
        }
        return valor;
    }

    private void preOrdenAux(NodoGen raiz, Lista lista) {
        lista.insertar(raiz.getElemento(), lista.longitud() + 1);

        NodoGen aux = raiz.getHijoIzq();
        while (aux != null) {
            preOrdenAux(aux, lista);
            aux = aux.getHermanoDer();
        }
    }
    
    

    public Lista listarInOrden() {
        Lista salida = new Lista();
        listarInordenAux(raiz, salida);
        return salida;
    }

    private void listarInordenAux(NodoGen n, Lista ls) {
        if (n != null) {
            //Llamado recursivo con primer hijo de n
            if (n.getHijoIzq() != null) {
                listarInordenAux(n.getHijoIzq(), ls);
            }
            //Visita del nodo n
            ls.insertar(n.getElemento(), ls.longitud() + 1);

            //Llamados recursivos con los otros hijos de n 
            if (n.getHijoIzq() != null) {
                NodoGen hijo = n.getHijoIzq().getHermanoDer();
                while (hijo != null) {
                    listarInordenAux(hijo, ls);
                    hijo = hijo.getHermanoDer();
                }
            }
        }
    }

    @Override
    public String toString() {
        return toStringAux(raiz);
    }

    private String toStringAux(NodoGen n) {
        String s = " ";
        if (n != null) {
            //Visita del nodo n
            s += n.getElemento().toString() + "-->";
            NodoGen hijo = n.getHijoIzq();
            while (hijo != null) {
                s += hijo.getElemento().toString() + ", ";
                hijo = hijo.getHermanoDer();
            }
            //Comienza recorrido de los hijos de n llamando recursivamente
            //para que cada hijo agregue su subcadena a la general
            hijo = n.getHijoIzq();
            while (hijo != null) {
                s += '\n' + toStringAux(hijo);
                hijo = hijo.getHermanoDer();
            }
        }
        return s;
    }

    public Lista listarPosorden() {
        Lista lista = new Lista();
        if (!this.esVacio()) {
            posordenAux(lista, this.raiz);
        }
        return lista;
    }

    private void posordenAux(Lista lista, NodoGen nodo) {
        if (nodo != null) {
            posordenAux(lista, nodo.getHijoIzq());
            if (nodo.getHijoIzq() != null) {
                NodoGen temp = nodo.getHijoIzq().getHermanoDer(); // Selecciona el hermano derecho del nodo izquierdo
                while (temp != null) {
                    posordenAux(lista, temp);
                    temp = temp.getHermanoDer();
                }
            }
            lista.insertar(nodo.getElemento(), lista.longitud() + 1);
        }
    }

    public boolean sonFrontera(Lista lista) {
        boolean esFrontera = false;
        if (this.esVacio() && lista.esVacia()) {
            esFrontera = true;
        } else {
            Lista clon = lista.clonar();
            // Podriamos no mandar cuando la lista es vacia ya que siempre hay alguna hoja
            sonFronteraAux(this.raiz, clon);
            esFrontera = clon.esVacia();
        }
        return esFrontera;
    }

    private void sonFronteraAux(NodoGen nodo, Lista lista) {
        if (nodo != null) {
            if (null == nodo.getHijoIzq()) {
                // Solo entra si es hoja
                int i = 0;
                boolean encontrado = false;
                Lista clon = lista.clonar();
                while (!encontrado && !clon.esVacia()) {
                    encontrado = nodo.getElemento().equals(clon.recuperar(1));
                    clon.eliminar(1);
                    i++;
                }
                if (encontrado) {
                    lista.eliminar(i);
                }
            }
            if (!lista.esVacia()) {
                sonFronteraAux(nodo.getHijoIzq(), lista);
                if (!lista.esVacia()) {
                    sonFronteraAux(nodo.getHermanoDer(), lista);
                }
            }
        }
    }

}
