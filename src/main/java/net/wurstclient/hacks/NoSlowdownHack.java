/*
 * Copyright (c) 2014-2022 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.hacks;

import net.wurstclient.Category;
import net.wurstclient.SearchTags;
import net.wurstclient.hack.Hack;
import net.wurstclient.settings.CheckboxSetting;

@SearchTags({"no slowdown", "no slow down"})
public final class NoSlowdownHack extends Hack
{
	private final CheckboxSetting noIce = new CheckboxSetting(
			"No ice", "Prevent ice slipperiness\n",
			false);

	private final CheckboxSetting honeyJump = new CheckboxSetting(
			"Honey jump", "Allow jumping on honey\n",
			true);

	private final CheckboxSetting slimeUtil = new CheckboxSetting(
			"Slime utiltiy", "Removes bouncing and disables slowdown\n"
					+ "\u00A74Don't disable this while on a slime block\u00A7r\n"
					+ "Slime still negates falldamage",
			false);

	public NoSlowdownHack()
	{
		super("NoSlowdown");
		setCategory(Category.MOVEMENT);
		addSetting(honeyJump);
		addSetting(noIce);
		addSetting(slimeUtil);
	}

	public boolean getNoIce()
	{
		return noIce.isChecked();
	}

	public boolean getHoneyJump()
	{
		return honeyJump.isChecked();
	}

	public boolean getSlimeUtil()
	{
		return slimeUtil.isChecked();
	}
	
	// See BlockMixin.onGetVelocityMultiplier() and
	// ClientPlayerEntityMixin.wurstIsUsingItem()
}
