import os
for I in os.listdir("/root/github/ProjectX_Client/ProjectX_Client/src"):
    if I.endswith(".java"):
        print("\33[91m"+I)
        with open("/root/github/ProjectX_Client/ProjectX_Client/src/"+I) as II:
            data = II.readlines()
            if data[0].__contains__("package"):
                data[0] = ""
                with open("/root/github/ProjectX_Client/ProjectX_Client/src/"+I, "w") as IV:
                    IV.writelines(data)
                    print("\33[92m"+I)

