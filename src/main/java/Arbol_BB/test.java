package Arbol_BB;

/*
@author agush
 */
public class test {

    public static void main(String[] args) {

        ArbolBB arb = new ArbolBB();

        Comparable a = 12;
        Comparable b = 7;
        Comparable c = 15;
        Comparable d = 4;
        Comparable e = 9;
        Comparable f = 13;
        Comparable g = 16;
        Comparable h = 10;
        Comparable i = 14;
        

        arb.insertar(a);
        arb.insertar(b);
        arb.insertar(c);
        arb.insertar(d);
        arb.insertar(e);
        arb.insertar(f);
        arb.insertar(g);
        arb.insertar(h);
        arb.insertar(i);

        
        System.out.println(arb.eliminar(4));

    }

}
