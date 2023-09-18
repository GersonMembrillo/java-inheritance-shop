package org.lessions.java.euromediashop;

public class Cuffie extends Prodotto {
    private String colore;
    private boolean isWireless;

    public Cuffie(String code, String name, String brand, int price, int VAT, String colore, boolean isWireless) {
        super(code, name, brand, price, VAT);
        this.colore = colore;
        this.isWireless = isWireless;
    }

    public String getColore() {
        return colore;
    }

    public boolean isWireless() {
        return isWireless;
    }

    @Override
    public String toString() {
        return "Cuffie [Codice=" + getCode() + ", Nome=" + getName() + ", Marca=" + getBrand() + ", Prezzo=" + getPrice() + ", IVA=" + getVAT() + ", Colore=" + colore + ", Wireless=" + (isWireless ? "Si" : "No") + "]";
    }
}
