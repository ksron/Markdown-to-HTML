package mdconverter;

import java.util.HashMap;

public class option_input {

	public static void main(String[] args) {
		HashMap<String, String> optsList = new HashMap<>();
		
		//Check if there is any argument
		if(args.length < 1){
			System.err.println("No argument");
			System.out.println("\nUsage: mdconverter {input_file} [options]");
			System.out.println("-h, -H for help");
			System.exit(0);
		}
		
		//Help message or input file
		//Help message should come solely
		if(args[0].equalsIgnoreCase("-h")){
			System.out.println("Help message");
			System.exit(0);
		}
		else 
			System.out.println("Input file selected : " + args[0]);
		
		//Iterate args & store options to a Hashmap
		try{
			for(int i = 1; i < args.length; i++){
				switch(args[i].charAt(0)){
					case '-':
						// --[option] currently not allowed
						if(args[i].length() > 2)
							throw new IllegalArgumentException("Not a valid argument: " + args[i]);
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
		
		//print for checking
		for( String key : optsList.keySet() ){
            System.out.println( String.format("option : %s, args : %s", key, optsList.get(key)) );
        }

	}

}
