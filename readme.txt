 _____                           __        __    _                   
|_   _|____      _____ _ __ ___  \ \      / /_ _| |_ ___  ___  _ __  
  | |/ _ \ \ /\ / / _ \ '__/ __|  \ \ /\ / / _` | __/ __|/ _ \| '_ \ 
  | | (_) \ V  V /  __/ |  \__ \   \ V  V / (_| | |_\__ \ (_) | | | |
  |_|\___/ \_/\_/ \___|_|  |___/    \_/\_/ \__,_|\__|___/\___/|_| |_|
                                                                     

THANKS :

First of all, thank you for giving me the opportunity to show you my coding skills through this challenge.
I found the subject very interesting :)


HOW TO USE : 

The file containing the datas is « in.csv »
The output file created is « out.csv »

Use a terminal and go to the folder TW
Use this commands to compile and launch the program
> javac *.java 
> java Launch

The output file is created. 
You can see it using this command or open the file with your preferred file reader.
> more out.csv 

You can change the file « in.csv » and recompile, you will get a different « out.csv ».


IMPORTANT TO KNOW :

- The input file has to be named « in.csv ». 
- It must be in the same folder than the java classes.
- Name of product cannot have a comma in their names because it is the default separator and has to be a String.
- Years has to be Intergers
- Incremental value has to be float

- To test you can add more triangles in the input file, changing the year dates.


WHAT DO MY PROGRAM :

- The program return in the output file the accumulate data from an input file containing incremental payment data

- The data may contain more than two triangles and there may be more than four origin year. For example in the input 
file I attached, there are 3 triangles.

- In practise data files may contain errors or the data may be in an unexpected format. There is much to do to cover all possibilities. My program do the followings :
	• If you enter many times the same data line with different incremental value, it keeps the last one.
	• Comments and empty line can be added to the input file without problems.
	• If a data line contains more data than specified by headings, then it is ignore. We consider that the
	line contains mistakes and should not be evaluate.
	• The separator is a comma but in France it could be a semi-column. So the default separator used in this 
	file is the comma but it could be another one.
	• The data line are not forced to be order by product name.



WHAT IF I HAD MORE TIME :

As I had an exam in Finance on Thursday afternoon, I started this challenge Thursday evening and had less than two days.
That is why I would like to tell you what I would add to my program if I had more time.

- I could have made a GUI with Swing, so that the user could choose the file. Currently the file « in.csv » in the folder is selected.

- The most important is that I would have handle exceptions by notifying the user with messages.

- I could have made a clean class Diagram, but I decided to take my time to well comment files so you can understand my choices and what functions do.




