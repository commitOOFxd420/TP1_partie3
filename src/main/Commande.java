package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Commande {

	public Client client;
	public Plat plat;
	public double total;
	static ArrayList<Commande> listeCommandes = new ArrayList<Commande>();

	public Commande(Client client, Plat plat, int amount) {

		this.client = client;
		this.plat = plat;
		this.total = plat.prix * amount;
	}

	public static void getCommandes() throws FileNotFoundException, IOException {
		String file = "src/commandes.txt";
		Client clientActu = new Client();
		Plat plat = new Plat();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			boolean commande = false;
			while (!(line = br.readLine()).equals("Fin")) {
				boolean clientValide = false, platValide = false;
				if (line.contains(" ")) {

					if (line.equals("Commandes :")) {
						commande = true;
					}
					if (commande && !(line.equals("Commandes :"))) {
						String[] ligne = line.split(" ");

						if (ligne.length == 3) {

							if (ligne[2].matches("\\d+")) {

								for (Client clientTemp : Client.getListeClient()) {
									if (clientTemp.nom.equals(ligne[0])) {
										clientActu = clientTemp;
										clientValide = true;
									}
								}
								
								if(!clientValide){
									System.out.println("Client invalide : " + line);
								}

								for (Plat platActu : Plat.getListePlat()) {

									if (platActu.nom.equals(ligne[1])) {
										plat = platActu;
										platValide = true;
									}
								}

								if (!platValide) {
									System.out.println("Plat invalide : " + line);
								}

								if (platValide && clientValide) {
									clientActu.commandes
											.add(new Commande(clientActu, plat, Integer.parseInt(ligne[2])));
								}

							} else {
								System.out.println("Nombre de plat invalide : " + line);
							}
						} else {
							System.out.println("Information manquante :" + line);
						}
					}

				}
			}
		}
	}

	public double getTotal(String nom) {
		Client client = new Client();
		double total = 0;
		for (Client clientActu : Client.getListeClient()) {

			if (clientActu.nom.equals(nom)) {
				client = clientActu;
			}
		}
		System.out.println("TEST");
		for (Commande commande : client.commandes) {

			total += commande.total;

		}

		return total;

	}

}
