package com.splitlevelgaming.tinysheriff;

import java.util.ArrayList;

public class TimerController{

  ArrayList<Timer> activeTimers;

  TimerController(){
    activeTimers = new ArrayList<Timer>();
  }

  public void setTimer(Prop parent, String code, int setTime){
    activeTimers.add(new Timer(parent, code, setTime));
  }
  public void startStep(){
    for(int i = 0; i < activeTimers; i++){
      if(!activeTimers.get(i).isTicking()){
        activeTimers.remove(i);
        i--;
      }
    }
  }

  public void endStep(){
    for(int i = 0; i < activeTimers; i++){
      if(!activeTimers.get(i).isTicking()){
        activeTimers.remove(i);
        i--;
      }
    }
  }

}
