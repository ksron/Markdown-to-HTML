package mdconverter;

import java.io.File;
import java.util.HashMap;

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
		else {
			try{
				if(!inputFileExistance(args[0]))
					throw new IllegalArgumentException("Not a valid file name:" + args[0]);
				else
					System.out.println("Input file selected : " + args[0]);	
			}catch(IllegalArgumentException e){
				System.err.println(e);
				System.exit(0);
			}
		}
		
		//Iterate args & store options to a Hashmap
		try{
			for(int i = 1; i < args.length; i++){
				switch(args[i].charAt(0)){
					case '-':
						// --[option] currently not allowed
						if(!validOption(args[i]))
							throw new IllegalArgumentException("Not a valid argument: " + args[i]);
						else if(args[i].equalsIgnoreCase("-1")){
							System.out.println("Option set selected");
						}
						else if(args[i].equalsIgnoreCase("-2")){
							System.out.println("Option set selected");
						}
						else if(args[i].equalsIgnoreCase("-3")){
							System.out.println("Option set selected");
						}
						{
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
		 //1. specified format
		   //1-1. specified directory
		outputFileExistence(args[0], optsList.get("f"), optsList.get("d"));
		   //1-2. not specified directory
		outputFileExistence(args[0], optsList.get("f"), "");
		 //2. not specified format
		  //2-1. specified directory
		outputFileExistence(args[0], "html", optsList.get("d"));
		  //2-2. not specified directory
		outputFileExistence(args[0], "html", "");
		
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
		switch(arg.toLowerCase().charAt(1)){
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
	
	private static boolean inputFileExistance(String inFile){
		/*File file = new File(inFile);	
		if(file.exists() && file.getName().endsWith("md"))
			return true;*/
		File file = new File(inFile+"md");
		if(file.exists())
			return true;
		else
			return false;
	}
	
	private static boolean outputFileExistence(String outFile, String format, String dir){
		File file = new File(outFile);
		if(file.exists() && file.getName().endsWith(format))
			return false;
		else
			return true;
	}

}
