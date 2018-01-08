package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.utils.Disposable;
import java.util.ArrayList;
import java.io.File;
import java.util.Hashtable;

public class DirectoryManager{
  public ArrayList<String> pullDirectoriesFromFolder(String folderName, ArrayList<String> extensions){
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

  public String cleanFileName(String filename){
    int cut = filename.indexOf("/");
    while(cut  > -1){
      filename = filename.substring(cut + 1);
      cut = filename.indexOf("/");
    }
    filename = filename.substring(0, filename.length() - 4);
    return filename;
  }

  public Hashtable<String, String> createDirectoryHash(String startingDirectory, ArrayList<String> fileExtensions){
    Hashtable<String, String> retVal = new Hashtable<String, String>();
    ArrayList<String> directories = pullDirectoriesFromFolder(startingDirectory, fileExtensions);
		for(int i = 0; i < directories.size(); i++){
			retVal.put(cleanFileName(directories.get(i)), directories.get(i));
		}
    return retVal;
  }
}
