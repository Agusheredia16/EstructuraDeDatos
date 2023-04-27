package Cola_Estatica;

/*
@author agush
*/
public class test {

    public static void main(String[] args) {
        
        Cola testCola = new Cola();
        
        testCola.poner("asd");
        testCola.poner("asd2");
        
        System.out.println((testCola.clon()).toString());
    }

}
