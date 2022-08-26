package com.fjar.evaluacinsemana4;

public class Operaciones {

    public double CalcularHipotenusa(int valorA, int valorB){
        double ladoA = Math.pow(valorA, 2);
        double ladoB = Math.pow(valorB, 2);

        double hipotenusa = ladoA + ladoB;
        return hipotenusa;
    }

    public double calcVolumenCubo(int lados){
        double volumen = 0;

        volumen = Math.pow(lados, 3);

        return volumen;

    }

    public double calcVolumenCilindro(int radio, int altura){
        double volumen = 0;
        double radios = Math.pow(radio, 2);
        volumen = (Math.PI * radios) * altura;

        return volumen;

    }
    public double calcVolumenEsfera(int radio){
        double volumen = 0;
        double radios = Math.pow(radio, 3);
        volumen = ((4/3) * Math.PI * radios);

        return volumen;

    }
}
