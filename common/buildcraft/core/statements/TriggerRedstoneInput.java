/**
 * Copyright (c) 2011-2014, SpaceToad and the BuildCraft Team
 * http://www.mod-buildcraft.com
 *
 * BuildCraft is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 */
package buildcraft.core.statements;

import buildcraft.api.gates.IGate;
import buildcraft.api.gates.ITriggerParameter;
import buildcraft.core.utils.StringUtils;
import buildcraft.transport.TileGenericPipe;

public class TriggerRedstoneInput extends BCTrigger {

	boolean active;

	public TriggerRedstoneInput(boolean active) {
		super("buildcraft:redstone.input." + (active ? "active" : "inactive"), active ? "buildcraft.redtone.input.active" : "buildcraft.redtone.input.inactive");
		this.active = active;
	}

	@Override
	public String getDescription() {
		return StringUtils.localize("gate.trigger.redstone.input." + (active ? "active" : "inactive"));
	}

	@Override
	public boolean isTriggerActive(IGate gate, ITriggerParameter[] parameters) {
		TileGenericPipe tile = (TileGenericPipe) gate.getPipe().getTile();
		//int level = tile.redstoneInputSide[gate.getSide().ordinal()];
		int level = tile.redstoneInput;
		
		return active ? level > 0 : level == 0;
	}

	@Override
	public int getIconIndex() {
		return active ? StatementIconProvider.Trigger_RedstoneInput_Active : StatementIconProvider.Trigger_RedstoneInput_Inactive;
	}
}
