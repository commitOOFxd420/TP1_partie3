package main;


import java.io.IOException;
import java.util.ArrayList;

public class Main {

	
	public static void main(String[] args) throws IOException{
		
		boolean clientValide = false;
		boolean platValide = false;
		double sousTotalFacture = 0;
		double totalFacture= 0;
		
		
		clientValide = Client.getClients();
		if(clientValide){
			platValide = Plat.getPlats();
		}
		

		
		if(platValide){
			Commande.getCommandes();
			System.out.println("| Bienvenue chez Barette! |\n");
			System.out.println("Facture:\n");
			double total = 0;
			for ( Client client : Client.clientList ) {
				for( Commande commande : client.commandes) {
					total+= commande.total;
				}
				if(total != 0){
					System.out.println(client.nom + " " + total + "$");
			
					sousTotalFacture += total;
					
					total =0;
				}
				
				

			}
			
			double totalTPS = ((sousTotalFacture/100)*5);
			double totalTVQ = ((sousTotalFacture/100)*10);
			totalFacture += ( sousTotalFacture + totalTPS + totalTVQ);
			
			System.out.println("\n---------------------------------");
			System.out.println("Sous-total : " + sousTotalFacture);
			System.out.println("TPS : " + totalTPS);
			System.out.println("TVQ : " + totalTVQ);
			System.out.println("Total : " + totalFacture);
		}
		}
		


}
