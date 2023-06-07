package Arbol_BB;

import Lista_Dinamica.Lista;
import static java.lang.System.exit;

/*
@author agush
 */
public class ArbolBB {

    private NodoABB raiz;

    public ArbolBB() {
        this.raiz = null;
    }

    public boolean pertenece(Comparable elemento) {
        boolean resultado = false;
        if (this.raiz != null) {
            if (elemento.compareTo(this.raiz.getElemento()) == 0) {
                resultado = true;
            } else {
                resultado = perteneceAux(this.raiz, elemento);
            }
        }
        return resultado;
    }

    private boolean perteneceAux(NodoABB nodo, Comparable elemento) {
        boolean resultado = false;
        if (nodo != null) {
            int comparacion = elemento.compareTo(nodo.getElemento());
            if (comparacion == 0) {
                resultado = true;
            } else if (comparacion < 0) {
                resultado = perteneceAux(nodo.getHijoIzq(), elemento);
            } else if (comparacion > 0) {
                resultado = perteneceAux(nodo.getHijoDer(), elemento);
            }
        }

        return resultado;
    }

    public boolean insertar(Comparable elemento) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoABB(elemento);
        } else {
            exito = insertarAux(this.raiz, elemento);
        }
        return exito;
    }

    private boolean insertarAux(NodoABB nodo, Comparable elemento) {
        //Precondicion nodo no null
        boolean exito = true;

        if (elemento.compareTo(nodo.getElemento()) == 0) {
            //Error elemento repetido
            exito = false;
        } else if (elemento.compareTo(nodo.getElemento()) < 0) {
            //Elemento menor
            //Si tiene HI baja a la izquierda, sino agrega elemento
            if (nodo.getHijoIzq() != null) {
                exito = insertarAux(nodo.getHijoIzq(), elemento);
            } else {
                nodo.setHijoIzq(new NodoABB(elemento));
            }
        } else if (nodo.getHijoDer() != null) {
            //Elemento mayor
            //Si HD baja a la derecha, sino agrega elemento
            exito = insertarAux(nodo.getHijoDer(), elemento);
        } else {
            nodo.setHijoDer(new NodoABB(elemento));
        }
        return exito;
    }

    public boolean eliminar(Comparable elemento) {
        //Este modulo encuentra el nodo a eliminar, luego llama a otro modulo para realizar la operacion
        NodoABB aDeletear = this.raiz;
        NodoABB padre = new NodoABB();
        boolean exito = false;
        if (aDeletear != null) {
            while (aDeletear != null && exito != true) {
                int valor = elemento.compareTo(aDeletear.getElemento());
                if (valor == 0) {
                    int caso;
                    boolean a = aDeletear.getHijoIzq() == null;
                    boolean b = aDeletear.getHijoDer() == null;
                    if (a && b) {
                        //Caso 1, nodo sin hijos
                        caso = 1;
                    } else if (!a && !b) {
                        //Caso 3, nodo con 2 hijos
                        caso = 3;
                    } else {
                        caso = 2;
                        //caso 2, nodo con un hijo
                    }
                    exito = true;
                    eliminarAux(aDeletear, padre, caso);
                } else if (valor < 0) {
                    padre = aDeletear;
                    aDeletear = aDeletear.getHijoIzq();
                } else if (valor > 0) {
                    padre = aDeletear;
                    aDeletear = aDeletear.getHijoDer();
                }
            }
        }
        return exito;
    }

    private void eliminarAux(NodoABB nodo, NodoABB padre, int caso) {
        //Este modulo le da los datos que sean necesarios a otro modulo para realizar la eliminacion
        char hijoP = 'D';
        char hijoH = 'D';
        //Este if pregunta que hijo del nodo padre hay que eliminar
        if (padre.getHijoIzq() != null && padre.getHijoIzq().getElemento().compareTo(nodo.getElemento()) == 0) {
            hijoP = 'I';
        }

        switch (caso) {
            case 1:
                eliminarC1(hijoP, padre);
                break;

            case 2:
                //Este if pregunta que hijo del nodo hay que conectar con su padre
                if (nodo.getHijoIzq() != null) {
                    hijoH = 'I';
                }
                eliminarC2(hijoP, nodo, padre, hijoH);
                break;

            case 3:
                if (nodo.getHijoIzq().getElemento().compareTo(nodo.getHijoDer().getElemento()) > 0) {
                    hijoH = 'I';
                }

                eliminarC3(nodo);
                break;
        }

    }

    private void eliminarC1(char hijo, NodoABB padre) {
        if (padre.getElemento() != null) {
            if (hijo == 'I') {
                padre.setHijoIzq(null);
            } else {
                padre.setHijoDer(null);
            }
        } else { //Caso especial, eliminar raiz
            this.raiz = null;
        }

    }

    private void eliminarC2(char HP, NodoABB aDeletear, NodoABB nodoPadre, char HH) {
        //HP: Hijo del padre a eliminar
        //HH: Hijo del hijo a reemplazar

        NodoABB aux = aDeletear.getHijoIzq();
        if (HH == 'D') {
            aux = aDeletear.getHijoDer();
        }
        if (nodoPadre.getElemento() != null) { //Caso especial, eliminar raiz
            if (HP == 'I') {
                nodoPadre.setHijoIzq(aux);
            } else {
                nodoPadre.setHijoDer(aux);
            }
        } else {
            this.raiz = aux;
        }

    }

    private void eliminarC3(NodoABB aDeletear) {
        //HP: Hijo del nodo padre, a eliminar

        Comparable aux = buscaCandidatoXIzq(aDeletear.getHijoIzq());
        eliminar(aux);
        aDeletear.setElemento(aux);

    }

    private Comparable buscaCandidatoXIzq(NodoABB nodo) {
        //Este modulo busca un candidato a reemplazar, por la izquierda
        Comparable elemento = null;
        while (nodo != null) {
            elemento = nodo.getElemento();
            nodo = nodo.getHijoDer();
        }
        return elemento;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public Lista listar() {
        Lista lista = new Lista();

        if (this.raiz != null) {
            listarAux(this.raiz, lista);
        }

        return lista;
    }

    private void listarAux(NodoABB nodo, Lista lista) {
        //recorremos en preorden
        if (nodo != null) {
            listarAux(nodo.getHijoIzq(), lista);
            lista.insertar(nodo.getElemento(), lista.longitud() + 1);
            listarAux(nodo.getHijoDer(), lista);
        }
    }

    @Override
    public String toString() {
        String texto = "Arbol vacio";
        if (this.raiz != null) {
            texto = "";
            NodoABB nodo = this.raiz;
            texto = toStringAux(nodo);
        }

        return texto;
    }

    private String toStringAux(NodoABB nodo) {
        String n = "Nodo: ";
        String texto = "";
        if (nodo.getHijoIzq() != null && nodo.getHijoDer() != null) {
            texto = n + nodo.getElemento() + "\nHI: " + nodo.getHijoIzq().getElemento() + " HD: " + nodo.getHijoDer().getElemento() + "\n";
        } else if (nodo.getHijoIzq() != null && nodo.getHijoDer() == null) {
            texto = n + nodo.getElemento() + "\nHI: " + nodo.getHijoIzq().getElemento() + " HD: null" + "\n";
        } else if (nodo.getHijoIzq() == null && nodo.getHijoDer() != null) {
            texto = n + nodo.getElemento() + "\nHI: null " + " HD: " + nodo.getHijoDer().getElemento() + "\n";
        } else {
            texto = n + nodo.getElemento() + "\nHI: null " + " HD: null" + "\n";
        }

        if (nodo.getHijoIzq() != null) {
            texto = texto + toStringAux(nodo.getHijoIzq());
        }
        if (nodo.getHijoDer() != null) {
            texto = texto + toStringAux(nodo.getHijoDer());
        }

        return texto;
    }

}
