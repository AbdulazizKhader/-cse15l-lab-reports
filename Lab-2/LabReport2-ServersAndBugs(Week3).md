## Lab Report 2

Welcome back, me. I need no further introduction, but for reference, I am you from week 3 of spring quarter (off-character, I know). This week was really interesting, since it covered *quite* a few things that you will find interesting. Take a look:
- Joined a group! *Pretty chill ppl ngl*
- Got GitHub Desktop: Explanation of what that is comes below, but it IS something you were wondering how to do
- Used URLs in your code by implementing the URI interface
- Building and running your OWN SERVER!!!
- *Running* that server remotely
- Accessing URLs on the command line (pretty neat, am I right?)
- Debugging some weird looking code (and leaned some new terminology)

Yup that's a lot! So here's the breakdown:

### GitHub Desktop
So... This fancy little tool is why you have a GitHub account - other than the fact that you can use it to store all your coding projects. When you create a repository *a fancy word for project folder*, you will want to start writing your code and be able to share the project with your team members. So to do that you have to install GitHub Desktop.

Once you do that and open the app, you should face a page that looks like this:
> ![GitHub opening page](GitHubOpenPage.png)

### Server stuff
Since the next few things are interrelated, it would me much easier to understand if they're all in one heading. So. You wanna make your own server? **WELL HERE YOU GOOOOO!** This is where things get suuper interesting:
First of all, the code you're gonna need is this:
>One to implement the URI (URL library) interface:
```
interface URLHandler {
      String processRequest(URI uri);
}
```
>And one to implement that interface in a method:
```
class Server {
      static void start(int port, URLHandler handler) { //method body. not really important for the idea to be understood }
}
```
Once that's done, here's how you build and run the server:
>*Remember, you are going to run this on your Git Bash, not on your powershell terminal*
>The best way to see a live example is to refer back to the code given to you in the wavelet fork you made.

Some definitions you might need:
> - Ports: The 4000 below identifies a specific port that the web server runs on. This is an extra part of a URL that’s often used in development; 4000 isn’t special and you could pick others – you’re welcome to try a few in the thousands.  
> - Localhost: The localhost domain refers to the computer you’re on. So rather than going out over the internet to send the URL to a particular domain somewhere else, this page is being handled by the running Java program on your computer, which we say is “listening” on localhost at port 4000. That work is what’s done in Server.java and by Java’s HTTPServer library.

1. Open the terminal, then compile and run the files that contain the general server class and your specific implementation of the class:
```
javac Server.java NumberServer.java 
java NumberServer 4000
```
2. Now you're live! Try refreshing the page a couple of times and test out the code in the wavelet file to see what happens!

Now to save your changes, you have to commit and push them, and this is how you do it:  
1. Open your GitHub Desktop window, and it should show that you have made a change in the ```wavelet``` respository. Click the button shown at the bottom left that says ```Commit to master```. 
2. Next, for the changes to actually appear on GitHub, you need to push them. GitHub Desktop should now display a new screen. Click the ```Push origin``` button on the page.

Running it on a remote server just needs one extra step before compiling, which is to log into your remote account and run this:
```git clone <your-repository-url-for-your-fork>```
Then compile and run the files. This result in the same page.
