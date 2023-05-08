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
[cs15lsp23zz@ieng6-201]:911report:128$ grep -i "HanDle" chapter-1.txt
```
    At 9:42, the Command Center learned from news reports that a plane had struck the Pentagon. The Command Center's national operations manager, Ben Sliney, ordered all FAA facilities to instruct all aircraft to land at the nearest airport. This was an unprecedented order. The air traffic control system handled it with great skill, as about 4,500 commercial and general aviation aircraft soon landed without incident.
    The defense of U.S. airspace on 9/11 was not conducted in accord with preexisting training and protocols. It was improvised by civilians who had never **handled** a hijacked aircraft that attempted to disappear, and by a military unprepared for the transformation of commercial aircraft into weapons of mass destruction. As it turned out, the NEADS air defenders had nine minutes' notice on the first hijacked plane, no advance notice on the second, no advance notice on the third, and no advance notice on the fourth.

