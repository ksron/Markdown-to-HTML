Mark Down Converter
===========
**Markdown Converter** is for translating '.md' file to various types of file. It will convert Markdown to HTML, SLIDE HTML, etc.
- - - -
### How To Use?
__A Java file(option_input.java)__ is a tool for Markdown Converter.
In this program, basically we call '.md' file, and decide conversion type, Output's name, Output's style, and Where we saves. Now, our steps of developing is not enough for showing all options. Basically we design converter **'.md' -> '.html'**
- - - -

## Tool's Command:

> mdconverter (-h) 
>            {input_file}
>            {input_file} \[options\]

examples)
> Readme.md -o hello            (o)
> Hongshin.md -o                (x - No argument)
> Hongshin.md                   (o - Default)
> -h                            (o - Call help)
> Hongshin.md -h                (x - Wrong Option)
> Readme.md -o hello -f html    (o)

----------
 __Caution__: Basically tool searches file in ' Tool's directory ' . And if there is a same output's name in same directory, this tool will ask you a question that overwrite or not. if you put 'y or Y' command, it will overwrite, if you put 'n' or 'N' command, it will not overwrite and terminate. 
 
_Handong Global University.
Software Engineering Term project first assignment.
Group S_

\* literal asterisks \* this is an inline image ![Alt text](/path/to/imag.jpg "Optional Text")

1. Our Team
2. Is Doing
3. Such a great job

* Our team
  * Our Team
  * Is Doing
  * Such a great job
* Is Doing
* Such a great job