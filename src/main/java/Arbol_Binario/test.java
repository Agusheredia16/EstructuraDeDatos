package Arbol_Binario;

/*
@author agush
 */
public class test {

    public static void main(String[] args) {
        Arbol unArbol = new Arbol();
        

        unArbol.insertar('a', null, 'D');
        unArbol.insertar('b', 'a', 'I');
        unArbol.insertar('c', 'a', 'D');
        

        System.out.println(unArbol.toString());
        
    }

}
