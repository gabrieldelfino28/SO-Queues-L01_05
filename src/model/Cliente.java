package model;

public class Cliente {
    public int numero;
    public String nome;

    public Cliente() {
        super();
    }

    public Cliente(int numero, String nome) {
        this.numero = numero;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "numero= " + numero +
                ", nome= '" + nome + '\'' +
                '}';
    }
}
