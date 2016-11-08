package mdconverter;

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
		else 
			System.out.println("Input file selected : " + args[0]);
		
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
		
		//print for checking
		for( String key : optsList.keySet() ){
            System.out.println( String.format("option : %s, args : %s", key, optsList.get(key)) );
        }

	}
	
	private static boolean validOption(String arg){
		if(arg.length() > 2)
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

}
