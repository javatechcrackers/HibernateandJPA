package org.ReadCSVFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;

public class ReadCSVFile extends WriteXMLFile {

  public static void main(String[] args) {
	  
    try { 
    	
      String csvFile = "C:\\Users\\Prashant K\\Documents\\book.csv";

      //create BufferedReader to read csv file
      BufferedReader br = new BufferedReader(new FileReader(csvFile));
      String line = "";
      String delims = ",";
      StringTokenizer st = null;

      int lineNumber = 0; 
      int tokenNumber = 0;

      //read comma separated file line by line
      while ((line = br.readLine()) != null) {
    	  break;
    	  //lineNumber++;
      }
        //use comma as token separator
        st = new StringTokenizer(line, ",");
        ArrayList<String> list= new ArrayList<String>();
      
        while (st.hasMoreTokens()) {
          tokenNumber++;
       
          //display csv values
          System.out.print(st.nextToken() + "  ");
         
        }
     //   list.add(st.nextToken());
        String[] tokens = line.split(delims);
		int tokenCount = tokens.length;
		for (int j = 0; j < tokenCount; j++) {
			list.add(tokens[j]);
			System.out.println("Split Output: "+ tokens[j]);
		}
        
        System.out.println(list.toString());
        writefile(list);
        //reset token number
        tokenNumber = 0;
     
    } catch (Exception e) {
      System.err.println("CSV file cannot be read : " + e);
    }
  }

}

