package Arbol_Generico;

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
        
        
     /* System.out.println(arb.pertenece("miel"));
        System.out.println(arb.pertenece("e"));
        System.out.println(arb.pertenece("numeros")); */
     
      //System.out.println(arb.padre("miel"));
        System.out.println(arb.padre("e"));
        
       // System.out.println(arb.toString());
        
        
    }

}
