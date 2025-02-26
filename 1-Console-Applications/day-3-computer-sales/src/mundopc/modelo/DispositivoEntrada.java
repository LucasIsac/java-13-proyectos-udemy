package mundopc.modelo;

public class DispositivoEntrada {
    private String tipoDeEntrada;
    private String marca;

    //constructor no vacio
    public DispositivoEntrada(String tipoDeEntrada, String marca){
        this.tipoDeEntrada= tipoDeEntrada;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "tipoDeEntrada='" + tipoDeEntrada + '\'' +
                ", marca='" + marca ;
    }
}
