package Arbol_Heap;

/*
@author agush
 */
public class test {

    public static void main(String[] args) {

        HeapMin arb = new HeapMin();
        Comparable a = 2;
        Comparable b = 5;
        Comparable c = 10;

        System.out.println(arb.insertar(a));
        System.out.println(arb.insertar(b));
        System.out.println(arb.insertar(c));


        System.out.println(arb.heap[0]);
        System.out.println(arb.heap[1]);
        System.out.println(arb.heap[2]);
        System.out.println(arb.heap[3]);
        System.out.println(arb.heap[4]);


    }

}
