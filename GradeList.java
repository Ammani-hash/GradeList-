import java.util.*;
import java.io.*;

public class GradeList {
    private List<Double> grades;

    public GradeList() {
        grades = new ArrayList<>();
    }

    public void readGrades(String fileName) {
      try {   
          //read data in from fileName
          Scanner file = new Scanner(new File(fileName));
          
          //reads files in a token based way.
          //If there is a double to read in, then read it in
          while (file.hasNextDouble()) {
            grades.add(file.nextDouble());    
          }
      } catch(FileNotFoundException e) {
         System.out.println(fileName + " does not exist because file cannot be read.");
      }    
    }

    public double calcAverage() {
        if(grades.size() == 0) {
         return 0.0;
        }
        
        int total = 0;
        
        for (double grade : grades){
         total += grade;
        }
        
        return (double) total / grades.size();
    }

    public double dropLowest() {
       if (grades.size() == 0) {
         return Double.MAX_VALUE;
       }
       
       double lowest = Integer.MAX_VALUE;
       double lowestIndex = 0;
       for (int i = 0; i < grades.size(); i++){
         if (grades.get(i) < lowest) {
            lowest = grades.get(i);
            lowestIndex = i;
         }
       }
       
       grades.remove(lowestIndex);
       return lowest;
    }

    public void addGrade(double grade) {
      grades.add(grade);
    }

    public boolean removeAllGrades(double grade) {
        //Uses removeIf() method to remove elements that match the grade that is passed. Had to look this up
        boolean found = grades.removeIf(a -> a == grade);
        return found;
    }

    public void printSortedGrades() {
      //Collections.sort sorts the value in the parameter
      Collections.sort(grades);
      System.out.println(grades);
    }

    public String toString() {
        return grades.toString();
    }

}
