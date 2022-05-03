/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author admin
 */
public class Outils {
    
    public static Date stringToDate(String unedate){
        Date datesortie = null;
        try{
            SimpleDateFormat defFormat = new SimpleDateFormat("dd/MM/yyyy");
            datesortie = defFormat.parse(unedate);
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return datesortie;
    }
    
    public static String dateToString(Date uneDate){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(uneDate);
    }
    
    public static int getAnnee(Date uneDate){
        Calendar c = Calendar.getInstance();
        c.setTime(uneDate);
        return c.get(Calendar.YEAR);
    }
}
