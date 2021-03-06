package net.minecraft.src;

import eu.ha3.mc.convenience.Ha3Signal;
import eu.ha3.mc.haddon.PrivateAccessException;

/*
            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE 
                    Version 2, December 2004 

 Copyright (C) 2004 Sam Hocevar <sam@hocevar.net> 

 Everyone is permitted to copy and distribute verbatim or modified 
 copies of this license document, and changing it is allowed as long 
 as the name is changed. 

            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE 
   TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION 

  0. You just DO WHAT THE FUCK YOU WANT TO. 
*/

public class Ha3SoundThread extends Thread
{
	final int sleepTime = 500;
	
	private Ha3SoundCommunicator sndComm;
	private Ha3Signal onSuccess;
	private Ha3Signal onFailure;
	
	Ha3SoundThread(Ha3SoundCommunicator sndCommIn, Ha3Signal onSuccessIn, Ha3Signal onFailureIn)
	{
		setDaemon(true);
		
		this.sndComm = sndCommIn;
		this.onSuccess = onSuccessIn;
		this.onFailure = onFailureIn;
		
	}
	
	@Override
	public void run()
	{
		try
		{
			while (!this.sndComm.loadSoundManager())
			{
				sleep(this.sleepTime);
			}
			while (!this.sndComm.loadSoundSystem())
			{
				sleep(this.sleepTime);
			}
			if (this.onSuccess != null)
			{
				this.onSuccess.signal();
			}
			
		}
		catch (PrivateAccessException e)
		{
			e.printStackTrace();
			
			if (this.onFailure != null)
			{
				this.onFailure.signal();
			}
			
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
			
			if (this.onFailure != null)
			{
				this.onFailure.signal();
			}
			
		}
		
	}
	
}
