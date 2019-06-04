package com.company;
import java.io.*;
import java.util.*;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;

public class Mode {
   private File source;

   public Mode(File f) {
      source = f;
   }

   public File getSource() {
      return source;
   }

   public void loadData() {
      //TODO
   }

   @Override public String toString() {
      if (source == null) return "Mode loaded from: Null";
      return "Mode loaded from: "+ source.toString();
   }
}
