package bank_manage;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<client> clients = new ArrayList<client>();
        ArrayList<compte> comptes = new ArrayList<compte>();

        while (true) {
            System.out.println("Que voulez-vous faire ?");
            System.out.println("1. Créer un compte et l'associer à un client");
            System.out.println("2. Réaliser des opérations sur un compte");
            System.out.println("3. Afficher le détail d'un compte");
            System.out.println("4. Quitter");
            int choix = scanner.nextInt();
            scanner.nextLine();

            if (choix == 1) {
                System.out.println("Création d'un compte :");
                System.out.println("Entrez l'id du client (il faut etre un entier ):");
                int clientId = scanner.nextInt();
                scanner.nextLine();
                client proprietaire = null;
                for (client client : clients) {
                    if (client.getId() == clientId) {
                        proprietaire = client;
                        break;
                    }
                }
                if (proprietaire == null) {
                    System.out.println("client introuvable.");
                    continue;
                }
                System.out.println("Entrez le numéro du compte :");
                String numero = scanner.nextLine();
                compte compte = new compte(comptes.size() + 1, numero, proprietaire);
                comptes.add(compte);
                System.out.println("compte créé avec succès.");
            } else if (choix == 2) {
                System.out.println("Entrez l'id du compte :");
                int compteId = scanner.nextInt();
                scanner.nextLine();
                compte compte = null;
                for (compte c : comptes) {
                    if (c.getId() == compteId) {
                        compte = c;
                        break;
                    }
                }
                if (compte == null) {
                    System.out.println("compte introuvable.");
                    continue;
                }
                System.out.println("Que voulez-vous faire ?");
                System.out.println("1. Effectuer un versement");
                System.out.println("2. Effectuer un retrait");
                int choix2 = scanner.nextInt();
                scanner.nextLine();
                if (choix2 == 1) {
                    System.out.println("Entrez le montant du versement :");
                    double montant = scanner.nextDouble();
                    scanner.nextLine();
                    operation operation = new operation(new Date(), "versement", montant);
                    compte.ajouteroperation(operation);
                    System.out.println("Versement effectué avec succès.");
                } else if (choix2 == 2) {
                    System.out.println("Entrez le montant du retrait :");
                    double montant = scanner.nextDouble();
                    scanner.nextLine();
                    if (montant > compte.getSolde()) {
                        System.out.println("Solde insuffisant.");
                        continue;
                    }
                    operation operation = new operation(new Date(), "retrait", montant);
                    compte.ajouteroperation(operation);
                    System.out.println("Retrait effectué avec succès.");
                }
            } else if (choix == 3) {
                System.out.println("Entrez l'id du compte :");
                int compteId = scanner.nextInt();
                scanner.nextLine();
                compte compte = null;
                for (compte c : comptes) {
                    if (c.getId() == compteId) {
                        compte = c;
                        break;
                    }
                }
                if (compte == null) {
                    System.out.println("compte introuvable.");
                    continue;
                }
                compte.afficherDetails();
            } else if (choix == 4) {
                System.out.println("Au revoir !");
                break;
            }
        }
    }
}
