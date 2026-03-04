

public class Buque{

    private String nombre;
    private int cantidadContainers;


    public Buque(String nombre, int cantidadContainers) {
        this.nombre = nombre;
        this.cantidadContainers = cantidadContainers;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadContainers() {
        return cantidadContainers;
    }

    @Override
    public String toString() {
        return "Buque{" +
                "nombre='" + nombre + '\'' +
                ", cantidadContainers=" + cantidadContainers +
                '}';
    }

}