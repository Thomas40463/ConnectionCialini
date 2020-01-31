package server;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author informatica
 */
public class CountDown implements Runnable{
	private int time;
	private boolean flag;
	
	public CountDown(int time) {
		this.time=time;
		this.flag=false;
	}

	public void run() {
		int i=time-1;
		while(i>0 && flag==false){
			try {
				Thread.sleep(1000);
				System.out.println("Mancano " +i +" secondi");
				i--;
				
			} catch (InterruptedException ex) {
				Logger.getLogger(CountDown.class.getName()).log(Level.SEVERE, null, ex);
			}
		
			
			
		}
	}
	
	public void setFlag(){
		this.flag=true;
		
	}
	
}
