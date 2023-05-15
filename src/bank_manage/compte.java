package bank_manage;
import java.util.ArrayList;
import java.util.Date;

public class compte {
    private int id;
    private String numero;
    private double solde;
    private client proprietaire;
    private ArrayList<operation> operations;

    public compte(int id, String numero, client proprietaire) {
        this.id = id;
        this.numero = numero;
        this.solde = 0;
        this.proprietaire = proprietaire;
        this.operations = new ArrayList<operation>();
    }

    public int getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public double getSolde() {
        return solde;
    }

    public client getProprietaire() {
        return proprietaire;
    }

    public ArrayList<operation> getoperations() {
        return operations;
    }

    public void ajouteroperation(operation operation) {
        operations.add(operation);
        if (operation.getType().equals("versement")) {
            solde += operation.getMontant();
        } else if (operation.getType().equals("retrait")) {
            solde -= operation.getMontant();
        }
    }

    public void afficherDetails() {
        System.out.println("compte " + numero + " de " + proprietaire.getPrenom() + " " + proprietaire.getNom());
        System.out.println("Solde: " + solde);
        System.out.println("Liste des opérations:");
        for (operation operation : operations) {
            System.out.println(operation.getDate() + " - " + operation.getType() + " de " + operation.getMontant());
        }
    }
}
