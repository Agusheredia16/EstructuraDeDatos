package Pila_Dinamica;
/*
@author agush
 */
public class test {

    public static void main(String[] args) {

        Pila testPila = new Pila();
        Pila pilaClon = new Pila();
        
        testPila.apilar("123");
        testPila.apilar("qwe");
        testPila.apilar("asd");
        
        System.out.println(testPila.toString());
        
        pilaClon = testPila.clonar();
        
        System.out.println(pilaClon + "hola soy clon");
        
        System.out.println(testPila.toString());
    }

}