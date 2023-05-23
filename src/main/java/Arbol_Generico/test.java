package Arbol_Generico;

import Lista_Dinamica.Lista;

/*
@author agush
 */
public class test {

    public static void main(String[] args) {

        ArbolGen arb = new ArbolGen();

        arb.insertar("numeros", null);

        arb.insertar("pares", "numeros");
        arb.insertar("impares", "numeros");
        arb.insertar("especiales", "numeros");

        arb.insertar(2, "pares");
        arb.insertar(4, "pares");
        arb.insertar(6, "pares");

        arb.insertar(1, "impares");
        arb.insertar(3, "impares");
        arb.insertar(5, "impares");

        arb.insertar("pi", "especiales");
        arb.insertar("e", "especiales");
        
        Lista lis = new Lista();
        
        lis.insertar("numeros",1);
        lis.insertar("impares",2);
        lis.insertar(3,3);
        
        System.out.println(arb.verificarPatron(lis));

        //ArbolGen arb2;
        //arb2 = arb.clonar();
        //System.out.println(arb.equals(arb2));
        //Lista lista = arb.listarNiveles();
        //System.out.println(lista.toString());
        //Lista lista = arb.listarInorden(); ................
        //System.out.println(lista.toString()); .............
        //Lista lista = arb.listarPreorden();
        //System.out.println(lista.toString());
        //ArbolGen arbCopia = arb.clonar();
        //System.out.println(arbCopia.toString());
        //arb.nivel("asd");
        //Lista lista;
        //lista = arb.ancestros(5);
        //System.out.println(lista);
        //System.out.println(arb.nivel("a"));
        /* System.out.println(arb.pertenece("miel"));
        System.out.println(arb.pertenece("e"));
        System.out.println(arb.pertenece("numeros")); */
        //System.out.println(arb.padre("miel"));
        // System.out.println(arb.padre(5));
        // System.out.println(arb.toString());
    }

}
