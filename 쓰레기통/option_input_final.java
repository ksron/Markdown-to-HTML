package mdconverter;

import java.util.HashMap;
import java.io.File;
import java.util.Scanner;

public class option_input {

	public static void main(String[] args) {
		HashMap<String, String> optsList = new HashMap<>();
		
		//Check if there is any argument
		if(args.length == 0){
			System.err.println("No argument"
					ZZ)
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
		else{
			String input = args[0];
			if(!args[0].endsWith(".md"))
				input = input + ".md";
			
			try{
				switch(inputFileExistance(input)){
					case 2:
						throw new IllegalArgumentException("input error 1 : excepting extension, file name cannot contain '.' (ex. fileA.md.md))");
					case 3:
						throw new IllegalArgumentException("input error 2: input file cannot have file with other extension. (ex. fileA.html)");
					case 4:
						throw new IllegalArgumentException("input error 3 : file name excepting pathname cannot includes '/','?', ... (OS requirement)");
					case 6:
						throw new IllegalArgumentException("input doesn't exist.");
						
					default:
							System.out.println("Input file selected : " + input.toLowerCase());	
				}

			}catch(IllegalArgumentException e){
				System.err.println(e);
				System.exit(0);
			}
		}
		
		//set default options
		optsList.put("o", args[0].replace(".md", ""));
		optsList.put("f", "html");
		optsList.put("s", "plain");
		optsList.put("d", "");
		
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
						}else if(args[i].equals("-3")){
							System.out.println("Option set 3 selected");
						}
						else{
							// [-option] should be followed by details
							if((i >= args.length - 1) || args[i+1].charAt(0) == '-')
								throw new IllegalArgumentException("Expected info after " + args[i]);
							else
								optsList.put(args[i].toLowerCase().substring(1),args[(i++)+1]);							
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
		
		//check if the same output file already exist.
		try{
			switch(outputFileExistence(optsList.get("o"), optsList.get("f"),optsList.get("d"),optsList.get("s"))){
				case 2:
					throw new IllegalArgumentException("\n Not a valid pathname(-d).\n It cannot conatain '.'");
				case 3:
					throw new IllegalArgumentException("\n Not a valid format(-f).\n It should be 'html', '.html'");
				case 4:
					throw new IllegalArgumentException("\n Not a valid output file name.\n It cannot conatain '/','*','?','\"','<','>','|'");
				case 5:
					throw new IllegalArgumentException("In the directory, there exist same file.");
				case 6:
					throw new IllegalArgumentException("wrong output name. Cannot contain \".\": " + optsList.get("o"));
				case 7:
					throw new IllegalArgumentException("wrong style.");
				default:
					System.out.println("Output file saved");				
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

	private static int inputFileExistance(String inFile){
		
		//input error 1 : excepting extension, file name cannot contain '.' (ex. fileA.md.md))
		if(inFile.endsWith(".md")){
			if(inFile.split(".md")[0].contains("."))//
				return 2;
		}
		
		//input error 2: input file cannot have file with other extension. (ex. fileA.html)
		else if(inFile.contains("."))
			return 3;
		
		//input error 3 : OS doesn't allow file name (excepting pathname) to include properties like below
		String[] invalidName = {"/","*","?","\"","<",">","|"};
		for(int i=0;i<invalidName.length;i++)
			if(inFile.split(".md")[0].contains(invalidName[i]))
				return 4;
	
		//make filename end with '.md'
		//for pathname, it'd be absolute or relative.
		if(!inFile.endsWith(".md"))
			inFile = inFile + ".md";
		
		File file = new File(inFile);
		if(file.exists())
			return 0;
		else
			//when file doesn't exist. 
			return 6;
	}
	
	private static int outputFileExistence(String outFile, String format, String dir, String sty){
		//when the pathname is not valid, it returns 2
		//when the extension is not valid, it returns 3
		//when the file name is not valid, it returns 4
		//when the file with same name, extension, and pathname exists, it returns 5
		//when the output file's options are all valid and there exist no same file,  it returns 0.
		
		//check pathname's validity
		if(dir.contains("."))
			return 2;
		
		//check file format's validity
		if(outFile.contains("."))
			return 6;
		
		//check file name's validity
		String[] invalidName = {"/","*","?","\"","<",">","|"};
		for(int j = 0; j < invalidName.length;j++)
			if(outFile.contains(invalidName[j]))
				return 4;
		
		//check extension's validity
		String vaildExten[] = {"html",".html"};
		int i = 0;
		
		for(;i<vaildExten.length;i++)
			if(format.equalsIgnoreCase(vaildExten[i]))
				break;
		if(i==vaildExten.length)
			return 3;//the extension is not valid.
		
		//Check style's validity
		String vaildSty[] = {"plain", "fancy", "slide"};
		int k = 0;
		
		for(;k<vaildSty.length;k++)
			if(sty.equals(vaildSty[k]))
				break;
		if(k==vaildSty.length)
			return 7;//the style is not valid.
		
		//make the file format start with "."
		if(!(format.contains(".")))
			format = "." + format;
				
		//make the pathname end with "/"
		if(!dir.endsWith("\\") && !dir.endsWith(""))
			dir = dir + "\\";
		
		//make the style 
		if(!sty.equalsIgnoreCase("plain"))
			outFile = outFile + "_" +sty;
		
		//check if the output file with same file name and format exist. 
		File file = new File(dir + outFile + format);
		System.out.println(dir + outFile + format);
		if(file.exists()){
			//File already exist
			Scanner reader = new Scanner(System.in);
			System.err.println("The output file already exists. Press y to continue");
			String s = reader.next();
			
			if(s.equalsIgnoreCase("y")){
				file.delete();
				//file.createNewFile();
			return 0;
			}
			else 
				return 5;
			}
		return 0;
		}
	
}
