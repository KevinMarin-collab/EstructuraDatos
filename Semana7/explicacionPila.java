package Semana7;

import java.util.Stack;

public class explicacionPila {
    
    public static void main(String[] args) {
        Stack<String> objPila = new Stack<>();
        objPila.push("Camilo");
        objPila.push("Santiago");
        objPila.push("Valentina");
        objPila.push("Andrea");
        objPila.push("Luisa");

        // Imprime la pila completa
        System.out.println(objPila);
        // Elimina el elemento en la cima de la pila
        System.out.println("Tope de la fila: " + objPila.peek());
        // Valida si la pila está vacía
        System.out.println("Pila vacía: " + objPila.empty());
        // Posiciones de los elementos con respecto al tope de la pila
        System.out.println("Posicion: " + objPila.search("Camilo"));
        System.out.println("Posicion: " + objPila.search("Santiago"));
        System.out.println("Posicion: " + objPila.search("Valentina"));
        System.out.println("Posicion: " + objPila.search("Andrea"));
        System.out.println("Posicion: " + objPila.search("Luisa"));
    }

}
