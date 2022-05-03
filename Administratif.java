/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author admin
 */
public class Administratif extends Employe {
    private String fonction;
    
    private String getFonction(){
        return fonction;
    }
    private void setFonction(String uneFonction){
        this.fonction=uneFonction;
    }
    
    
    public Administratif(String nom, String prenom, double salaire, Date date, Service service, String fonction){
        super(nom, prenom, salaire, date, service);
        setFonction(fonction);
    }
    
    public double calculerSalaire(){
        double salaire;
        salaire=getSalaireBase()+getService().getPrime();
        return salaire;
    }
    
    @Override
    public int anciennete(){
         int anciennete=0;
        SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        Date dateObj = calendar.getTime();
        String formattedDate = dtf.format(dateObj);
        int year1 = getDateembauche().getYear();
        int year2 =dateObj.getYear();
        anciennete=year2-year1;
        return anciennete;
    }
    
    
}
