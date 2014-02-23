/**
 * Copyright (c) 2011-2014, SpaceToad and the BuildCraft Team
 * http://www.mod-buildcraft.com
 *
 * BuildCraft is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 */
package buildcraft.energy;

import net.minecraft.block.Block;
import net.minecraftforge.common.util.ForgeDirection;
import buildcraft.api.blueprints.BptBlock;
import buildcraft.api.blueprints.BptSlotInfo;
import buildcraft.api.blueprints.IBptContext;

public class BptBlockEngine extends BptBlock {

	public BptBlockEngine(Block block) {
		super(block);
	}

	@Override
	public void rotateLeft(BptSlotInfo slot, IBptContext context) {
		int o = slot.cpt.getInteger("orientation");

		o = ForgeDirection.values()[o].getRotation(ForgeDirection.DOWN).ordinal();

		slot.cpt.setInteger("orientation", o);
	}

	@Override
	public void initializeFromWorld(BptSlotInfo bptSlot, IBptContext context, int x, int y, int z) {
		TileEngine engine = (TileEngine) context.world().getTileEntity(x, y, z);

		bptSlot.cpt.setInteger("orientation", engine.orientation.ordinal());
	}

	@Override
	public void buildBlock(BptSlotInfo slot, IBptContext context) {
		context.world().setBlock(slot.x, slot.y, slot.z, slot.block, slot.meta,1);

		TileEngine engine = (TileEngine) context.world().getTileEntity(slot.x, slot.y, slot.z);

		engine.orientation = ForgeDirection.getOrientation(slot.cpt.getInteger("orientation"));
	}

}
