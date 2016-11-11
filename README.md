![logo](Logo.jpg)
Mark Down Converter
===========
**Markdown Converter** is for translating '.md' file to various types of file. It will convert Markdown to HTML, PDF, SLIDE HTML, etc.
- - - -
###How To Use?
__A Java file__(option_input.java) is a tool for Markdown Converter.
In this program, basically we call '.md' file, and decide conversion type, Output's name, Output's style, and Where we saves. Now, our steps of developing is not enough for showing all options. Basically we design converter **'.md' -> 'html'**
- - - -
##Tool's Command:
```
mdconverter (-h) 
            {input_file}
            {input_file} [options]
```
examples)
```
mdconverter Readme.md -o hello
mdconverter Hongshin.md -o 
mdconverter -h
```
   * (-h): Show help messages. mdconverter -h.
```
***********Markdown Converter**********
mdconverter (-h)
            {input_file}
            {input_file} [options]      
***************************************
(-h): Show help message.

{input_file}: Input file's name. You can add name extension ".md" or not. But this program only find '.md' File.
              If computer does not find input file, it will send error message.
              If you put only {input_file}, "{input_file}.html" file will be made (same name, but '.html').

[options]: 
           -o  -filename : Make html file which name is decided by user.
                           We do not allow file's name extension. You can decide file's type(format) using '-f'
           -f  -format   : Decide output's format type. '.html' and '.pptx' are allowed in this version.
           -s  -style    : Decide output's style type (plain, fancy, slide). Only 'lower case' is allowed in '-style'. 
            ---------- Shortkut Key Usage -----------
            This is for shortkut key. 
           [-1] : Command 1 
           [-2] : Command 2
           [-3] : Command 3
```
   * {input_file}: Input File's name. If file does not exist, it will send error message.
```java
private static boolean inputFileExistance(String inFile){
   /*Checking existency of files in directory
   If file does not exist, call error message*/
  }
 ```
   * [options]: Choose options for converting '.md' file. This options does not impact by ordering. For example, '[-o] [-s] [-f]' shows same result with '[-f] [-s] [-o]'. And options cannot be run if user put wrong command(including {input_file}) or computer cannot find '.md' file. User can use both 'Upper' and 'Lower' alphabet.
       * -o: Output
       * -f: Format
       * -s: Style
       * -1: Command 1
       * -2: Command 2
       * -3: Command 3
   
----------
 __Caution__: Basically tool searches file in 'Tool's directory'. And if there is a same output's name in same directory, this tool will ask you a question that overwrite or not. if you put 'y or Y' command, it will overwrite, if you put 'n' or 'N' command, it will not overwrite.
 
----------
#Must be added:
 1. Detail Option(No file, Type, etc)
 2. Where to save, How can defie
 3. Command example
 4. Number(1,2,3)'s detail command
