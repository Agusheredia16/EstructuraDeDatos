package Arbol_Heap;

/*
@author agush
 */
public class test {

    public static void main(String[] args) {

        HeapMin arb = new HeapMin();
        Comparable a = 2;
        Comparable b = 3;
        Comparable c = 5;
        Comparable d = 7;
        Comparable e = 11;
        Comparable f = 13;
        Comparable x = 1;

        System.out.println(arb.insertar(a));
        System.out.println(arb.insertar(b));
        System.out.println(arb.insertar(c));
        System.out.println(arb.insertar(d));
        System.out.println(arb.insertar(e));
        System.out.println(arb.insertar(f));
        System.out.println(arb.insertar(x));
        
        System.out.println(arb.recureparCima());
        System.out.println(arb.esVacio());

    }

}
