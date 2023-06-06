package Arbol_BB;

/*
@author agush
 */
public class test {

    public static void main(String[] args) {

        ArbolBB arb = new ArbolBB();

        Comparable a = 1;
        Comparable b = 2;
        Comparable c = 3;
        Comparable d = 4;
        Comparable e = 5;
        Comparable f = 6;
        Comparable g = 7;

        arb.insertar(a);
        arb.insertar(b);
        arb.insertar(c);
        arb.insertar(d);
        arb.insertar(e);
        arb.insertar(f);
        arb.insertar(g);
        
        System.out.println(arb.pertenece(1));
        System.out.println(arb.pertenece(0));
    }

}
