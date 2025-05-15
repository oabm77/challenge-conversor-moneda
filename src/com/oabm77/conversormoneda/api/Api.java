package com.oabm77.conversormoneda.api;

import com.oabm77.conversormoneda.operaciones.Conversor;

public class Api {
    private String apiKey = "4b018f02a15064569dd48521";
    private final String apiUrlBase = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/[base]/[objetivo]/[monto]";
    private String apiUrl;
    private int api;
    private String base;
    private String objetivo;
    private double monto;

    public boolean validaMonto(double monto) {
        if (monto >= 0) {
            this.monto = monto;
            return true;
        }
        return false;
    }

    public boolean validaOpcionConversion(int opcion) {
        boolean valido = true;
        switch (opcion) {
            case 1:
                this.base = "USD";
                this.objetivo = "ARS";
                break;
            case 2:
                this.base = "ARS";
                this.objetivo = "USD";
                break;
            case 3:
                this.base = "USD";
                this.objetivo = "BRL";
                break;
            case 4:
                this.base = "BRL";
                this.objetivo = "USD";
                break;
            case 5:
                this.base = "USD";
                this.objetivo = "COP";
                break;
            case 6:
                this.base = "COP";
                this.objetivo = "USD";
                break;
            case 7:
            case 8:
                break;
            default:
                valido = false;
        }
        return valido;
    }

    public String configuraAPI() {
        apiUrl = apiUrlBase
                .replace("[base]", this.base)
                .replace("[objetivo]", this.objetivo)
                .replace("[monto]", "" + this.monto);
        return apiUrl;
    }

    public String getUrlApi() {
        return apiUrl;
    }

    public String getBase() {
        return base;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public double getMonto() {
        return monto;
    }
}
