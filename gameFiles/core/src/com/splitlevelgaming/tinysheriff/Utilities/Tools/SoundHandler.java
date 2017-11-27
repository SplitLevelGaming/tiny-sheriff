package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.audio.*;
import java.util.ArrayList;
import java.util.Hashtable;
import com.badlogic.gdx.Gdx;

public class SoundHandler{

  Hashtable<String, Sound> playingSounds = new Hashtable<String, Sound>();
  Hashtable<String, String> directoryKeyTable;

  SoundHandler(){
      DirectoryManager directoryManager = new DirectoryManager();
      ArrayList<String> extensions = new ArrayList<String>();
      extensions.add(".mp3");
      directoryKeyTable = directoryManager.createDirectoryHash("./sounds/", extensions);
  }

  public void playSound(String sound){
    String[] keys = new String[0];
		keys = playingSounds.keySet().toArray(keys);
		for(int i = 0; i < keys.length; i++){
			if(keys[i].equals(sound)){
				playingSounds.get(keys[i]).play();
			}
		}
    //Not playing
    Sound newSound = Gdx.audio.newSound(Gdx.files.internal(directoryKeyTable.get(sound)));
    newSound.play();
    playingSounds.put(sound, newSound);
  }

  public void dispose(){
    String[] keys = new String[0];
		keys = playingSounds.keySet().toArray(keys);
		for(int i = 0; i < keys.length; i++){
			playingSounds.get(keys[i]).dispose();
		}
  }
}
