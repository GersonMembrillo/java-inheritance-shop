package org.lessions.java.euromediashop;

public class Prodotto {
    private static int instanceCounter = 0;

    private String code;
    private String name;
    private String brand;
    private int price;
    private int VAT;

    public Prodotto(String code, String name, String brand, int price, int VAT) {
        this.code = code;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.VAT = VAT;
        instanceCounter++;
    }

    // Getter codice prodotto
    public String getCode() {
        return code;
    }

    // Getter + Setter nome
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter + Setter marca
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    // Getter + Setter pprezzo
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // Getter + Setter IVA
    public int getVAT() {
        return VAT;
    }

    public void setVAT(int VAT) {
        this.VAT = VAT;
    }

    // Metodo prezzo base
    public int getBasePrice() {
        return price;
    }

    // Metodo prezzo base + iva
    public String getPriceNVAT() {
        double PriceWithVAT = price * (1 + (VAT / 100.0));
        return String.format("%.2f", PriceWithVAT) + " EUR";
    }

    // Metodo per il calcolo del prezzo scontato per clienti con tessera fedeltà
    public double getPrezzoScontato(boolean tesseraFedelta) {
        double prezzoScontato = price;

        if (tesseraFedelta) {
            // Applica uno sconto del 2% a tutti i prodotti
            prezzoScontato -= (price * 0.02);

            // Per gli Smartphone, se la memoria è inferiore a 32GB, applica uno sconto aggiuntivo del 3%
            if (this instanceof Smartphone) {
                Smartphone smartphone = (Smartphone) this;
                if (smartphone.getMemoria() < 32) {
                    prezzoScontato -= (price * 0.03);
                }
            }

            // Per i Televisori, se non sono smart, applica uno sconto aggiuntivo del 8%
            if (this instanceof Televisore) {
                Televisore televisore = (Televisore) this;
                if (!televisore.isSmart()) {
                    prezzoScontato -= (price * 0.08);
                }
            }

            // Per le Cuffie, se sono cablate, applica uno sconto aggiuntivo del 5%
            if (this instanceof Cuffie) {
                Cuffie cuffie = (Cuffie) this;
                if (!cuffie.isWireless()) {
                    prezzoScontato -= (price * 0.05);
                }
            }
        }

        return prezzoScontato;
    }

    // Metodo tot prodotti
    public static int getInstanceCount() {
        return instanceCounter;
    }
}
