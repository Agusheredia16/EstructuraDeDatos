package Arbol_BB;

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
        boolean exito = false;
        if (aDeletear != null) {
            while (aDeletear != null && exito != true && elemento.compareTo(aDeletear.getElemento()) != 0) {
                System.out.println("iagm 2");
                System.out.println(aDeletear.getElemento());
                int valor = elemento.compareTo(aDeletear.getElemento());
                if (valor == 0) {
                    System.out.println("Voy a eliminar: " + aDeletear.getElemento());
                    //exito = eliminarAux(aDeletear);
                } else if (valor < 0) {
                    System.out.println("holi");
                    aDeletear = aDeletear.getHijoIzq();
                } else if (valor > 0) {
                    aDeletear = aDeletear.getHijoIzq();
                }
            }
        }
        return exito;
    }

    @Override
    public String toString() {
        String texto = "";
        NodoABB nodo = this.raiz;

        texto = toStringAux(nodo);

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
