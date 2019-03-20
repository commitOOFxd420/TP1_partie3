package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Plat {

	public double prix;
	public String nom;
	
	public static ArrayList<Plat> listePlats = new ArrayList<Plat>();
	
	public Plat(String nom, double prix){
		this.nom = nom;
		this.prix = prix;
	}
	
	public Plat(){
		
	}
	
	public static boolean getPlats()throws FileNotFoundException, IOException{
		boolean plats = false;
		boolean valide = true;
		String file = "src/commandes.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(file))){
			String line;
			while(!(line = br.readLine()).equals("Commandes :")){
				
				if(line.equals("Plats :")){
					plats = true;
				}
				
				if(plats && !(line.equals("Plats :"))){
					if(line.contains(" ")){
						String[] ligne = line.split(" ");
						if(ligne.length == 2){
							if(ligne[0].matches("^[a-zA-Z0-9!@#$&()-`.+,/\"]*$")){
								
								if(ligne[1].matches("\\d+.\\d+")){
									listePlats.add(new Plat(ligne[0], Double.parseDouble(ligne[1])));

								} else {
									System.out.println("Prix invalide : " + line);
									valide = false;
									break;
								}
							}
							
						} else {
							System.out.println("Nom plat invalide : " + line);
							valide = false;
							break;
						}
						} else {
							System.out.println("Longueur du plat invalide : " + line);
							valide = false;
							break;
						}
						
					
				}
				
				
				
			}
		}
		
		return valide;
	}
	
	public static ArrayList<Plat> getListePlat(){
		return listePlats;
	}

}
