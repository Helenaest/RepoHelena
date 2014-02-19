/*
 * Autores: 
 * Lidia García de la Fuente
 * Helena Esteban Illescas
 * Raúl Fernández Forcada
 */
package pcfutbol;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


public class Calendario implements Serializable{
    protected Partido[][] partidos;
    
    public Calendario(){
        partidos=new Partido[50][];
    }
    // Helena Prueba de cambio
    
    public void generarCalendarioCopa(Partido[] p,int num_e){
        int n=(int)(Math.log10(num_e)/Math.log10(2)); //num jornadas
        this.partidos=new Partido[n][num_e/2];//creamos la matriz 
        int contadorJor=0;//contador jornadas
        int cont=-1;
        int y=this.partidos[0].length;
            for (int i=0;i<p.length;i++){
               partidos[contadorJor][i]=p[i];
            }

            while(num_e>2){
                ArrayList <Equipo> equiposGanadores=new ArrayList <Equipo>();
                cont++;
                for (int h=0; h<(y); h++){
                     Equipo ganador=partidos[cont][h].Jugar();
                     equiposGanadores.add(ganador);
                } 
                contadorJor++;
                Partido[]p2=GenerarPartidos(equiposGanadores);
                num_e=num_e/2;
                y=p2.length;
                System.arraycopy(p2, 0, partidos[contadorJor], 0, y);                
         }
       
    }

    public Partido[] GenerarPartidos(ArrayList <Equipo> eqs){
        
        int num_e=eqs.size();
        int n=(int)(Math.log10(num_e)/Math.log10(2)); //num jornadas
        Partido [] partidosj=new Partido[num_e/2];//
        Random randomGenerator = new Random();
        int contadorPJor=0; 
        while (!eqs.isEmpty()){
            int cont=eqs.size();
            int randomInt = randomGenerator.nextInt(cont);
            Equipo e1 =(Equipo)eqs.get(randomInt);
            eqs.remove(e1);
            cont=eqs.size();
            int randomInt2 = randomGenerator.nextInt(cont);
            Equipo e2=(Equipo)eqs.get(randomInt2);
            eqs.remove(e2);
            Date fecha=new Date();         
            partidosj[contadorPJor]=new Partido(e1,e2,fecha,"copa");
            contadorPJor++;
    
        }
        
        return partidosj;
    }
  
    
}
