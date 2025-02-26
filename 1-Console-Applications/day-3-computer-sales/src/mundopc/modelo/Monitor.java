package mundopc.modelo;

public class Monitor {
    private final int idMonitor;
    private String marca;
    private double tamanio;
    private static int contadorMonitor;

    //constructor
    private Monitor(){
        idMonitor= ++contadorMonitor;
    }

    public Monitor(String marca, double tamanio){
        this();
        this.marca = marca;
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        return "idMonitor=" + idMonitor +
                ", marca='" + marca + '\'' +
                ", tamanio=" + tamanio ;
    }
}
