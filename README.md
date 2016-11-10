===========
**Markdown Converter** is for translating '.md' file to various types of file. It will convert Markdown to HTML, PDF, SLIDE HTML, etc.
- - - -
###How To Use?
__A Java file__(option_input.java) is a tool for Markdown Converter.
In this program, basically we call '.md' file, and decide conversion type, Output's name, Output's style, and Where we saves. Now, our steps of developing is not enough for showing all options. Basically we design converter **'.md' -> 'html'**
- - - -
###Tool's Command:
####mdconverter  {input_file} [options]
   * {input_file}: Input File's name. If file does not exist, it will send error message.
```java
private static boolean inputFileExistance(String inFile){
   /*Checking existency of files in directory
   If file does not exist, call error message*/
  }
 ```
   * [options]: Choose options for converting '.md' file. This options does not impact by ordering. For example, '[-o] [-s] [-f]' shows same result with '[-f] [-s] [-o]'. And options cannot be run if user put wrong command(including {input_file}) or computer cannot find '.md' file. User can use both 'Upper' and 'Lower' alphabet.
       * -o
       * -f
       * -s
       * -1
       * -2
       * -3
   * [-h]: Show Help messages.
```
Help Message
```

#Must be added:
 1. Detail Option(No file, Type, etc)
 2. Where to save, How can defie
 3. Command example
 4. Number(1,2,3)'s detail command
