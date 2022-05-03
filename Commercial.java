/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public class Commercial extends Employe {
    private double tauxComission;
    private List<Client> lesClients;
    
    private void setTauxComission(double taux){
        this.tauxComission=taux;
    }
    public double getTauxComission(){
        return tauxComission;
    }
    
    private void setLesClients(List<Client>lesClients){
        if(lesClients==null)
            this.lesClients= new ArrayList<Client>();
        else
            this.lesClients=lesClients;
    }
    
    public List<Client> getLesClients(){
        return this.lesClients;
    }
    
    public Commercial(String nom, String prenom, double salaire, Date unedate, Service unService, double taux){
        super(nom, prenom, salaire, unedate, unService);
        setTauxComission(taux);
        setLesClients(lesClients);
    }
    @Override
    public double calculerSalaire(){
        
        double salaire;
        salaire=super.getSalaireBase()+ super.getService().getPrime() +calculerComission();
        return salaire;
    }
    public double calculerComission(){
        double comission=0, Patrimoine=0;
        for(int p=0;p<getLesClients().size();p++){
                Client unClient=getLesClients().get(p);
                Patrimoine=unClient.calculerPatrimoine();
                comission=comission+Patrimoine;
        }
        comission=(comission*tauxComission)/100;
        return comission;
    }
    
    public void ajouterClient(Client unClient){
        lesClients.add(unClient);
    }
}
