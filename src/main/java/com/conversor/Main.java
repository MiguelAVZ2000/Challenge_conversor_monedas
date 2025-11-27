package com.conversor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiHandler apiHandler = new ApiHandler();
        int opcion = 0;

        System.out.println("**************************************************");
        System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
        System.out.println("**************************************************");

        while (opcion != 7) {
            System.out.println("\n1) Dólar =>> Peso Argentino");
            System.out.println("2) Peso Argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real Brasileño");
            System.out.println("4) Real Brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso Colombiano");
            System.out.println("6) Peso Colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.print("Elija una opción válida: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                if (opcion >= 1 && opcion <= 6) {
                    System.out.print("Ingrese el valor que desea convertir: ");
                    double valor = Double.parseDouble(scanner.nextLine());
                    String monedaOrigen = "";
                    String monedaDestino = "";

                    switch (opcion) {
                        case 1: monedaOrigen = "USD"; monedaDestino = "ARS"; break;
                        case 2: monedaOrigen = "ARS"; monedaDestino = "USD"; break;
                        case 3: monedaOrigen = "USD"; monedaDestino = "BRL"; break;
                        case 4: monedaOrigen = "BRL"; monedaDestino = "USD"; break;
                        case 5: monedaOrigen = "USD"; monedaDestino = "COP"; break;
                        case 6: monedaOrigen = "COP"; monedaDestino = "USD"; break;
                    }

                    double tasaDeCambio = apiHandler.obtenerTasaDeCambio(monedaOrigen, monedaDestino);

                    if (tasaDeCambio != -1) {
                        double resultado = valor * tasaDeCambio;
                        System.out.printf("El valor de %.2f %s corresponde a %.2f %s%n",
                                valor, monedaOrigen, resultado, monedaDestino);
                    } else {
                        System.out.println("No se pudo obtener la tasa de cambio para la conversión.");
                    }

                } else if (opcion != 7) {
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor, ingrese un número válido.");
            }
        }

        System.out.println("Gracias por usar el conversor de monedas. ¡Hasta luego!");
        scanner.close();
    }
}
