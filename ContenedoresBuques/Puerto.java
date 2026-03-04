
import java.util.Scanner;

public class Puerto {

    private Buque[] buques = new Buque[10];
    private Container[][] matriz = new Container[10][10];
    private Scanner scan = new Scanner(System.in);


    public void mostrarMenu(){

        int op;

        do{
            System.out.println("\n --- Menú Principal ---");
            System.out.println("1. Registrar Buque");
            System.out.println("2. Registrar Contenedor");
            System.out.println("3. Mostrar Peso Total");
            System.out.println("4. Listar Origen Agrupado");
            System.out.println("0. Salir");
            System.out.println("Selecciona una opción: ");

            op = scan.nextInt();
            scan.nextLine();

                switch(op){
                    case 1:
                        registrarBuque();
                        break;
                    case 2:
                        registrarContenedor();
                        break;
                    case 3:
                        mostrarPesoTotal();
                        break;
                    case 4:
                        listarOrigenAgrupado();
                        break;
                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opcion Invalida.");
                }
            } while (op != 0);
        }
    
        private void registrarBuque() {
        
            for (int i = 0; i < buques.length; i++) {
                if (buques[i] == null) {
                    
                    System.out.println("Nombre del Buque: ");
                    String nombre = scan.nextLine();

                    System.out.println("Cantidad de contenedores: ");
                    int cantidad = scan.nextInt();
                    scan.nextLine();

                    buques[i] = new Buque(nombre, cantidad);
                    System.out.println("Buque Registrado Exitosamente.");
                    return;
                }
            }

            System.out.println("No hay espacio para registrar más buques.");

        }

        private void registrarContenedor(){

            mostrarMatriz();

            System.out.println("Codigo del Contenedor: ");
            String codigo = scan.nextLine();

            System.out.println("Peso del Contenedor: ");
            double peso = scan.nextDouble();
            scan.nextLine();

            System.out.println("Origen del Contenedor: ");
            String origen = scan.nextLine();

            System.out.println("Seleccione la columna(0-9): ");
            int columna = scan.nextInt();
            scan.nextLine();

            if (columna < 0 || columna > 9) {
                
                System.out.println("Columna Invalida.");
                return;
            }

            for (int fila = 9; fila >= 0; fila--){
                if (matriz[fila][columna] == null) {
                    matriz[fila][columna] = new Container(codigo, peso, origen);
                    System.out.println("El Contenedor está ubicado en la fila " + fila + ", columna " + columna);
                    return;
                }
            }
            System.out.println("Columna llena. No se puede agregar.");
        }

        private void mostrarMatriz(){
            
            for (int i = 0; i < 10; i++) {

                for (int j = 0; j < 10; j++) {

                    if (matriz[i][j] == null) {
                        System.out.print("[ ] ");
                    } else {
                        System.out.print("[X] ");
                    }

                }
                System.out.println();
            }
        }

        private void mostrarPesoTotal(){

            double total = 0;

            for (int i = 0; i < 10; i++) {

                for (int j = 0; j < 10; j++) {

                    if (matriz[i][j] != null) {
                        total += matriz[i][j].getPeso();
                    }
                    
                }
            }
            System.out.println("Peso Total: " + total + " Kg.");
        }

        private void listarOrigenAgrupado(){

            String[] origenes = new String[10];
            int[] conteo = new int[100];
            int tamaño = 0;

            for (int i = 0; i < 10; i++) {

                for (int j = 0; j < 10; j++) {

                    if (matriz[i][j] != null) {
                        String origen = matriz[i][j].getOrigen();
                        boolean encontrado = false;

                        for (int k = 0; k < tamaño; k++) {
                            if (origenes[k].equals(origen)) {
                                conteo[k]++;
                                encontrado = true;
                                break;
                            }
                        }

                        if (!encontrado) {
                            origenes[tamaño] = origen;
                            conteo[tamaño] = 1;
                            tamaño++;
                        }
                    }
                }
            }

            System.out.println("\n --- Contenedores por Origen ---");
            for (int i = 0; i < tamaño; i++) {
                System.out.println(origenes[i] + ": " + conteo[i]);
            }
        }
}
