import java.io.*;
import java.io.File; 
import java.io.FileInputStream; 
  import java.util.Scanner; 
  import java.text.ParseException;
import java.text.SimpleDateFormat;
 
 
class onebanc
{
	public static void main(String[] args)throws IOException
	{    
	    String line = "";      
        String splitBy = ",";
        int i=0,j=0;
        String person="Rahul";
        String transaction="INR";
           SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false);
       
       
       Scanner sc=new Scanner(new File("/media/mownika/Study/Interview_Fresher_Any_Language/Interview_Fresher_Any_Language/HDFC-Input-Case1.csv"));
        i=0;
        String[] b=new String[1000];
        sc.useDelimiter(",|\r|\n");  //sets the delimiter pattern  
       while (sc.hasNext())  //returns a boolean value  
       {  
       	
       	b[i] = sc.next();
       	//System.out.print(b[i]);
        //System.out.println("--a"+b[i]+"b--");
        i++;    
        } 

       
     
    FileWriter fileWriter = new FileWriter("/media/mownika/Study/Interview_Fresher_Any_Language/Interview_Fresher_Any_Language/HDFC-Output-Case1.csv");
      fileWriter.write("Date     ");
      fileWriter.append(",");
      fileWriter.append("Transaction Description        ");
      fileWriter.append(",");
      fileWriter.append("Debit,Credit,Currency,CardName,Transaction,Location");
      fileWriter.append("\n");
      System.out.println("FILE HANDLING IN JAVA!!");
      boolean isFoundIDFC=b[11].contains("Amount");
      boolean isFoundAxis=b[4].contains("Debit");
      boolean isFound2 = b[6].contains("Amount");
      boolean isFoundICICI = b[5].contains("Debit");
      if(isFound2)
       {
      for(i=16;i<500;i+=4){
      	boolean isRa;
      	if(b[i]!=null)
             {isRa = b[i+1].contains("Rahul");
           if(isRa)
              person="Rahul";}
         boolean isRitu;
          if(b[i]!=null)
             {isRitu = b[i+1].contains("Ritu");
           if(isRitu)
              person="Ritu";}
            if(b[i]!=null)
            {isRitu = b[i+1].contains("International Transaction");
             if(isRitu)
              transaction="USD";}
      	if(b[i]=="" || b[i+1]=="" ||b[i+2]=="")
      		continue;

      	if(b[i]!=null){

      	         fileWriter.append(b[i]);
      	         fileWriter.append(",");
      	         fileWriter.append(b[i+1]);

      	         fileWriter.append(",");
      	
      	
                String g=b[i+2];
                if(g!=null){
                 boolean isFound = g.contains("cr");
                 if(isFound==true){
             	 fileWriter.append("0");
             	 fileWriter.append(",");
       	         int c=b[i+2].indexOf(' ');
                  String word=b[i+2].substring(0,c);
                   fileWriter.append(word);

                   }
                 else{
                 	fileWriter.append(b[i+2]);
                 	fileWriter.append(",");
                 	fileWriter.append("0");
               	fileWriter.append(",");
                  }
                }
                 fileWriter.append(transaction);
                fileWriter.append(",");
               
                fileWriter.append(person);
                 fileWriter.append(",");
                 if(transaction=="INR")
                 fileWriter.append("Domestic");
                 if(transaction=="USD" || transaction=="EUR")
                 fileWriter.append("International") ; 
                fileWriter.append(",");

               if(b[i+1]!=null){
               	b[i+1].trim();
               	String str[] = b[i+1]. split(" ");
               	String lastWord;
               	//String test =  b[i+1];
                //String lastWord = test.substring(test.lastIndexOf(" ")+1);

                 if(str[(str. length-1)]!=null)
                lastWord=str[(str. length-1)];
            else
            	lastWord=str[(str. length-2)];
            if( transaction=="USD"|| transaction =="EUR")
            	  {  boolean iskata = b[i+1].contains("KATUNAYAKE " );
            	    boolean isber = b[i+1].contains("BERLIN");
            	    boolean iscali= b[i+1].contains("CALIFORNIA");
            	    boolean isnew = b[i+1].contains("NEWYORK");
                   	boolean isDUSSELDOR= b[i+1].contains("DUSSELDOR");
                   	if(iskata)
                   		lastWord="KATUNAYAKE ";
                   	if(isber)
                   		lastWord="BERLIN ";
                   	if(iscali)
                   		lastWord="CALIFORNIA";
                   	if(isnew)
                   		lastWord="NEWYORK ";
                   	if(isDUSSELDOR)
                   		lastWord="DUSSELDOR";

                   }
                fileWriter.append(lastWord);}
                fileWriter.append("\n");
              }
           
           }
          
           }  

           if(isFoundICICI) {
            	for(i=15;i<500;i+=4){
      	               if(b[i]=="Rahul")
                    	person="Rahul";
                    boolean isRitu;
                    if(b[i]!=null)
                      {isRitu = b[i+2].contains("Raj");
                      if(isRitu)
                    	person="Raj";}
                    if(b[i]!=null)
                      {isRitu = b[i+2].contains("International Transaction");
                      if(isRitu)
                    	transaction="USD";}
                      if(b[i]=="" || b[i+1]=="" ||b[i+2]=="")
      		              continue;

            	if(b[i]!=null){

      	         fileWriter.append(b[i]);
      	         fileWriter.append(",");
      	         fileWriter.append(b[i+1]);

      	         fileWriter.append(",");
      	         fileWriter.append(b[i+2]);
      	         fileWriter.append(",");
      	         fileWriter.append(b[i+3]);
      	         fileWriter.append(",");
      	
      	
                if(transaction=="INR")
                 fileWriter.append(transaction);
                if(transaction=="USD" || transaction=="EUR")
                {	
                	boolean isUSD = b[i+1].contains("USD");
                	if(isUSD)
                		transaction="USD";
                	boolean isEUR = b[i+1].contains("EUR");
                	if(isEUR)
                		transaction="EUR";

                 
                  fileWriter.append(transaction);
              }
                fileWriter.append(",");
               
                fileWriter.append(person);
                 fileWriter.append(",");
                 if(transaction=="INR")
                 fileWriter.append("Domestic");
                 if(transaction=="USD" || transaction=="EUR")
                 fileWriter.append("International") ;            
                  fileWriter.append(",");

               if(b[i+1]!=null){
               	b[i+1].trim();
               	String str[] = b[i+1]. split(" ");
               	String lastWord=null;
               	
               	//String test =  b[i+1];
                //String lastWord = test.substring(test.lastIndexOf(" ")+1);
                 if(str[(str. length-1)]!=null)
                    lastWord=str[(str. length-1)];
                 if( transaction=="USD"|| transaction =="EUR")
            	  {  boolean iskata = b[i+1].contains("KATUNAYAKE " );
            	    boolean isber = b[i+1].contains("BERLIN");
            	    boolean iscali= b[i+1].contains("CALIFORNIA");
            	    boolean isnew = b[i+1].contains("NEWYORK");
                   	boolean isDUSSELDOR= b[i+1].contains("DUSSELDOR");
                   	if(iskata)
                   		lastWord="KATUNAYAKE ";
                   	if(isber)
                   		lastWord="BERLIN ";
                   	if(iscali)
                   		lastWord="CALIFORNIA";
                   	if(isnew)
                   		lastWord="NEWYORK ";
                   	if(isDUSSELDOR)
                   		lastWord="DUSSELDOR";

                   }
  
                fileWriter.append(lastWord);
                fileWriter.append("\n");}

              }
          }
           }

           if(isFoundAxis) {
            	for(i=15;i<500;i+=4){
      	               if(b[i]=="Rahul")
                    	person="Rahul";
                    boolean isRitu;
                    if(b[i]!=null)
                      {isRitu = b[i+2].contains("Ritu");
                      if(isRitu)
                    	person="Ritu";}
                    if(b[i]!=null)
                      {isRitu = b[i+2].contains("International Transaction");
                      if(isRitu)
                    	transaction="USD";}
                      if(b[i]=="" || b[i+1]=="" ||b[i+2]=="")
      		              continue;

            	if(b[i]!=null){

      	         fileWriter.append(b[i]);
      	         fileWriter.append(",");
      	         fileWriter.append(b[i+3]);


      	         fileWriter.append(",");
      	          fileWriter.append("   ");
      	         fileWriter.append(b[i+1]);
      	         fileWriter.append(",");
      	         fileWriter.append(b[i+2]);
      	         fileWriter.append(",");
      	
      	
                if(transaction=="INR")
                 fileWriter.append(transaction);
                if(transaction=="USD" || transaction=="EUR")
                {	
                	boolean isUSD = b[i+3].contains("USD");
                	if(isUSD)
                		transaction="USD";
                	boolean isEUR = b[i+3].contains("EUR");
                	if(isEUR)
                		transaction="EUR";

                 
                  fileWriter.append(transaction);
              }
                fileWriter.append(",");
               
                fileWriter.append(person);
                 fileWriter.append(",");
                 if(transaction=="INR")
                 fileWriter.append("Domestic");
                 if(transaction=="USD" || transaction=="EUR")
                 fileWriter.append("International") ;            
                  fileWriter.append(",");

               if(b[i+3]!=null){
               	b[i+1].trim();
               	String str[] = b[i+3]. split(" ");
               	String lastWord=null;
               	
               	//String test =  b[i+1];
                //String lastWord = test.substring(test.lastIndexOf(" ")+1);
                 if(str[(str. length-1)]!=null)
                    lastWord=str[(str. length-1)];
                 if( transaction=="USD"|| transaction =="EUR")
            	  {  boolean iskata = b[i+3].contains("KATUNAYAKE " );
            	    boolean isber = b[i+3].contains("BERLIN");
            	    boolean iscali= b[i+3].contains("CALIFORNIA");
            	    boolean isnew = b[i+3].contains("NEWYORK");
                   	boolean isDUSSELDOR= b[i+3].contains("DUSSELDOR");
                   	if(iskata)
                   		lastWord="KATUNAYAKE ";
                   	if(isber)
                   		lastWord="BERLIN ";
                   	if(iscali)
                   		lastWord="CALIFORNIA";
                   	if(isnew)
                   		lastWord="NEWYORK ";
                   	if(isDUSSELDOR)
                   		lastWord="DUSSELDOR";

                   }
  
                fileWriter.append(lastWord);
                fileWriter.append("\n");}

              }
          }
      }
      if(isFoundIDFC)
       {
      for(i=30;i<500;i+=5){
      	if(b[i]=="Rahul")
                    	person="Rahul";
         boolean isRitu;
          if(b[i]!=null)
             {isRitu = b[i].contains("Rajat");
           if(isRitu)
              person="Rajat";}
            if(b[i]!=null)
            {isRitu = b[i].contains("International Transaction");
             if(isRitu)
              transaction="USD";}
      	if(b[i]=="" || b[i+1]=="" ||b[i+2]=="")
      		continue;

      	if(b[i]!=null){

      	         fileWriter.append(b[i]);
      	         fileWriter.append(",");
      	         fileWriter.append(b[i-1]);

      	         fileWriter.append(",");
      	
      	
                String g=b[i+1];
                if(g!=null){
                 boolean isFound = g.contains("cr");
                 if(isFound==true){
             	 fileWriter.append("0");
             	 fileWriter.append(",");
       	         int c=b[i+1].indexOf(' ');
                  String word=b[i+1].substring(0,c);
                   fileWriter.append(word);

                   }
                 else{
                 	fileWriter.append(b[i+1]);
                 	fileWriter.append(",");
                 	fileWriter.append("0");
               	fileWriter.append(",");
                  }
                }
                 fileWriter.append(transaction);
                fileWriter.append(",");
               
                fileWriter.append(person);
                 fileWriter.append(",");
                 if(transaction=="INR")
                 fileWriter.append("Domestic");
                 if(transaction=="USD" || transaction=="EUR")
                 fileWriter.append("International") ; 
                fileWriter.append(",");

               if(b[i-1]!=null){
               	b[i-1].trim();
               	String str[] = b[i-1]. split(" ");
               	String lastWord;
               	//String test =  b[i+1];
                //String lastWord = test.substring(test.lastIndexOf(" ")+1);

                 if(str[(str. length-1)]!=null)
                lastWord=str[(str. length-1)];
            else
            	lastWord=str[(str. length-2)];
            if( transaction=="USD"|| transaction =="EUR")
            	  {  boolean iskata = b[i-1].contains("KATUNAYAKE " );
            	    boolean isber = b[i-1].contains("BERLIN");
            	    boolean iscali= b[i-1].contains("CALIFORNIA");
            	    boolean isnew = b[i-1].contains("NEWYORK");
                   	boolean isDUSSELDOR= b[i-1].contains("DUSSELDOR");
                   	if(iskata)
                   		lastWord="KATUNAYAKE ";
                   	if(isber)
                   		lastWord="BERLIN ";
                   	if(iscali)
                   		lastWord="CALIFORNIA";
                   	if(isnew)
                   		lastWord="NEWYORK ";
                   	if(isDUSSELDOR)
                   		lastWord="DUSSELDOR";

                   }
                fileWriter.append(lastWord);}
                fileWriter.append("\n");
              }
           
           }
          
           }  
         fileWriter.close();
             }       

        }     
      