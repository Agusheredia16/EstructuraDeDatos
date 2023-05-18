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
        Object resultado = padreAux(elemento, this.raiz); //Va a faltar el caso especial de Raiz
        return resultado;
    }

    private Object padreAux(Object elemento, NodoGen nodo) {
        Object elemPadre = null;

        if () {
            
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

        if (raiz != null) {
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

        return nivel;
    }

    public Lista ancestros(Object elem) {
        Lista ancestros = new Lista();
        buscarAncestros(raiz, elem, ancestros);
        return ancestros;
    }

    private boolean buscarAncestros(NodoGen nodo, Object elem, Lista ancestros) {
        boolean encontrado = false;

        if (nodo != null) {
            if (nodo.getElemento().equals(elem)) {
                encontrado = true;
            } else {
                encontrado = buscarAncestros(nodo.getHijoIzq(), elem, ancestros);
                if (!encontrado) {
                    encontrado = buscarAncestros(nodo.getHermanoDer(), elem, ancestros);
                }
            }

            if (encontrado) {
                ancestros.insertar(nodo.getElemento(), 1);
            }
        }

        return encontrado;
    }

    public void vaciar() {
        raiz = null;
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

    public Lista listarPreOrden() {
        Lista salida = new Lista();
        listarPreordenAux(raiz, salida);
        return salida;
    }

    private void listarPreordenAux(NodoGen n, Lista ls) {
        if (n != null) {
            //Visita del nodo n
            ls.insertar(n.getElemento(), ls.longitud() + 1);

            //Llamado recursivo con primer hijo de n
            if (n.getHijoIzq() != null) {
                listarInordenAux(n.getHijoIzq(), ls);
            }

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
