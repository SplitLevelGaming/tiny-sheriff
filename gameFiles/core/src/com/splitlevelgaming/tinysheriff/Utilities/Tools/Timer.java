package com.splitlevelgaming.tinysheriff;

import java.util.Hashtable;

public class Timer{

  private Prop parent;
  private String code;
  //timeLeft is measured in frames. So, if time left==5, the timer will terminate in 5 frames, or 5/60 secs.
  private int timeLeft;

  Timer(Prop parent, String code, int setTime){
    this.parent = parent;
    this.code = code;
    this.timeLeft = setTime;
  }

  public void decrementTime(){
    timeLeft--;
    if(timeLeft == 0){
      notifyParent();
    }
  }

  public boolean isTicking(){
    return timeLeft > 0;
  }

  private void notifyParent(){
    parent.timerEnd(code);
  }

}
