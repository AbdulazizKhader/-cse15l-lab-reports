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
The output:
At 9:42, the Command Center learned from news reports that a plane had struck the Pentagon. The Command Center's national operations manager, Ben Sliney, ordered all FAA facilities to instruct all aircraft to land at the nearest airport. This was an unprecedented order. The air traffic control system ***handled*** it with great skill, as about 4,500 commercial and general aviation aircraft soon landed without incident.  

The defense of U.S. airspace on 9/11 was not conducted in accord with preexisting training and protocols. It was improvised by civilians who had never ***handled*** a hijacked aircraft that attempted to disappear, and by a military unprepared for the transformation of commercial aircraft into weapons of mass destruction. As it turned out, the NEADS air defenders had nine minutes' notice on the first hijacked plane, no advance notice on the second, no advance notice on the third, and no advance notice on the fourth.


```
[cs15lsp23zz@ieng6-201]:911report:129$ grep -i "woRkIng In" chapter-1.txt
```
The output:
At 9:59, an Air Force lieutenant colonel ***working in*** the White House Military Office joined the conference and stated he had just talked to Deputy National Security Advisor Stephen Hadley. The White House requested (1) the implementation of continuity of government measures, (2) fighter escorts for Air Force One, and (3) a fighter combat air patrol over Washington, D.C.
- ```-c```: This will give you the *number* of lines that match the given string:
```
[cs15lsp23zz@ieng6-201]:911report:130$ grep -c "military" chapter-1.txt
35
```
This means that there are 35 lines in chapter-1.txt that have the string "miltary" in them.
```
[cs15lsp23zz@ieng6-201]:911report:133$ grep -i -c "LAnd" chapter-1.txt
34
```
Did you notice that I used two commands? This output means that there are 34 lines that contain the word "land" *regardless of the case of the letters*.
- ```-n```: This will output the line that matches the string AND the line number it was found in:
```
[cs15lsp23zz@ieng6-201]:911report:139$ grep -n "word" chapter-1.txt
```
The output was very long, so here is a good chunk of it:  

274:    The controller only heard something unintelligible; he did not hear the specific words "we have some planes." The next transmission came seconds later: American 11: Nobody move. Everything will be okay. If you try to make any moves, you'll endanger yourself and the airplane. Just stay quiet.

280:    By this time, American 11 had taken a dramatic turn to the south. At 8:32, the Command Center passed word of a possible hijacking to the Operations Center at FAA headquarters. The duty officer replied that security personnel at headquarters had just begun discussing the apparent hijack on a conference call with the New England regional office. FAA headquarters began to follow the hijack protocol but did not contact the NMCC to request a fighter escort.

302:    F-15 fighters were scrambled at 8:46 from Otis Air Force Base. But NEADS did not know where to send the alert fighter aircraft, and the officer directing the fighters pressed for more information:"I don't know where I'm scrambling these guys to. I need a direction, a destination." Because the hijackers had turned off the plane's transponder, NEADS personnel spent the next minutes searching their radar scopes for the primary radar return. American 11 struck the NorthTower at 8:46. Shortly after 8:50, while NEADS personnel were still trying to locate the flight, word reached them that a plane had hit the World Trade Center.

```
[cs15lsp23zz@ieng6-201]:911report:144$ grep -i -n "heLiCop" chapter-1.txt
```
The output:

656:    Once again, there was no immediate information about the fate of the inbound aircraft. In the apt description of one witness, "It drops below the radar screen and it's just continually hovering in your imagination; you don't know where it is or what happens to it." Eventually, the shelter received word that the alleged hijacker 5 miles away had been a medevac helicopter.
- ```-v```: The "inverter", which gives you all the lines that do *not* match the given string:
```
[cs15lsp23zz@ieng6-201]:911report:150$ grep -v -n "At"  chapter-1.txt
```
The output was very large as well, but here is a small part of it:  

302:    F-15 fighters were scrambled at 8:46 from Otis Air Force Base. But NEADS did not know where to send the alert fighter aircraft, and the officer directing the fighters pressed for more information:"I don't know where I'm scrambling these guys to. I need a direction, a destination." Because the hijackers had turned off the plane's transponder, NEADS personnel spent the next minutes searching their radar scopes for the primary radar return. American 11 struck the NorthTower at 8:46. Shortly after 8:50, while NEADS personnel were still trying to locate the flight, word reached them that a plane had hit the World Trade Center.

640:    Among the sources that reflect other important events of that morning, there is no documentary evidence for this call, but the relevant sources are incomplete. Others nearby who were taking notes, such as the Vice President's chief of staff, Scooter Libby, who sat next to him, and Mrs. Cheney, did not note a call between the President and Vice President immediately after the Vice President entered the conference room.
```
grep -v -n -i "it"  chapter-1.txt
```
A part of the output is:

640:    Among the sources that reflect other important events of that morning, there is no documentary evidence for this call, but the relevant sources are incomplete. Others nearby who were taking notes, such as the Vice President's chief of staff, Scooter Libby, who sat next to him, and Mrs. Cheney, did not note a call between the President and Vice President immediately after the Vice President entered the conference room.

716:    First, the Langley pilots were never briefed about the reason they were scrambled. As the lead pilot explained, "I reverted to the Russian threat. . . . I'm thinking cruise missile threat from the sea. You know you look down and see the Pentagon burning and I thought the bastards snuck one by us. . . . [Y]ou couldn't see any airplanes, and no one told us anything." The pilots knew their mission was to divert aircraft, but did not know that the threat came from hijacked airliners. 
