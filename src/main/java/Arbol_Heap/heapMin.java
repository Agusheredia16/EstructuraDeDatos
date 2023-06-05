package Arbol_Heap;

/*
@author agush
 */
public class HeapMin {

    public Comparable[] heap;
    private int ultimo;
    private int TAMANIO = 15;

    public HeapMin() {
        this.heap = new Comparable[TAMANIO];
        this.ultimo = 0; // La posicion 0 nunca se usa
    }

    public boolean insertar(Comparable elemento) {
        boolean exito = false;

        if (this.ultimo == 0) {
            exito = true;
            this.heap[1] = elemento;
            this.ultimo++;
        } else if (this.ultimo < this.TAMANIO) {
            hacerSubir(elemento);
            this.ultimo++;
            exito = true;
        }
        return exito;
    }

    private void hacerSubir(Comparable elemento) {
        int aux = this.ultimo + 1;
        this.heap[aux] = elemento;

        while (this.heap[aux / 2] != null && this.heap[aux].compareTo(this.heap[aux / 2]) < 0) {
            this.heap[aux] = this.heap[aux / 2];
            this.heap[aux / 2] = elemento;
            aux = aux / 2;
        }


    }

    public boolean eliminarCima() {
        boolean exito;

        if (this.ultimo == 0) {
            //estructura vacia
            exito = false;
        } else {
            //saca la raiz y pone la ultima hoja en su lugar
            this.heap[1] = this.heap[ultimo];
            this.ultimo--;
            //restablece la propiedad de heap minimo
            hacerBajar(1);
            exito = true;
        }
        return exito;
    }

    private void hacerBajar(int posPadre) {
        int posH;
        Comparable temp = this.heap[posPadre];
        boolean salir = false;

        while (!salir) {
            posH = posPadre * 2;
            if (posH <= this.ultimo) {
                //Tiene al menos 1 hijo (izq) y lo considera menor
                if (posH < this.ultimo) {
                    //Hijo menor tiene hermano derecho

                    if (this.heap[posH + 1].compareTo(this.heap[posH]) < 0) {
                        //El hijo derecho es el menor de los 2
                        posH++;
                    }
                }
                //Compara el hijo menor con el padre
                if (this.heap[posH].compareTo(temp) < 0) {
                    //El hijo es menor que el padre, se intercambian
                    this.heap[posPadre] = this.heap[posH];
                    this.heap[posH] = temp;
                    posPadre = posH;
                } else {
                    //El padre es menor a sus hijos, esta bien ubicado, no se intercambian
                    salir = true;
                }

            } else {
                //El temp es hoja, esta bien ubicado
                salir = true;
            }

        }

    }

}
