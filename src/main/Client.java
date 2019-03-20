package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Client {

	public String nom;
	public static ArrayList<Client> clientList = new ArrayList<Client>();
	public ArrayList<Commande> commandes = new ArrayList<Commande>();
	public Client(String nom){
		this.nom = nom;
	}
	
	public Client(){
		
	}
	
	public static boolean getClients() throws FileNotFoundException, IOException{
		boolean valide = true;
		String file = "src/commandes.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String line;
			
			while(!(line = br.readLine()).equals("Plats :")){
				
					if(!line.equals("Clients :")){
						if(line.matches("^[a-zA-Z]+$")){
							clientList.add(new Client(line));
							
						} else {
							System.out.println("Format client invalide : " + line);
							valide = false;
							break;
						}
						
					}
				
				
			}
		}
		
		return valide;
	}
	
	public static ArrayList<Client> getListeClient(){
		return clientList;
	}
}
