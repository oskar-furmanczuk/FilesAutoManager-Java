1) Description of the application
The application will allow you to segregate files. The program creates a directory structure:
- HOME
- DEV
- TEST

When a file appears in the HOME directory, depending on its extension, it will be moved to a folder according to the following rules
- a file with the extension .jar, whose creation time is even, will be moved to the DEV folder
- files with .jar extension whose creation time is odd will be moved to the TEST folder
- the file with the extension .xml should be moved to the DEV folder

Additionally, the newly created file /home/count.txt stores the number of moved files (all and by
directories), the file stores the current number of processed files.


2) How to start the program
- Use the "cd" command in the CMD program to go to the directory containing the "pom.xml" file. 
- We have to have Maven and Java JDK configured first
- To run the program, type "java \src\main\java\Main.java" in the CMD

The startup directory is "C:/" where the folder "BASE_FOLDER" is automatically created and where the operations described in the exercise are carried out.
