package net.minecraft.src;

/*
* ----------------------------------------------------------------------------
* "THE COLA-WARE LICENSE" (Revision 0):
* Hurricaaane wrote this file. As long as you retain this notice you
* can do whatever you want with this stuff. If we meet some day, and you think
* this stuff is worth it, you can buy me a cola in return
* Georges "Hurricaaane" Yam
* ----------------------------------------------------------------------------
*/

public interface MAtScanCoordsOps
{
	void begin();
	
	void finish();
	
	void input(long x, long y, long z);
	
}