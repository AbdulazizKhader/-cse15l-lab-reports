## Lab Report 3
WE BACK AT IT! Past two weeks were a bit stressful cuz you took the 15L Skill Demo a.k.a the *"midterm"*, so we only got info for week 4. This is what happened:
- You learned a bunch of new commands!

### The commands:
So here's a breakdown of what you learned:
> - ```find```: it will take a directory path as an argument and list files and directories inside that directory.  
> - Output redirection ``` > ```: it is used with other methods, and it directs the output of the called method and saves it into a new file you create in the terminal. It looks something like ```find hello.java > hello.txt```
> - ```less```: it does the same thing as ```cat```, but it makes it such that not all the output is printed at once. It prints the first couple of lines and to go to the next line you press enter. To exit, press Q.
> - ```wc```: it stands for word count, and it prints out the number of lines, words, and characters in a file.
> ```grep```: it takes a string and a file, and prints out all the lines in that file that *match* the string. As in, if the string was "Hi", it would print out all the lines that contain "Hi".

You also learned about *bash scripts*. Sounds fancy, doesn't it? 
Bash scripts is basically a file that contains a bunch of commands. The great part of this is that you can save a **TON** of commands and run it with a single line. It has to end with ```.sh``` to signal to the terminal that it is a bash scripts. An example would look like:
```
// The name of the file is count-txts.sh
find technical > find-results.txt
grep ".txt" find-results.txt > grep-results.txt
wc grep-results.txt
```
```
bash count-txts.sh
// should output something like:
//  1391     1391   54178 grep-results.txt
```
That basically covered everything you learned. The actual Lab Report happens now:
## Part 1: Researching Commands
The more interesting command in my opinion is ```grep```, so here are a few fun options that you can do with that command:
- ```-i```: This will ignore the uppercase vs. lowercase and find all the files that contain the string. Some examples of that would look like:
```
[cs15lsp23zz@ieng6-201]:stringsearch:121$ grep -i "EveRy" words.txt 
everyone
everything
[cs15lsp23zz@ieng6-201]:stringsearch:122$
```
