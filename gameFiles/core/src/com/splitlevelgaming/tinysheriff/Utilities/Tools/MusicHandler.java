package com.splitlevelgaming.tinysheriff;

import com.badlogic.gdx.audio.*;
import java.util.ArrayList;
import java.util.Hashtable;
import com.badlogic.gdx.Gdx;

public class MusicHandler{

  private Music activeSong;
  private Hashtable<String, String> directoryKeyTable;

  MusicHandler(){
    DirectoryManager directoryManager = new DirectoryManager();
    ArrayList<String> extensions = new ArrayList<String>();
    extensions.add(".mp3");
    directoryKeyTable = directoryManager.createDirectoryHash("./music/", extensions);
  }

  public void dispose(){

  }

  public void playMusic(String music){
    stopMusic();
    activeSong = Gdx.audio.newMusic(Gdx.files.internal(directoryKeyTable.get(music)));
    activeSong.setLooping(true);
    activeSong.play();
  }

  public void pause(){
    activeSong.pause();
  }

  public void stopMusic(){
    if(activeSong != null){
      activeSong.dispose();
    }
  }

}
