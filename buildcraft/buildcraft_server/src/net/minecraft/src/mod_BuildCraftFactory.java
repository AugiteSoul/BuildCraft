/** 
 * BuildCraft is open-source. It is distributed under the terms of the 
 * BuildCraft Open Source License. It grants rights to read, modify, compile
 * or run the code. It does *NOT* grant the right to redistribute this software
 * or its modifications in any form, binary or source, except if expressively
 * granted by the copyright holder.
 */

package net.minecraft.src;

public class mod_BuildCraftFactory extends BaseModMp {		
	
	public static mod_BuildCraftFactory instance;
	
	public void ModsLoaded () {		
		super.ModsLoaded();
		
		BuildCraftFactory.initialize();
		
		instance = this;
	}
		
	@Override
	public String Version() {
		return "2.2.2";
	}
}
