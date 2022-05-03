/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author admin
 */
public abstract class Employe {
    private String nom,prenom;
    private double salaireBase;
    private Date dateembauche;
    private Service service;
    
    public String getNom(){
        return nom;
    }
    protected void setNom(String nom){
        this.nom=nom;
    }
    public String getPrenom(){
        return prenom;
    }
    protected void setPrenom(String prenom){
        this.prenom=prenom;
    }
    protected double getSalaireBase(){
        return salaireBase;
    }
    protected void setSalaireBase(double salaire){
        this.salaireBase=salaire;
    }
    
    public Service getService(){
        return service;
    }
    protected void setService(Service unService){
        this.service=unService;
    }
    
    protected Date getDateembauche(){
        return dateembauche;
    }
    protected void setDateembauche(Date date){
        this.dateembauche=date;
    }
    
    public Employe(String nom, String prenom, double salaire, Date unedate, Service service){
        setNom(nom);
        setPrenom(prenom);
        setSalaireBase(salaire);
        setDateembauche(unedate);
        setService(service);
    }
    public abstract double calculerSalaire();
    
    public int anciennete(){
        int anciennete=0;
        SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        Date dateObj = calendar.getTime();
        String formattedDate = dtf.format(dateObj);
        int year1 = dateembauche.getYear();
        int year2 =dateObj.getYear();
        anciennete=year2-year1;
        return anciennete;
    }
        
}
