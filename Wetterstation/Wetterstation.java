import java.util.concurrent.ThreadLocalRandom; //Ja, die Dopplung war Absicht
import java.util.Random; //Ich weiß auch nicht warum, aber egal

import java.util.*; //Um ganz ehrlich zu sein ist Johannes dafür verantwortlich, dass es noch immer drinnen ist

public class Wetterstation {
  
  // Anfang Attribute
  private double[][] daten = new double[7][24];
  private String[] tage = {"Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag"};
  
  private double[] mon = {10,11,12,13,12,14,15,16,16,16,17,17,18,19,20,22,24,24,26,24,20,16,15,12};  
  private double[] din = {11,11,11,12,12,12,10,10,11,11,11,12,12,12,9,9,9,8,8,8,8,6,8,7};  
  private double[] mit = {8,9,9,9,9,10,10,10,11,11,15,17,20,26,26,29,25,25,25,23,23,23,20,20};  
  private double[] don = {20,15,16,16,16,16,16,17,20,22,24,27,30,32,31,31,30,27,26,20,17,17,15,16};  
  private double[] fre = {15,15,16,14,14,15,16,17,21,21,22,23,23,23,22,22,21,20,20,19,17,17,16,16};  
  private double[] sam = {15,15,15,14,14,15,16,17,18,18,18,19,19,19,19,19,18,18,18,18,17,17,17,17}; 
  private double[] son = {18,18,18,18,18,18,19,20,20,24,24,24,25,25,25,25,23,20,20,20,18,17,17,17};
  // Ende Attribute
  
  // Anfang Methoden
  public void datenDatenDatenMehrDaten() {
    daten[0] = mon; 
    daten[1] = din; 
    daten[2] = mit; 
    daten[3] = don; 
    daten[4] = fre; 
    daten[5] = sam; 
    daten[6] = son;
  }
  
  public void durchschnittsTemperatur() {
    double sumTempWoche = 0.0;
    double avgWoche = 0.0;
    
    double sumTempTag = 0.0;
    double avgTag = 0.0;
    
    //Arrays.stream(daten).flatMap(Arrays::stream).forEach(System.out::println);
    
    for (int i = 0; i < 7; i++) {
      
      for (int j = 0; j < 24; j++) {
        sumTempTag = sumTempTag + daten[i][j];
      }
      
      avgTag = (sumTempTag / 24);
      System.out.println("Durchschnittliche Temperatur für " + tage[i] + " liegt bei " + Double.toString(avgTag));
      
      sumTempWoche = sumTempWoche + avgTag;
    }
    
    avgWoche = (sumTempWoche / 7);
    System.out.println("Durchschnittliche Temperatur für die Woche liegt bei " + Double.toString(avgWoche));
  }
  
  public void highLow() {
    int highD = 0;
    int highH = 0;
    
    int lowD = 0;
    int lowH = 0;
    
    double currentHigh = daten[0][0];
    double currentLow = daten[0][0];
    
    double currentTemp = 0.0;
    
    for (int i = 0; i < 7; i++) {
      
      for (int j = 0; j < 24; j++) {
        currentTemp = daten[i][j];
        
        if(currentTemp > currentHigh) {
          currentHigh = currentTemp;
          
          highD = i;
          highH = j;
        }
        
        if(currentTemp < currentLow) {
          currentLow = currentTemp;
          
          lowD = i;
          lowH = j;
        }
      }   
    }
    
    System.out.println("Die höchste Temperatur der Woche war am " + tage[highD] + " um " + Integer.toString(highH) + ":00 Uhr und betrug " + Double.toString(currentHigh) + "°C.");
    System.out.println("Die tiefste Temperatur der Woche war am " + tage[lowD] + " um " + Integer.toString(lowH) + ":00 Uhr und betrug " + Double.toString(currentLow) + "°C.");
    
  }
  
  public void outData() {
    System.out.println(Arrays.toString(daten));
    
    for (int i = 0; i < 7; i++) {
      for (int j = 0; j < 24; j++) {                                                                                              
        System.out.println("Am " + tage[i] + " um " + Integer.toString(j) + ":00 Uhr betrug die Temperatur " + Double.toString(daten[i][j]) + "°C.");
      }   
    }
  }
  
  public void outDataTime() {  
    for (int i = 0; i < 7; i++) {
      System.out.println("Am " + tage[i] + " um 8:00 Uhr betrug die Temperatur " + Double.toString(daten[i][8]) + "°C.");
      System.out.println("Am " + tage[i] + " um 12:00 Uhr betrug die Temperatur " + Double.toString(daten[i][12]) + "°C.");
      System.out.println("Am " + tage[i] + " um 18:00 Uhr betrug die Temperatur " + Double.toString(daten[i][18]) + "°C.");
    }
  }
  
}

