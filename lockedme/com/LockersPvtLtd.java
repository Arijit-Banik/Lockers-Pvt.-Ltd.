package lockedme.com;

import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LockersPvtLtd {
	
	public static void main(String[] args) throws IOException {
	
		//Welcome Screen
		
		 Scanner sc = new Scanner(System.in);
		 int selection;
		 boolean exit = false;
		 while (!exit) 
		 {
		 System.out.println("\n\t Welcome to LockedMe.com");
		 System.out.println("\t Developed by : Arijit Banik");
		 
		 System.out.println("\nMenu : ");
		 System.out.println("1)Retrive All Files");
		 System.out.println("2)Operations");
		 System.out.println("3)Close");
	     System.out.println("\nEnter the option");
	     
	     selection = sc.nextInt();
	     System.out.println("\n");
		 switch(selection) {
		 case 1 :
			 retrive();
			 break;
		 case 2 :
			 operation();
			 break;
	     case 3 :
	    	 sc.close();
			 System.out.println("\n Thanks for visiting LockedMe.com");
			 System.exit(1);		
			 
	     default:
				
				System.out.println("\n Invalid Input,Please re-enter");
				 
		 }
		 }
	}
	
	//Retrieve Block
	
	public static void retrive(){
		File dir = new File ("C:/Locker"); 
		File [] listFile = dir.listFiles();
		Arrays.sort(listFile);
		
		if(listFile.length>0) {
		for(int i=0;i<listFile.length;i++) {
			if(listFile[i].isFile() ) {
				System.out.println("Files......"+listFile[i].getName());
			}
			else if( listFile[i].isDirectory()) {
				System.out.println("Directory......"+listFile[i].getName());
			}
		}
		}
		//No file found
		else {
			System.out.println("Empty directory");
		}
	}
	
	public static void operation() throws IOException{
		
		 Scanner scan = new Scanner(System.in);

		 System.out.println("\nMenu : ");
		 System.out.println("1)Add Files");
		 System.out.println("2)Search File");
		 System.out.println("3)Delete File");
		 System.out.println("\nEnter option: ");
		 int select;
		 select = scan.nextInt();
		 switch (select)
		 	{
		 		case 1 :       		 
       		 System.out.println("\nEnter file name: ");
       		 Scanner input = new Scanner(System.in);
       		 String file = input.next();
       		 System.out.println("\nEnter content: ");
       		 Scanner data = new Scanner(System.in);
       		 String text = data.next();
       		 add(file,text);
       		 break;
		 		
		 		case 2 :               
               System.out.println("\nEnter file name: ");
               Scanner userinput = new Scanner(System.in);
               String fName = userinput.next();
               search(fName);
               break;
               
		 		case 3 :				
				System.out.println("\nEnter file name: ");
				Scanner inputdata = new Scanner(System.in);
				String fileDelete = inputdata.next();
				delete(fileDelete);	
				break;
			
		 		default:
					//In the case of unprecedented input execute this
					System.out.println("\n Invalid Input, Please re-enter \n");
					
		 	}
	}

		
	 
	 public static void add(String fileName,String text) throws IOException{
		   
		   String path="C:\\Locker\\"+fileName+".txt";
		   File file = new File(path);
		   // If file doesn't exists, then create it
		   if (!file.exists()) {
			   file.createNewFile();
			   System.out.println("\nFile created successfully!!");
		   }

		   FileWriter fw = new FileWriter(file.getAbsoluteFile());
		   BufferedWriter bw = new BufferedWriter(fw);

		   // Write in file
		   bw.write(text);

		   // Close connection
		   bw.close();
	        }
	
	 public static void delete(String fileName) {
			String path = "c:\\Locker\\";
			File file = new File( path+ fileName+".txt");
			
			if(file.exists()) {
				if ( file.delete() ) {
					System.out.println(fileName+" File deleted");
				}
			} else {
				System.out.println("Sorry, File can not be found");
			}
		}

	 public static void search(String fileName) {
	
			File dir = new File ("C:/Locker"); 
			boolean isFileFound = false ;
			String [] files = dir.list();
			 for(String file : files) {
			        if(file.equals(fileName+".txt")) {						
						isFileFound = true;						
						break;
			        }else {
			        	isFileFound = false;						
						
						}	
			 }
			 
			 if(isFileFound) {
				 System.out.println("\nFile Found!");
				
				 
				 
			 }
			 else {
				 System.out.println("\nFile Not Found!");
				 
			 }
			 
		}

}