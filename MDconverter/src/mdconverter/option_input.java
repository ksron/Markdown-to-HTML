package mdconverter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class option_input {

	public static void main(String[] args) {
		HashMap<String, String> optsList = new HashMap<>();

		//Check if there is any argument
		if(args.length == 0){
			System.err.println("No argument");
			System.out.println("\nUsage: mdconverter {input_file} [options]");
			System.out.println("-h, -H for help");
			System.exit(-1);
		}
		
		//Help message or input file
		//Help message should come solely
		if(args[0].equalsIgnoreCase("-h")){
			System.out.println("Help message");
			System.exit(1);
		}
		
		File inputFile = new File(args[0]);
		if(!inputFile.exists()){
			System.err.println("File does not exist:" + args[0]);
			System.exit(-1);
		}
		System.out.println("Input file selected : " + args[0]);	
		
		//Set initial options
		optsList.put("o", inputFile.getName().split("\\.")[0]);
		optsList.put("f", "html");
		optsList.put("s", "plain");
		optsList.put("d", ".");
		
		//Iterate args & store options to a Hashmap
		try{
			for(int i = 1; i < args.length; i++){
				switch(args[i].charAt(0)){
					case '-':
						// --[option] currently not allowed
						if(!validOption(args[i]))
							throw new IllegalArgumentException("Not a valid argument: " + args[i]);
						else if(args[i].equals("-1")){
							System.out.println("Option set 1 selected");
						}
						else if(args[i].equals("-2")){
							System.out.println("Option set 2 selected");
						}
						else if(args[i].equals("-3")){
							System.out.println("Option set 3 selected");
						}
						else{
							// [-option] should be followed by details
							if((i >= args.length - 1) || args[i+1].charAt(0) == '-')
								throw new IllegalArgumentException("Expected info after " + args[i]);
							else
								optsList.put(args[i].substring(1), args[(i++)+1]);							
						}
						break;
					default:
						throw new IllegalArgumentException("Not an option argument: " + args[i]);				
				}
			}
		}catch(IllegalArgumentException e){
			System.err.println(e);
			System.exit(0);
		}
		
		//check the output file already exists
		File outputFile = new File(optsList.get("d")+ "\\" +optsList.get("o")+ "." +optsList.get("f"));
		try {
			if(optsList.get("d").length() > 1)
				outputFile.getParentFile().mkdirs();
			
			//creating new file
			if(!outputFile.createNewFile()){
				//File already exist
				Scanner reader = new Scanner(System.in);
				System.err.println("The output file already exists. Press y to continue");
				String s = reader.next();
				if(s.equalsIgnoreCase("y")){
					outputFile.delete();
					outputFile.createNewFile();
				}
				else System.exit(1);
			}
		} catch(NullPointerException e){
			System.err.println("No certain directory");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Wrong Format and directory");
			System.exit(1);
		}
				
		 //print for checking
		for( String key : optsList.keySet() ){
            System.out.println( String.format("option : %s, args : %s", key, optsList.get(key)) );
        }
	}
	
	//test if the options are valid. 
	//the works for valid options are done in other section. 
	private static boolean validOption(String arg){
		if(arg.length() > 2 )
			return false;
		switch(arg.charAt(1)){
			case 'o':
			case 'f':
			case 's':
			case '1':
			case '2':
			case '3':
			case 'd':
				return true;
			default:
				break;				
		}
		return false;
	}
	
}