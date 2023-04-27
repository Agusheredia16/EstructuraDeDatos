package Cola_Dinamica;

/*
@author agush
*/
public class test {

    public static void main(String[] args) {
        
        Cola testCola = new Cola();
        Cola copia;
        
        testCola.poner("1");
        testCola.poner("2");
        testCola.poner("3");
        testCola.poner("4");
        
        //System.out.println(testCola);
        
        copia = testCola.clonar();
        System.out.println(copia.toString());
        
        
    }
}
