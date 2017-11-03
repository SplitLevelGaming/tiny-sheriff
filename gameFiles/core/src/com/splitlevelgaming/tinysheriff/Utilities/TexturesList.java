package com.splitlevelgaming.tinysheriff;

import java.io.File;

public class TexturesList{

  String textureList[];

  TexturesList(){
    initializeTextureList();
  }

  private void initializeTextureList(){
    File folder = new File("./");
    File[] listOfFiles = folder.listFiles();
    String[] newTextureList = new String[listOfFiles.length];
    for(int i=0; i<newTextureList.length; i++){
      newTextureList[i] = listOfFiles[i].getName();
    }
    textureList = newTextureList;
  }

  public String[] getTextures(){
    return textureList;
  }

}
