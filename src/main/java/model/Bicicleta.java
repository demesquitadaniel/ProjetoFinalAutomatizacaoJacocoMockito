package model;

public class Bicicleta {
    private Long id;
    private String modelo;
    private int numMarchas;
    private boolean eletrica;
    private double velocidadeAtual;
    private double velocidadeMaxima;

    public Bicicleta(Long id, String modelo, int numMarchas, boolean eletrica, double velocidadeAtual, double velocidadeMaxima) {
        this.id = id;
        this.modelo = modelo;
        this.numMarchas = numMarchas;
        this.eletrica = eletrica;
        this.velocidadeAtual = velocidadeAtual;
        this.velocidadeMaxima = velocidadeMaxima;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNumMarchas() {
        return numMarchas;
    }

    public void setNumMarchas(int numMarchas) {
        this.numMarchas = numMarchas;
    }

    public boolean isEletrica() {
        return eletrica;
    }

    public void setEletrica(boolean eletrica) {
        this.eletrica = eletrica;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bicicleta bicicleta)) return false;

        if (numMarchas != bicicleta.numMarchas) return false;
        if (eletrica != bicicleta.eletrica) return false;
        if (Double.compare(bicicleta.velocidadeAtual, velocidadeAtual) != 0) return false;
        if (Double.compare(bicicleta.velocidadeMaxima, velocidadeMaxima) != 0) return false;
        if (!id.equals(bicicleta.id)) return false;
        return modelo.equals(bicicleta.modelo);
    }

//    @Override
//    public int hashCode() {
//        int result;
//        long temp;
//        result = id.hashCode();
//        result = 31 * result + modelo.hashCode();
//        result = 31 * result + numMarchas;
//        result = 31 * result + (eletrica ? 1 : 0);
//        temp = Double.doubleToLongBits(velocidadeAtual);
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        temp = Double.doubleToLongBits(velocidadeMaxima);
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        return result;
//    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", numMarchas=" + numMarchas +
                ", eletrica=" + eletrica +
                ", velocidadeAtual=" + velocidadeAtual +
                ", velocidadeMaxima=" + velocidadeMaxima +
                '}';
    }

    public double getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void setVelocidadeAtual(double velocidadeAtual) {
        this.velocidadeAtual = velocidadeAtual;
    }

    public double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(double velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }


    public void pedalar(Bicicleta bicicletaCriada, int velocidadeMais) {
    }

    public void frear(Bicicleta bicicletaCriada, int velocidadeMenos) {
    }
}