#projectX start via python
import os 
print("compiling classes...")
os.system("javac folder *.java") # compiling classes
print("...done")
print("compiling classes...")
sysout = input("start with or without console output? (could/will affect performance!)[Y/n]:")
if sysout == "Y":
	print("starting with console output")
	print("executing main class...")
	os.system("java main.java") # executing the main class
else:
	print("starting without console output")
	print("executing main class...")
	os.system("java main.java") # executing the main class