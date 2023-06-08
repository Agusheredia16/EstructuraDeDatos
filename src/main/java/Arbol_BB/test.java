package Arbol_BB;
import Lista_Dinamica.Lista;
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
        Comparable j = 2;
        

        arb.insertar(a);
        arb.insertar(b);
        arb.insertar(c);
        arb.insertar(d);
        arb.insertar(e);
        arb.insertar(f);
        arb.insertar(g);
        arb.insertar(h);
        arb.insertar(i);
        arb.insertar(j);

        //System.out.println(arb.eliminar(b));
        //System.out.println(arb.toString());

        Lista lista = new Lista();

        lista = arb.listarRango(2,15);
        
        System.out.println(lista.toString());
        
    }

}
