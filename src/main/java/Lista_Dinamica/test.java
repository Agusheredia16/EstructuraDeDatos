package Lista_Dinamica;

/*
@author agush
 */
public class test {

    public static void main(String[] args) {
        Lista testLista = new Lista();

        System.out.println(testLista.insertar("x", 1));
        System.out.println(testLista.insertar("3", 2));
        System.out.println(testLista.insertar(".", 3));
        System.out.println(testLista.insertar("-", 4));

        System.out.println(testLista.toString());
    }

}