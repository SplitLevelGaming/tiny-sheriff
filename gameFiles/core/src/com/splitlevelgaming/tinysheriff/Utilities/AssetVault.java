package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.utils.Disposable;
import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;


public class AssetVault <T extends Disposable> {

private Hashtable<String, T> assets;

public AssetVault(ArrayList<String> extensions, Factory<T> factory, String startingFolder){
  ArrayList<String> directories = pullDirectoriesFromFolder(startingFolder, extensions);
  assets = generateFromDirectories(directories, factory);
}

public AssetVault(ArrayList<String> extensions, Factory<T> factory){
  this(extensions, factory, "./");
}

public T getAsset(String assetReference){
  return assets.get(assetReference);
}

private ArrayList<String> pullDirectoriesFromFolder(String folderName, ArrayList<String> extensions){
  File folder = new File(folderName);
  File[] listOfFiles = folder.listFiles();
  ArrayList<String> retVal = new ArrayList<String>();
  for(int i=0; i<listOfFiles.length; i++){
    boolean matchesExtensions = false;
    for(int j = 0; !matchesExtensions && j < extensions.size(); j++){
      if(listOfFiles[i].getName().endsWith(extensions.get(j)) && listOfFiles[i].isFile()){
        matchesExtensions = true;
      }
    }
    if(matchesExtensions){
      System.out.println("Adding:" + folderName + listOfFiles[i].getName());
      retVal.add(folderName + listOfFiles[i].getName());
    }
    else{
      if(listOfFiles[i].isDirectory()){
        ArrayList<String> deeperFiles = pullDirectoriesFromFolder(folderName + listOfFiles[i].getName() + "/", extensions);
        for(int j = 0; j < deeperFiles.size(); j++){
          retVal.add(deeperFiles.get(j));
        }
      }
    }
  }
  return retVal;
}

private Hashtable<String, T> generateFromDirectories(ArrayList<String> directories, Factory<T> factory){
  Hashtable<String, T> newAssets = new Hashtable<String, T>();
  for(int i=0; i<directories.size(); i++){
    T vaultInput = factory.buildOne(directories.get(i));
    String filename = cleanFileName(directories.get(i));
    newAssets.put(filename, vaultInput);
  }
  return newAssets;
}

private String cleanFileName(String filename){
  int cut = filename.indexOf("/");
  while(cut  > -1){
    filename = filename.substring(cut + 1);
    cut = filename.indexOf("/");
  }
  filename = filename.substring(0, filename.length() - 4);
  return filename;
}

public void dispose(){
  String disposableKeys[] = new String[0];
  disposableKeys = assets.keySet().toArray(disposableKeys);
  for(int i = 0; i < disposableKeys.length; i++){
    assets.get(disposableKeys[i]).dispose();
  }
}

}
