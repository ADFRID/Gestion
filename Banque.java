/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Banque {
    private String raisonSociale;
    private List<Administratif>lesAdministratifs;
    private List<Commercial>lesCommerciaux;
    
    private void setRaisonSocial(String r){
        this.raisonSociale=r;
    }
    private String getRaisonSocial(){
        return this.raisonSociale;
    }
    private void setLesAdministratifs(List<Administratif>lesAdministratifs){
        if(lesAdministratifs==null)
            this.lesAdministratifs= new ArrayList<Administratif>();
        else
            this.lesAdministratifs=lesAdministratifs;
    }
    public List<Administratif> getLesAdministratifs(){
        return this.lesAdministratifs;
    }
    
    private void setLesCommerciaux(List<Commercial>lesCommerciaux){
        if(lesCommerciaux==null)
            this.lesCommerciaux=new ArrayList<Commercial>();
        else
            this.lesCommerciaux=lesCommerciaux;
        }
    public List<Commercial> getLesCommerciaux(){
        return this.lesCommerciaux;
    }
    
    public Banque(String raisonS){
        setRaisonSocial(raisonS);
        setLesAdministratifs(lesAdministratifs);
        setLesCommerciaux(lesCommerciaux);
    }
    public double calculerCA(){
        double CA=0;
        for(int i=0;i<lesCommerciaux.size();i++){
            Commercial unCommercial=lesCommerciaux.get(i);
            for(int p=0;p<unCommercial.getLesClients().size();p++){
                Client unClient=unCommercial.getLesClients().get(p);
                for(int z=0;z<unClient.getLesCompteCourant().size();z++){
                    CompteCourant unCompteCourant=unClient.getLesCompteCourant().get(z);
                    CA=CA+unCompteCourant.getSolde();
                    for(int c=0;c<unClient.getLesCompteEpargne().size();c++){
                        CompteEpargne unCompteEpargne=unClient.getLesCompteEpargne().get(c);
                        CA=CA+unCompteEpargne.getSolde();
                    }
                }
            }
        }
        return CA;
    }
    
    public void ajouterAdmin(Administratif unAdministratif){
        lesAdministratifs.add(unAdministratif);
    }
    public void ajouterCommercial(Commercial unCommercial){
        lesCommerciaux.add(unCommercial);
    }
}

