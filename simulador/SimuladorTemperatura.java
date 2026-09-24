import java.util.Random;

public class SimuladorTemperatura {

    static String[] opciones = {
        "BiblioTec",
        "LectoGo",
        "NubeDeTinta",
        "LibroPlus",
        "Biblioteca360"
    };

    static double[] puntajes = {
        3.0,
        1.5,
        1.0,
        2.0,
        2.5
    };

    public static void main(String[] args) {

        double temperatura = Double.parseDouble(args[0]);

        double[] prob = calcularProbabilidades(temperatura);

        System.out.println("Temperatura: " + temperatura);
        System.out.println("Probabilidades:");

        for (int i = 0; i < opciones.length; i++) {
            System.out.printf("%s: %.2f%%%n", opciones[i], prob[i] * 100);
        }

        Random azar = new Random();

        System.out.println("\n5 intentos:");

        for (int i = 0; i < 5; i++) {
            System.out.print(elegir(prob, azar) + (i < 4 ? ", " : "\n"));
        }
    }

    static double[] calcularProbabilidades(double t) {

        double[] prob = new double[puntajes.length];

        if (t <= 0) {
            // Temperatura 0: siempre la opción con mayor puntaje
            prob[0] = 1.0;
            return prob;
        }

        double suma = 0;

        for (int i = 0; i < puntajes.length; i++) {
            prob[i] = Math.exp(puntajes[i] / t);
            suma += prob[i];
        }

        for (int i = 0; i < prob.length; i++) {
            prob[i] = prob[i] / suma;
        }

        return prob;
    }

    static String elegir(double[] prob, Random azar) {

        double r = azar.nextDouble();
        double acumulado = 0;

        for (int i = 0; i < prob.length; i++) {
            acumulado += prob[i];

            if (r < acumulado) {
                return opciones[i];
            }
        }

        return opciones[opciones.length - 1];
    }
}

