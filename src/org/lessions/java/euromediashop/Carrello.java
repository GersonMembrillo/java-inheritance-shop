package org.lessions.java.euromediashop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Carrello {
    private List<Prodotto> carrello = new ArrayList<>(); 

    public void aggiungiSmartphone(Scanner sc) {
        System.out.print("Inserisci il codice: ");
        String code = sc.next();
        sc.nextLine();

        System.out.print("Inserisci il nome: ");
        String name = sc.nextLine(); 

        System.out.print("Inserisci la marca: ");
        String brand = sc.nextLine();

        System.out.print("Inserisci il prezzo: ");
        int price = sc.nextInt();

        System.out.print("Inserisci l'IVA: ");
        int VAT = sc.nextInt();

        System.out.print("Inserisci l'IMEI: ");
        String IMEI = sc.next();

        System.out.print("Inserisci la memoria: ");
        int memoria = sc.nextInt();

        Smartphone smartphone = new Smartphone(code, name, brand, price, VAT, IMEI, memoria);
        carrello.add(smartphone);
    }

    public void aggiungiTelevisore(Scanner sc) {
        System.out.print("Inserisci il codice: ");
        String code = sc.next();
        sc.nextLine();

        System.out.print("Inserisci il nome: ");
        String name = sc.nextLine(); 

        System.out.print("Inserisci la marca: ");
        String brand = sc.nextLine();

        System.out.print("Inserisci il prezzo: ");
        int price = sc.nextInt();

        System.out.print("Inserisci l'IVA: ");
        int VAT = sc.nextInt();

        System.out.print("Inserisci le dimensioni: ");
        String dimensioni = sc.next();

        System.out.print("L'articolo è Smart? (si/no): ");
        boolean isSmart = sc.next().equalsIgnoreCase("si");

        Televisore televisore = new Televisore(code, name, brand, price, VAT, dimensioni, isSmart);
        carrello.add(televisore);
    }

    public void aggiungiCuffie(Scanner sc) {
        System.out.print("Inserisci il codice: ");
        String code = sc.next();
        sc.nextLine();

        System.out.print("Inserisci il nome: ");
        String name = sc.nextLine();

        System.out.print("Inserisci la marca: ");
        String brand = sc.nextLine();

        System.out.print("Inserisci il prezzo: ");
        int price = sc.nextInt();

        System.out.print("Inserisci l'IVA: ");
        int VAT = sc.nextInt();

        System.out.print("Inserisci il colore: "); 
        String colore = sc.next();

        System.out.print("Le cuffie sono wireless? (si/no): ");
        boolean isWireless = sc.next().equalsIgnoreCase("si");

        Cuffie cuffie = new Cuffie(code, name, brand, price, VAT, colore, isWireless);
        carrello.add(cuffie);
    }

    public int getTotale(boolean tesseraFedelta) {
        int totale = 0;
        for (Prodotto prodotto : carrello) {
            double prezzoScontato = tesseraFedelta ? prodotto.getPrezzoScontato(tesseraFedelta) : prodotto.getPrice();
            totale += (int) Math.round(prezzoScontato); 
            totale += (int) Math.round(prezzoScontato * prodotto.getVAT() / 100); 
        }
        return totale;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Carrello:\n");
        for (Prodotto prodotto : carrello) {
            result.append(prodotto.toString()).append("\n");
        }
        result.append("Totale (IVA inclusa): ").append(getTotale(false)).append(" EUR");
        return result.toString();
    }

    public static void main(String[] args) {
        Carrello carrello = new Carrello();
        Scanner sc = new Scanner(System.in);

        System.out.print("Hai una carta fedeltà? (si/no): ");
        boolean tesseraFedelta = sc.next().equalsIgnoreCase("si");

        while (true) {
            System.out.println("Cosa vuoi aggiungere al carrello? (Smartphone/Televisore/Cuffie/esci)");
            String scelta = sc.next();

            if (scelta.equalsIgnoreCase("esci")) {
                break;
            } else if (scelta.equalsIgnoreCase("Smartphone")) {
                carrello.aggiungiSmartphone(sc);
            } else if (scelta.equalsIgnoreCase("Televisore")) {
                carrello.aggiungiTelevisore(sc);
            } else if (scelta.equalsIgnoreCase("Cuffie")) {
                carrello.aggiungiCuffie(sc);
            } else {
                System.out.println("Scelta non valida. Riprova.");
            }
        }

        sc.close();

        System.out.println(carrello.toString());
        System.out.println("Totale (IVA inclusa): " + carrello.getTotale(tesseraFedelta) + " EUR");
    }
}
