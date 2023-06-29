import javax.swing.*;
import java.text.DecimalFormat;

public class Main {

    private static final DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public static void main(String[] args) {

        // Creacionde los objetos  de Moneda
        Moneda dolar = new Moneda("Dolares", 17.12);
        Moneda euro = new Moneda("Euros", 18.59);
        Moneda librasEsterlinas = new Moneda("Libras Esterlinas", 21.59);
        Moneda yenJapones = new Moneda("Yenes Japoneses", 0.12);
        Moneda wonSurcoreano = new Moneda("Wons Sur Coreanos", 0.013);

        int respuesta = 0;

        do {
            String[] opciones = {"Peso Mexicano a Dolar", "Peso Mexicano a Euro",
                    "Peso Mexicano a Libras Esterlinas", "Peso Mexicano a Yen Japones", "Peso Mexicano a Won Sur Coreano",
                    "Dolar a Peso Mexicano", "Euro a Peso Mexicano", "Libras Esterlinas a Peso Mexicano",
                    "Yen Japones a Peso Mexicano", "Won Sur Coreano a Peso Mexicano"};

            String selectedOption = (String) JOptionPane.showInputDialog(null, "Seleccione una opción",
                    "Opciones", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

            switch (selectedOption) {
                case "Peso Mexicano a Dolar" -> convertirPesoMexicanoEnOtraMoneda(dolar);
                case "Peso Mexicano a Euro" -> convertirPesoMexicanoEnOtraMoneda(euro);
                case "Peso Mexicano a Libras Esterlinas" -> convertirPesoMexicanoEnOtraMoneda(librasEsterlinas);
                case "Peso Mexicano a Yen Japones" -> convertirPesoMexicanoEnOtraMoneda(yenJapones);
                case "Peso Mexicano a Won Sur Coreano" -> convertirPesoMexicanoEnOtraMoneda(wonSurcoreano);
                case "Dolar a Peso Mexicano" -> convertirEnPesoMexicano(dolar);
                case "Euro a Peso Mexicano" -> convertirEnPesoMexicano(euro);
                case "Libras Esterlinas a Peso Mexicano" -> convertirEnPesoMexicano(librasEsterlinas);
                case "Yen Japones a Peso Mexicano" -> convertirEnPesoMexicano(yenJapones);
                case "Won Sur Coreano a Peso Mexicano" -> convertirEnPesoMexicano(wonSurcoreano);
                default -> {
                    JOptionPane.showMessageDialog(null, "Error");
                }
            }

            respuesta = JOptionPane.showConfirmDialog(null, "Desea continuar en el programa?",
                    "Confiramacion", JOptionPane.YES_NO_CANCEL_OPTION);

        } while (respuesta == JOptionPane.YES_OPTION);

    }

    private static void convertirPesoMexicanoEnOtraMoneda (Moneda moneda) {
        boolean validarEntrada = false;
        while (!validarEntrada) {
            String entrada = JOptionPane.showInputDialog("Ingrese la cantidad en " + "pesos Mexicanos" + ": ");
            if (entrada.matches("\\d+(\\.\\d+)?")) {
                double cantidad = Double.parseDouble(entrada);
                double cantidadConvertida = cantidad / moneda.getTipoCambioPesosDeMoneda();
                String cantidadFormateada = decimalFormat.format(cantidadConvertida);
                JOptionPane.showMessageDialog(null, "Tienes: $" + cantidadFormateada + " " + moneda.getNombre());
                validarEntrada = true;
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese solo valores numericos.", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static void convertirEnPesoMexicano (Moneda moneda) {
        boolean validarEntrada = false;
        while (!validarEntrada) {
            String entrada = JOptionPane.showInputDialog("Ingrese la cantidad en " + moneda.getNombre() + ": ");
            if (entrada.matches("\\d+(\\.\\d+)?")) {
                double cantidad = Double.parseDouble(entrada);
                double cantidadConvertida = cantidad * moneda.getTipoCambioPesosDeMoneda();
                String cantidadFormateada = decimalFormat.format(cantidadConvertida);
                JOptionPane.showMessageDialog(null, "Tienes: $" + cantidadFormateada
                        + " Pesos Mexicanos");
                validarEntrada = true;
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese solo valores numericos.", "ERROR",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}