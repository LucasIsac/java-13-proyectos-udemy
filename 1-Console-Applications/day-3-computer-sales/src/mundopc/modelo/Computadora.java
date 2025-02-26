package mundopc.modelo;

public class Computadora {
    private int idComputaodra;
    private String nombre;
    private Monitor monitor;
    private Teclado teclado;
    private Raton raton;
    private static int contadorComputadoras;

    private Computadora(){
        idComputaodra = ++contadorComputadoras;
    }

    public Computadora(String nombre, Monitor monitor, Teclado teclado, Raton raton){
        this();
        this.nombre= nombre;
        this.monitor= monitor;
        this.teclado=teclado;
        this.raton=raton;
    }

    @Override
    public String toString() {
        return "idComputaodra=" + idComputaodra +
                ",  nombre='" + nombre + '\'' +
                "\n,  monitor=" + monitor +
                "\n,  teclado=" + teclado +
                "\n,  raton=" + raton;
    }
}
