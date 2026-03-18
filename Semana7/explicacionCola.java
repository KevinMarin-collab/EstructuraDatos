package Semana7;

import java.util.LinkedList;
import java.util.Queue;

public class explicacionCola {
    
    public static void main(String[] args) {
        
        Queue<Integer> objCola = new LinkedList<>();

        objCola.add(29);
        objCola.add(30);
        objCola.offer(31);
        objCola.offer(32);

        System.out.println(objCola);

        System.out.println("Cabeza de la cola(Element): " + objCola.element());
        System.out.println("Cabeza de la cola(Peek): " + objCola.peek());

        System.out.println("Elemento eliminado con poll(): " + objCola.poll());
        System.out.println("Elemento eliminado con remove(): " + objCola.remove());

        System.out.println(objCola);

        System.out.println("Cola vacia: " + objCola.size());

    }

}
D