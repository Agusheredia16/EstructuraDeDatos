package Lista_Dinamica;

/*
@author agush
 */
public class test {

    public static void main(String[] args) {
        
        Lista testLista = new Lista();

        System.out.println(testLista.insertar("a", 1));
        System.out.println(testLista.insertar("b", 2));
        System.out.println(testLista.insertar("c", 3));
        System.out.println(testLista.insertar("d", 4));

        System.out.println(testLista.obtenerMultiplos(2));
    }

}