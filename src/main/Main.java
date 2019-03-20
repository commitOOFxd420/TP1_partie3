package main;


import java.io.IOException;

public class Main {

	
	public static void main(String[] args) throws IOException{
		
		Client.getClients();
		Plat.getPlats();
		Commande.getCommandes();

		System.out.println("Bienvenue chez Barette!");
		System.out.println("Facture:");
		double total = 0;
		for ( Client client : Client.clientList ) {
			for( Commande commande : client.commandes) {
				total+= commande.total;
			}
			System.out.println(client.nom + " " + total + "$");
			total =0;
		}
	}
}
