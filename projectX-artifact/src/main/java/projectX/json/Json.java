package json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Json {

      private jsonreader reader = null;
      private JsonObjectFinder objectFinder = null;
      public JsonGroup mainJsonGroup = null;
      private JsonGroupFinder groupFinder = null;
      private String filePath = "";

      public Json(String filePath) 
      {
            this.filePath = filePath;
            this.reader = new jsonreader(this.filePath);
            this.mainJsonGroup = reader.read();
            this.objectFinder = new JsonObjectFinder(this.mainJsonGroup);
            this.groupFinder = new JsonGroupFinder(this.mainJsonGroup);
      }

      public void createNewValue(String JsonPath, String name, String value)
      {
            this.groupFinder.getJsonObject(JsonPath).createValue(name, value);
      }

      public void createNewGroup(String JsonPath, String name)
      {
            this.groupFinder.getJsonObject(JsonPath).createSubGroup(name);
      }

      public void DeleteGroup(String JsonPath)
      {
            this.groupFinder.getJsonObject(JsonPath).name = "[--DELETED]";
      }

      public void DeleteValue(String JsonPath)
      {
            this.objectFinder.getJsonObject(JsonPath).name = "[--DELETED]";
      }

      public void save()
      {
          this.saveToFile(this.filePath);
      }

      public void saveToFile(String filePath)
      {
            try {
                  FileWriter file = new FileWriter(filePath);
                  for(String i : JsonToString(this.mainJsonGroup))
                  {
                        file.append(i);
                  }
                  file.close();
            } catch (IOException e) {
                  e.printStackTrace();
            }
      }

      private String[] JsonToString(JsonGroup Json)
      {
            ArrayList<String> lines = new ArrayList<String>();
            lines.add("{");
            lines.add(LoopThroughSubGroups(Json, "    "));

            /*
            * writing the content of the ArrayList in an Array
            */
            String[] Lines = new String[lines.size()];
            int c = 0;
            for(String i : lines)
            {
                  Lines[c] = i;
                  c++;
            }
            for(String i : Lines)
            {
            }
            return Lines;
      }

      public ArrayList<JsonData> JsonToArray(JsonGroup mainGroup)
      {
            System.out.println("function JsonToArray");
            ArrayList<JsonData> ret = new ArrayList<JsonData>();
            for (JsonData I : mainGroup.data)
            {
                  ret.add(I);
            }
            for (JsonGroup I : mainGroup.subGroups)
            {
                  ArrayList<JsonData> data = loopII(I);     
                  for(JsonData II : data)
                  {
                        ret.add(II);
                  }
            }
            return ret;
      }

      public ArrayList<JsonData> loopII(JsonGroup mainGroup)
      {
            ArrayList<JsonData> ret = new ArrayList<JsonData>();
            for (JsonData I : mainGroup.data)
            {
                  ret.add(I);
            }
            for (JsonGroup I : mainGroup.subGroups)
            {
                  ArrayList<JsonData> data = loopII(I);     
                  for(JsonData II : data)
                  {
                        ret.add(II);
                  }
            }
            return ret;
      }

      private String LoopThroughSubGroups(JsonGroup Json,String indent)
      {
            String result = "";
            String Indent = indent;
            String newline= "\r\n";
            String endIndent = Indent.substring(4);
            int count = 0;
            for (JsonData i : Json.data) {
                  if(i.name == "[--DELETED]")
                  {
                  }
                  else
                  {
                        count++;
                        String var = newline + Indent + "\"" + i.name + "\" : \"" + i.value + "\"";
                        if(count > 1)
                        {
                              var = newline + indent + "," + var;
                        }
                        result = result + var;
                  }
            }
            for (JsonGroup i : Json.subGroups) {
                  if(i.name == "[--DELETED]")
                  {
                  }
                  else
                  {
                        count++;
                        String group = newline + Indent + "\"" + i.name + "\" : {";
                        if(count > 1)
                        {
                              group = newline + indent + "," + group;
                        }
                        result = result + group;
                        result = result + this.LoopThroughSubGroups(i, Indent + "    ");
                  }
            }
            result = result + newline + endIndent + "}";
            return result;
      }

      public JsonData getObject(String JsonPath)
      {
            return this.objectFinder.getJsonObject(JsonPath);
      }

      public String getValue(String JsonPath)
      {
            return this.objectFinder.getJsonObject(JsonPath).value;
      }
}

class jsonreader {

      /*
       ! variables
       */
      protected JsonFile file = null;
      private JsonGroup currentSubGroup = null;

      /*
       ! consturctors
       */
      protected jsonreader(String filePath) {
            this.file = new JsonFile(filePath);
      }

      /*
       ! Functions
       */
      public JsonGroup read() {
            JsonGroup Json = new JsonGroup("--Json", "--Json");
            this.currentSubGroup = Json;

            int subgroupcount = 0;

            Boolean isfirstline = true;

            for (String i : this.file.lines) {
                  if (isfirstline) {
                        isfirstline = false;
                  } else {
                        if (i.contains("{")) {
                              String[] Tokens = i.split("\"");
                              this.currentSubGroup = this.currentSubGroup.createSubGroup(Tokens[1]);
                              subgroupcount++;
                        } else if (jsonreaderi.contains("}")) {
                              subgroupcount--;
                              if (subgroupcount == 0) {
                                    this.currentSubGroup = Json;
                              } else {
                                    /*
                                    * i represents each object in the JsonGroup.
                                    * the programm loops through all objects in the JsonGroup.
                                    * if the name of the Object equals the name the programm should search for
                                    * the loop ends and the object will be retruned
                                    */
                                    if(found == true)
                                    {
                                          break;
                                    }
                                    if(i.path.contentEquals(search))
                                    {
                                          result = i;
                                          this.found = true;
                                          System.out.println("found!");
                                          System.out.println(i);
                                          System.out.println(i.path);
                                          System.out.println("\"" + i.name + "\" : \"" + i.value + "\"");
                                    }
                              }
                              for (JsonGroup i : Json.subGroups) {
                                    if(found == true)
                                    {
                                          break;
                                    }
                                    /*
                                    * i represents each subgroup of the JsonGroup
                                    * the programm loops through all subgroups of the JsonGroup
                                    */
                                    JsonData data = this.LoopThroughSubGroups(i, search);
                                    if(data.path != "null")
                                    {
                                          result = data;
                                    }
                              }
                              if(result == null)
                              {
                                    result = new JsonData("null", "null", "null");
                              }
                              this.found = false;
                              return result;
                        }
                  }
                  class JsonGroupFinder
                  {
                        private JsonGroup Json = null;
                        private Boolean found = false;
                        protected JsonGroupFinder(JsonGroup mainJsonGroup)
                        {
                              this.Json = mainJsonGroup;
                        }
                  
                        public JsonGroup getJsonObject(String JsonPath)
                        {
                              return this.LoopThroughSubGroups(this.Json, JsonPath);
                        }
                  
                        private JsonGroup LoopThroughSubGroups(JsonGroup Json, String search)
                        {
                              JsonGroup result = null;
                              if(Json.path.contentEquals(search))
                              {
                                    this.found = true;
                                    result = Json;
                              }
                              for (JsonGroup i : Json.subGroups) {
                                    /*
                                    * i represents each object in the JsonGroup.
                                    * the programm loops through all objects in the JsonGroup.
                                    * if the name of the Object equals the name the programm should search for
                                    * the loop ends and the object will be retruned
                                    */
                                    if(found == true)
                                    {
                                          break;
                                    }
                                    if(i.path.contentEquals(search))
                                    {
                                          result = i;
                                          this.found = true;
                                          System.out.println("found!");
                                          System.out.println(i);
                                          System.out.println(i.path);
                                          System.out.println("\"" + i.name + "\"");
                                    }
                                    JsonGroup Group = this.LoopThroughSubGroups(i, search);
                                    if(Group.path != "null")
                                    {
                                          result = Group;
                                    }
                              }
                              if(result == null)
                              {
                                    result = new JsonGroup(null, "null", "null");
                              }
                              this.found = false;
                              return result;
                        }
                  }
                  
                                    this.currentSubGroup = this.currentSubGroup.parentGroup;
                              }
                        } else if (i.contains(",")) {
                        } else {
                              String[] Tokens = i.split("\"");
                              String[] Tokens2 = i.split(":");
                              String[] Tokens3 = Tokens2[1].split("\"");

                              String value = Tokens3[1];
                              String name = Tokens[1];
                              String path = "";
                              JsonGroup CurrentSubGroup = this.currentSubGroup;
                              while(true)
                              {
                                    path = this.currentSubGroup.name + "/" + path;
                                    if(this.currentSubGroup.name == "--Json")
                                    {
                                          break;
                                    }
                                    this.currentSubGroup = this.currentSubGroup.parentGroup;
                              }
                              this.currentSubGroup = CurrentSubGroup;
                              path = path + name;
                              System.out.println(path);
                              this.currentSubGroup.data.add(new JsonData(value, name, path));
                        }
                  }
            }
            return Json;
      }

      public static void printJson(JsonGroup Json) {
            System.out.println("///// " + Json.name + " /////");
            System.out.println("///// SubGroups of " + Json.name + " /////");
            for (JsonGroup i : Json.subGroups) {
                  System.out.println("///// " + i.name + " /////");
                  System.out.println("///// SubGroups of " + i.name + " /////");
                  for (JsonGroup j : i.subGroups) {
                        printJson(j);
                  }
                  System.out.println("///// Data of " + i.name + " /////");
                  for (JsonData j : i.data) {
                        System.out.println(j.name + " : " + j.value);
                  }
                  System.out.println(" ");
            }
            System.out.println("///// Data of " + Json.name + " /////");
            for (JsonData j : Json.data) {
                  System.out.println(j.name + " : " + j.value);
            }
      }
}

class JsonGroup {

      public ArrayList<JsonGroup> subGroups = new ArrayList<JsonGroup>();
      public ArrayList<JsonData> data = new ArrayList<JsonData>();
      public JsonGroup parentGroup = null;
      public String name = "";
      public String path = "";

      /*
       * ! consturctors
       */
      public JsonGroup(JsonGroup parentGroup, String name, String path) {
            this.parentGroup = parentGroup;
            this.name = name;
            this.path = path;
      }

      public JsonGroup(String name, String path) {
            this.name = name;
            this.path = path;
      }

      /*
       * ! Functions
       */

      public JsonGroup createSubGroup(String name) {
            JsonGroup Group = new JsonGroup(this, name, this.path + "/" + name);
            this.subGroups.add(Group);
            return Group;
      }

      public JsonData createValue(String name, String value)
      {
            JsonData data = new JsonData(name, value, this.path + "/" + name);
            this.data.add(data);
            return data;
      }

}

class JsonWriter {

      public JsonGroup Json = null;

      protected JsonWriter(JsonGroup Json) 
      {
            this.Json = Json;
      }
      

      public void createNewValue(String path)
      {
      }

      public void createNewGroup(String path)
      {
      }

      public void DeleteGroup(String path)
      {
      }

      public void DeleteValue(String path)
      {
      }
}

class JsonFile {
      private FileReader reader = null;
      private FileWriter writer = null;
      private BufferedReader buffReader = null;
      private File file = null;

      public ArrayList<String> lines = new ArrayList<String>();

      private int currentLine = 0;

      private String write = "";

      public JsonFile(String path) 
      {
            this.file = new File(path);
            try {
                  this.reader = new FileReader(this.file);
                  this.buffReader = new BufferedReader(this.reader);
            } catch (FileNotFoundException e) {
                  e.printStackTrace();
            }
            try {
                  this.readFile();
            } catch (IOException e) {
                  e.printStackTrace();
            }
      }

      // public methods

      public void write(String[] lines)
      {
            try {
                  this.writer = new FileWriter(this.file);
            } catch (IOException e1) {
                  e1.printStackTrace();
            }
            for(String i : lines)
            {
                  try {
                        this.writer.append(i);
                  } catch (IOException e) {
                        e.printStackTrace();
                  }
            }
            try {
                  writer.close();
            } catch (IOException e) {
                  e.printStackTrace();
            }
      }

      public boolean delete() 
      {
            return this.file.delete();
      }

      public void close() throws IOException 
      {
            this.reader.close();
            //this.writer.close();
      }

      public void append(String append, Boolean newLine) 
      {
            if(newLine) {
                  this.write = this.write + "\r\n" + append;
            }
            else{
                  this.write = this.write + append;
            }
      }

      public String nextLine() 
      {
            this.currentLine++;
            return this.lines.get(this.currentLine);
      }

      public String getLine(int index) 
      {
            return this.lines.get(index);
      }

      // private methods
      private void readFile() throws IOException 
      {
            String line = "";
            while((line = buffReader.readLine())!=null) {
                  this.lines.add(line);
            }
      }
}

class JsonObjectFinder
{
      /*
      * i represents each object in the JsonGroup.
      * the programm loops through all objects in the JsonGroup.
      * if the name of the Object equals the name the programm should search for
      * the loop ends and the object will be retruned
      */
      if(found == true)
      {
            break;
      }
      if(i.path.contentEquals(search))
      {
            result = i;
            this.found = true;
            System.out.println("found!");
            System.out.println(i);
            System.out.println(i.path);
            System.out.println("\"" + i.name + "\" : \"" + i.value + "\"");
      }
}
for (JsonGroup i : Json.subGroups) {
      if(found == true)
      {
            break;
      }
      /*
      * i represents each subgroup of the JsonGroup
      * the programm loops through all subgroups of the JsonGroup
      */
      JsonData data = this.LoopThroughSubGroups(i, search);
      if(data.path != "null")
      {
            result = data;
      }
}
if(result == null)
{
      result = new JsonData("null", "null", "null");
}
this.found = false;
return result;

class JsonGroupFinder
{
private JsonGroup Json = null;
private Boolean found = false;
protected JsonGroupFinder(JsonGroup mainJsonGroup)
{
this.Json = mainJsonGroup;
}

public JsonGroup getJsonObject(String JsonPath)
{
return this.LoopThroughSubGroups(this.Json, JsonPath);
}

private JsonGroup LoopThroughSubGroups(JsonGroup Json, String search)
{
JsonGroup result = null;
if(Json.path.contentEquals(search))
{
      this.found = true;
      result = Json;
}
for (JsonGroup i : Json.subGroups) {
      /*
      * i represents each object in the JsonGroup.
      * the programm loops through all objects in the JsonGroup.
      * if the name of the Object equals the name the programm should search for
      * the loop ends and the object will be retruned
      */
      if(found == true)
      {
            break;
      }
      if(i.path.contentEquals(search))
      {
            result = i;
            this.found = true;
            System.out.println("found!");
            System.out.println(i);package json;

            public class JsonData {
                  public String path = "";
                  public String value = "";
                  public String name = "";
            
                  public JsonData(String value, String name, String path) {
                        this.value = value;
                        this.name = name;
                        this.path = path;
                  }
            }
            System.out.println(i.path);
            System.out.println("\"" + i.name + "\"");
      }
      JsonGroup Group = this.LoopThroughSubGroups(i, search);
      if(Group.path != "null")
      {
            result = Group;
      }
}
if(result == null)
{
      result = new JsonGroup(null, "null", "null");
}
this.found = false;
return result;
}
}

      private JsonGroup Json = null;
      private Boolean found = false;
      protected JsonObjectFinder(JsonGroup mainJsonGroup)
      {
            this.Json = mainJsonGroup;
      }

      public JsonData getJsonObject(String JsonPath)
      {
            return this.LoopThroughSubGroups(this.Json, JsonPath);
      }

      private JsonData LoopThroughSubGroups(JsonGroup Json, String search)
      {
            JsonData result = null;
            for (JsonData i : Json.data) {
                  /*
                  * i represents each object in the JsonGroup.
                  * the programm loops through all objects in the JsonGroup.
                  * if the name of the Object equals the name the programm should search for
                  * the loop ends and the object will be retruned
                  */
                  if(found == true)
                  {
                        break;
                  }
                  if(i.path.contentEquals(search))
                  {
                        result = i;
                        this.found = true;
                        System.out.println("found!");
                        System.out.println(i);
                        System.out.println(i.path);
                        System.out.println("\"" + i.name + "\" : \"" + i.value + "\"");
                  }
            }
            for (JsonGroup i : Json.subGroups) {
                  if(found == true)
                  {
                        break;
                  }
                  /*
                  * i represents each subgroup of the JsonGroup
                  * the programm loops through all subgroups of the JsonGroup
                  */
                  JsonData data = this.LoopThroughSubGroups(i, search);
                  if(data.path != "null")
                  {
                        result = data;
                  }
            }
            if(result == null)
            {
                  result = new JsonData("null", "null", "null");
            }
            this.found = false;
            return result;
      }
class JsonGroupFinder
{
      private JsonGroup Json = null;
      private Boolean found = false;
      protected JsonGroupFinder(JsonGroup mainJsonGroup)
      {
            this.Json = mainJsonGroup;
      }

      public JsonGroup getJsonObject(String JsonPath)
      {
            return this.LoopThroughSubGroups(this.Json, JsonPath);
      }

      private JsonGroup LoopThroughSubGroups(JsonGroup Json, String search)
      {
            JsonGroup result = null;
            if(Json.path.contentEquals(search))
            {
                  this.found = true;
                  result = Json;
            }
            for (JsonGroup i : Json.subGroups) {
                  /*
                  * i represents each object in the JsonGroup.
                  * the programm loops through all objects in the JsonGroup.
                  * if the name of the Object equals the name the programm should search for
                  * the loop ends and the object will be retruned
                  */
                  if(found == true)
                  {
                        break;
                  }
                  if(i.path.contentEquals(search))
                  {
                        result = i;
                        this.found = true;
                        System.out.println("found!");
                        System.out.println(i);
                        System.out.println(i.path);
                        System.out.println("\"" + i.name + "\"");
                  }
                  JsonGroup Group = this.LoopThroughSubGroups(i, search);
                  if(Group.path != "null")
                  {
                        result = Group;
                  }
            }
            if(result == null)
            {
                  result = new JsonGroup(null, "null", "null");
            }
            this.found = false;
            return result;
      }
}
