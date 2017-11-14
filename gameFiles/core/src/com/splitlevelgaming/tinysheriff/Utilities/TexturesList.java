package com.splitlevelgaming.tinysheriff;

import java.io.File;
import java.util.ArrayList;

public class TexturesList{

  ArrayList<String> textureList;

  TexturesList(){
    pullFilesFromFolder("./");
  }

  private void pullFilesFromFolder(String folderName){
    System.out.println(folderName);
    File folder = new File(folderName);
    File[] listOfFiles = folder.listFiles();
    textureList = new ArrayList<String>();
    for(int i=0; i<listOfFiles.length; i++){
      if(listOfFiles[i].getName().endsWith(".png") || listOfFiles[i].getName().endsWith(".jpg"))
        textureList.add(folderName + listOfFiles[i].getName());
      else
        pullFilesFromFolder(folderName + listOfFiles[i].getName() + "/");
    }
  }

  public ArrayList<String> getTextures(){
    return textureList;
  }

}
