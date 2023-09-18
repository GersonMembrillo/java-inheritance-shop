package org.lessions.java.euromediashop;

public class Smartphone extends Prodotto {
    private String IMEI;
    private int memoria;

    public Smartphone(String code, String name, String brand, int price, int VAT, String IMEI, int memoria) {
        super(code, name, brand, price, VAT);
        this.IMEI = IMEI;
        this.memoria = memoria;
    }

    public String getIMEI() {
        return IMEI;
    }

    public int getMemoria() {
        return memoria;
    }

    @Override
    public String toString() {
        return "Smartphone [Codice=" + getCode() + ", Nome=" + getName() + ", Marca=" + getBrand() + ", Prezzo=" + getPrice() + ", IVA=" + getVAT() + ", IMEI=" + IMEI + ", Memoria=" + memoria + "]";
    }
}

