package com.jose.julio.apiveiculos.algoritmos.exercicio1;

public class CalculadoraEleitoral {
    private int totalEleitores;
    private int votosValidos;
    private int votosBrancos;
    private int votosNulos;

    public CalculadoraEleitoral(int totalEleitores, int votosValidos, int votosBrancos, int votosNulos) {
        this.totalEleitores = totalEleitores;
        this.votosValidos = votosValidos;
        this.votosBrancos = votosBrancos;
        this.votosNulos = votosNulos;
    }

    public double percentualVotosValidos() {
        return ((double) votosValidos / totalEleitores) * 100;
    }

    public double percentualVotosBrancos() {
        return ((double) votosBrancos / totalEleitores) * 100;
    }

    public double percentualVotosNulos() {
        return ((double) votosNulos / totalEleitores) * 100;
    }


    public static void main(String[] args) {
        int totalEleitores = 1000;
        int votosValidos = 800;
        int votosBrancos = 150;
        int votosNulos = 50;

        CalculadoraEleitoral calculadora = new CalculadoraEleitoral(totalEleitores, votosValidos, votosBrancos, votosNulos);

        System.out.printf("Percentual de votos válidos: %.0f%%\n", calculadora.percentualVotosValidos());
        System.out.printf("Percentual de votos em branco: %.0f%%\n", calculadora.percentualVotosBrancos());
        System.out.printf("Percentual de votos nulos: %.0f%%\n", calculadora.percentualVotosNulos());
    }
}
