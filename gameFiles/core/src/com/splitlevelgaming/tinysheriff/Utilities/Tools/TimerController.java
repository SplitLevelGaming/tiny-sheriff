package com.splitlevelgaming.tinysheriff;

import java.util.ArrayList;

public class TimerController implements PhysicalReferencer{

  ArrayList<Timer> activeTimers;

  TimerController(){
    activeTimers = new ArrayList<Timer>();
  }

  public void setTimer(Physical parent, String code, int setTime){
    activeTimers.add(new Timer(parent, code, setTime));
  }

public void removePhysicalReferences(Physical physical){
  for(int i = 0; i < activeTimers.size(); i++){
    if(activeTimers.get(i).hasParent(physical)){
      activeTimers.remove(i);
    }
  }
}

  public void startStep(){
    for(int i = 0; i < activeTimers.size(); i++){
      activeTimers.get(i).decrementTime();
    }
  }

  public void endStep(){
    for(int i = 0; i < activeTimers.size(); i++){
      if(!activeTimers.get(i).isTicking()){
        activeTimers.remove(i);
        i--;
      }
    }
  }

}
