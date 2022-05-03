/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import metier.*;

/**
 *
 * @author admin
 */
public class Gestion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Banque uneBanque= new Banque("MaBanque");
        Service gestion= new Service("administratif",500);
        Service commercial= new Service("commercial", 600);
        java.util.Date date1=new Date("07/10/2016");
        java.util.Date date2=new Date("01/03/2013");
        java.util.Date date3=new Date("04/12/2018");
        Administratif administratif1=new Administratif("Lozere","Alain",2000,date2,gestion,"Comptable");
        Administratif administratif2=new Administratif("Gros","Laurent",1800,date1,gestion,"Juriste");
        Commercial commercial1=new Commercial("Blanc","Alice",1500,date1,commercial,3);
        Commercial commercial2=new Commercial("Deschamps","Didier",1700,date3,commercial,2);
        Collections.addAll(uneBanque.getLesAdministratifs(), administratif1,administratif2);
        Collections.addAll(uneBanque.getLesCommerciaux(),commercial1,commercial2);
        Client client1=new Client("Auchon","Paul");
        Client client2=new Client("Lebon","Gustave");
        Client client3=new Client("Cesar","Jules");
        Client client4=new Client("Lave","Maurice");
        Client client5=new Client("Pave","Stephane");
        Client client6=new Client("Lewandovski","Bastian");
        Collections.addAll(commercial1.getLesClients(), client1,client2,client3);
        Collections.addAll(commercial2.getLesClients(), client4, client5, client6);
        
        CompteEpargne unCompteEpargne=new CompteEpargne("55555",5500,date1,0.5);
        CompteCourant unCompteCourant=new CompteCourant("123456",5000, 200);
        client1.ajouterCompteCourant(unCompteCourant);
        client1.ajouterCompteEpargne(unCompteEpargne);
        
        CompteEpargne unCompteEpargne1=new CompteEpargne("99999",8300,date1,0.1);
        CompteCourant unCompteCourant1=new CompteCourant("123457",3000, 150);
        client2.ajouterCompteCourant(unCompteCourant1);
        client2.ajouterCompteEpargne(unCompteEpargne1);
        
        CompteCourant unCompteCourant2=new CompteCourant("123458",4000, 300);
        client3.ajouterCompteCourant(unCompteCourant2);
        
        CompteEpargne unCompteEpargne2=new CompteEpargne("898989",6100,date1,0.2);
        CompteCourant unCompteCourant3=new CompteCourant("123459",5000, 250);
        CompteCourant unCompteCourant4=new CompteCourant("123459",1000, 50);
        Collections.addAll(client4.getLesCompteCourant(),unCompteCourant3,unCompteCourant4);
        client4.ajouterCompteEpargne(unCompteEpargne2);
        
        CompteEpargne unCompteEpargne4=new CompteEpargne("44444",2000,date1,0.2);
        CompteCourant unCompteCourant6=new CompteCourant("568888",8500, 500);
        client5.ajouterCompteCourant(unCompteCourant6);
        client5.ajouterCompteEpargne(unCompteEpargne4);
        
        CompteEpargne unCompteEpargne5=new CompteEpargne("332211",8800,date1,0.1);
        CompteCourant unCompteCourant7=new CompteCourant("568866",3500, 300);
        client6.ajouterCompteCourant(unCompteCourant7);
        client6.ajouterCompteEpargne(unCompteEpargne5);
        
        int choix = menu();
        while (choix != 0) {
            switch (choix) {
                case 1:
                    SalairesCommerciaux(uneBanque);
                    break;
                case 2:
                    SalairesAdministratifs(uneBanque);
                    break;
                case 3:
                    SalaireAdministratif(uneBanque);
                    break;
                case 4:
                    SalaireCommercial(uneBanque);
                    break;
                case 5:
                    PatrimoinesClients(uneBanque);
                    break;
                case 6:
                    PatrimoineClient(uneBanque);
                    break;
                case 7:
                    Patrimoinebanque(uneBanque);
                    break;
            }
            choix = menu();
        }
        
    }
    
    private static int menu() {
        System.out.println("Menu général");
        System.out.println();
        System.out.println("1..Afficher le salaire de chaque commercial");
        System.out.println("2..Afficher le salaire de chaque administratif");
        System.out.println("3..Afficher le salaire d'un administratif");
        System.out.println("4..Afficher le salaire d'un commercial");
        System.out.println("5..Afficher le patrimoine de chaque client");
        System.out.println("6..Afficher le patrimoine d'un client");
        System.out.println("7..Afficher le patrimoine de la banque");
        System.out.println("0..Quitter");
        Scanner sc = new Scanner(System.in);
        System.out.println("Votre choix : ");
        int choix = sc.nextInt();
        return choix;
    }
    
    private static void SalairesCommerciaux(Banque uneBanque){
        for(int i=0; i<uneBanque.getLesCommerciaux().size();i++){
            Commercial unCommercial=uneBanque.getLesCommerciaux().get(i);
            
            System.out.println(unCommercial.getPrenom()+ " " + unCommercial.getNom() + " : " + unCommercial.calculerSalaire());
        }
    }
    private static void SalairesAdministratifs(Banque uneBanque){
        for(int i=0; i<uneBanque.getLesAdministratifs().size();i++){
            Administratif unAdministratif=uneBanque.getLesAdministratifs().get(i);
            
            System.out.println(unAdministratif.getPrenom()+" "+unAdministratif.getNom()+" : "+unAdministratif.calculerSalaire());
        }
    }
    private static void SalaireAdministratif(Banque uneBanque){
        String Nom;
        Scanner clavier = new Scanner(System.in);
        System.out.println("Nom de l'employé : ");
        Nom = clavier.nextLine();
        for(int i=0; i<uneBanque.getLesAdministratifs().size();i++){
            Administratif unAdministratif = uneBanque.getLesAdministratifs().get(i);
            if( unAdministratif.getNom().equals(Nom))
                System.out.println("Salaire : " + unAdministratif.calculerSalaire());
        }
    }
    private static void SalaireCommercial(Banque uneBanque){
        String Nom;
        Scanner clavier = new Scanner(System.in);
        System.out.println("Nom de l'employé : ");
        Nom = clavier.nextLine();
        for(int i=0; i<uneBanque.getLesCommerciaux().size();i++){
            Commercial unCommercial=uneBanque.getLesCommerciaux().get(i);
            if(unCommercial.getNom().equals(Nom))
                System.out.println("Salaire : " + unCommercial.calculerSalaire());
        }
    }
    private static void PatrimoinesClients(Banque uneBanque){
         for(int i=0; i<uneBanque.getLesCommerciaux().size();i++){
            Commercial unCommercial=uneBanque.getLesCommerciaux().get(i);
            for(int x=0; x<unCommercial.getLesClients().size();x++){
                Client unClient=unCommercial.getLesClients().get(x);
                System.out.println(unClient.getPrenom()+" "+unClient.getNom()+" . Patrimoine : "+unClient.calculerPatrimoine());
            }
        }
    }
    private static void PatrimoineClient(Banque uneBanque){
        String Nom;
        Scanner clavier = new Scanner(System.in);
        System.out.println("Nom du client :");
        Nom = clavier.nextLine();
        for(int i=0; i<uneBanque.getLesCommerciaux().size(); i++){
            Commercial unCommercial=uneBanque.getLesCommerciaux().get(i);
            for(int z=0; z<unCommercial.getLesClients().size(); z++){
                Client unClient=unCommercial.getLesClients().get(i);
                if(unClient.getNom().equals(Nom))
                    System.out.println("Patrimoine de " + Nom + " : " + unClient.calculerPatrimoine() );
                    break;
                }
            }
    }
    private static void Patrimoinebanque(Banque uneBanque){
        double Patrimoine;
        Patrimoine=uneBanque.calculerCA();
        System.out.println("Patrimoine de la banque : " + Patrimoine);
    }
         
}
        
        
        
        
        
        
        
        
        
        
        
        
    
    

