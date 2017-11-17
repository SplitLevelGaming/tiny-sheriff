package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.graphics.Texture;
import java.util.Hashtable;
import java.util.ArrayList;
import java.io.File;

public class TextureVault{

  private Hashtable<String, Texture> textures;

  TextureVault(){
    textures = createTextures();
  }

  public Texture getTexture(String textureName){
    return textures.get(textureName);
  }

  private Hashtable<String, Texture> createTextures(){
    Hashtable<String, Texture> newTextures = new Hashtable<String, Texture>();
    ArrayList<String> texturesStrings = pullTexturesFromFolder("./");
    for(int i=0; i<texturesStrings.size(); i++){
      Texture vaultInput = new Texture(texturesStrings.get(i));
      String filename = cleanTextureFileName(texturesStrings.get(i));
      newTextures.put(filename, vaultInput);
    }
    return newTextures;
  }

  private ArrayList<String> pullTexturesFromFolder(String folderName){
    File folder = new File(folderName);
    File[] listOfFiles = folder.listFiles();
    ArrayList<String> retVal = new ArrayList<String>();
    for(int i=0; i<listOfFiles.length; i++){
      if(listOfFiles[i].getName().endsWith(".png") || listOfFiles[i].getName().endsWith(".jpg")){
        retVal.add(folderName + listOfFiles[i].getName());
      }
      else{
        ArrayList<String> deeperFiles = pullTexturesFromFolder(folderName + listOfFiles[i].getName() + "/");
        for(int j = 0; j < deeperFiles.size(); j++){
          retVal.add(deeperFiles.get(j));
        }
      }
    }
    return retVal;
  }

  private String cleanTextureFileName(String filename){
    int cut = filename.indexOf("/");
    while(cut  > -1){
      filename = filename.substring(cut + 1);
      cut = filename.indexOf("/");
    }
    filename = filename.substring(0, filename.length() - 4);
    return filename;
  }

  public void dispose(){
    Texture disposables[] = new Texture[0];
    disposables = textures.values().toArray(disposables);
    for(int i = 0; i < disposables.length; i++){
      disposables[i].dispose();
    }
  }

}
