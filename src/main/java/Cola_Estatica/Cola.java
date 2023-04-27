package Cola_Estatica;
/*
@author agush
 */
public class Cola {

    private Object[] arreglo;
    private int prin;
    private int fin;
    private static final int TAMANIO = 10;

    public Cola() {
        this.arreglo = new Object[this.TAMANIO];
        this.prin = 0;
        this.fin = 0;
    }

    public boolean poner(Object elemento) {
        boolean exito = false;
        if (!((fin + 1) % TAMANIO == prin)) {
            this.arreglo[fin] = elemento;
            fin = (fin + 1) % TAMANIO;
            exito = true;
        }
        return exito;
    }

    public boolean sacar() {
        boolean exito = true;
        if (this.esVacia()) {
            exito = false;
        } else {
            this.arreglo[this.prin] = null;
            this.prin = (this.prin + 1) % this.TAMANIO;
        }
        return exito;
    }

    public Object obtenerFrente() {
        Object resultado = null;
        if (!esVacia()) {
            resultado = arreglo[prin];
        }
        return resultado;
    }

    public boolean esVacia() {
        boolean resultado = false;
        if (prin == fin) {
            resultado = true;
        }
        return resultado;
    }

    public void vaciar() {

        while (!esVacia()) {
            arreglo[prin] = null;
            prin = (prin + 1) % TAMANIO;
        }
        prin = 0;
        fin = 0;
    }

    public Cola clon() {
        Cola colaClon = new Cola();
        for (int i = 0; i < TAMANIO; i++) {
            colaClon.poner(this.arreglo[i]);
        }
        colaClon.prin = this.prin;
        colaClon.fin = this.fin;
        return colaClon;
    }

    @Override
    public String toString() {
        String t = "";
        if (esVacia()) {
            t = "La cola esta vacia";
        } else {
            int auxa = prin;
            while (auxa != fin) {
                t = t + arreglo[auxa].toString();
                auxa = (auxa + 1) % TAMANIO;
                if (auxa != fin) {
                    t = t + " , ";
                }
            }
        }
        return t;
    }

}
