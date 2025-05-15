package com.oabm77.conversormoneda.principal;

import com.oabm77.conversormoneda.api.Api;
import com.oabm77.conversormoneda.operaciones.Conversor;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ConversorApp {
    public static void main(String[] args) {
        final int HISTORIAL = 7;
        final int SALIR = 8;
        Scanner entrada = new Scanner(System.in);
        Api api = new Api();
        int opcion;
        double monto;
        while (true) {
            System.out.println("""
                    ********************************************************
                    Sea bienvenido/a al Conversor de Moneda =]
                    
                    1) Dólar =>> Peso argentino
                    2) Peso argentino =>> Dólar
                    3) Dólar =>> Real brasileño
                    4) Real brasileño =>> Dólar
                    5) Dólar =>> Peso colombiano
                    6) Peso colombiano =>> Dólar
                    7) Reporte de conversiones realizadas
                    8) Salir
                    ********************************************************""");
            while (true) {
                System.out.print("Elija una opción válida: ");
                try {
                    opcion = Integer.parseInt(entrada.nextLine());
                    if (api.validaOpcionConversion(opcion)) {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Sólo se números enteros");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            if (opcion == HISTORIAL) {
                Conversor.leerHistorial();
            } else if (opcion == SALIR) {
                System.out.println("!Hasta pronto!");
                break;
            } else {
                while (true) {
                    System.out.print("*** Ingrese un monto válido " + api.getBase() + ": ");
                    try {
                        monto = Double.parseDouble(entrada.nextLine());
                        if (api.validaMonto(monto)) {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Sólo se admiten números");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                String urlApi = api.configuraAPI();

                System.out.println(Conversor.ejecutar(api));
            }
            System.out.println();
        }
    }

}
