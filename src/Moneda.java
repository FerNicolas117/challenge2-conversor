public class Moneda {

    private String nombre;
    private double tipoCambioPesosDeMoneda;

    // Metodo Constructor
    public Moneda(String nombre, double tipoCambioPesosDeMoneda) {
        this.nombre = nombre;
        this.tipoCambioPesosDeMoneda = tipoCambioPesosDeMoneda;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTipoCambioPesosDeMoneda() {
        return tipoCambioPesosDeMoneda;
    }
}


