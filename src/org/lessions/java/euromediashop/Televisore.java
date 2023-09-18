package org.lessions.java.euromediashop;

public class Televisore extends Prodotto {
    private String dimensioni;
    private boolean isSmart;

    public Televisore(String code, String name, String brand, int price, int VAT, String dimensioni, boolean isSmart) {
        super(code, name, brand, price, VAT);
        this.dimensioni = dimensioni;
        this.isSmart = isSmart;
    }

    public String getDimensioni() {
        return dimensioni;
    }

    public boolean isSmart() {
        return isSmart;
    }

    @Override
    public String toString() {
        return "Televisore [Codice=" + getCode() + ", Nome=" + getName() + ", Marca=" + getBrand() + ", Prezzo=" + getPrice() + ", IVA=" + getVAT() + ", Dimensioni=" + dimensioni + ", Smart=" + (isSmart ? "Si" : "No") + "]";
    }
}
