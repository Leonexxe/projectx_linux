#projectX start via python
import os 
print("compiling classes...")
# writing classes to classes.txt
print("writing classes to classes.txt...")
installpath = "/root/PROJECTX/repos/projectx_linux/ProjectX_Client"
files = [];
def list(dir):
	for I in os.listdir(dir):
		if(I.endswith(".java")):
			print(dir + I)
			files.append("\r\n" + dir + I)
		elif not I.__contains__("."):
			list(dir + I + "/")
list(installpath + "/src/")
with open("classes.txt", "w") as f:
	f.writelines(files)
	f.close()
