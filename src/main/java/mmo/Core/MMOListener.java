/*
 * This file is part of mmoMinecraft (https://github.com/mmoMinecraftDev).
 *
 * mmoMinecraft is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package mmo.Core;

import mmo.ChatAPI.MMOChatEvent;
import mmo.SkillsAPI.MMOSkillEvent;
import mmo.DamageAPI.MMODamageEvent;
import mmo.InfoAPI.MMOInfoEvent;
import org.bukkit.event.CustomEventListener;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;

public class MMOListener extends CustomEventListener implements Listener {

	public MMOListener() {
	}

	public void onMMOChat(MMOChatEvent event) {
	}

	public void onMMOPVPDamage(MMODamageEvent event) {
	}

	public void onMMOPVEDamage(MMODamageEvent event) {
	}

	public void onMMOEVEDamage(MMODamageEvent event) {
	}

	public void onMMOInfo(MMOInfoEvent event) {
	}

	public void onMMOHUD(MMOHUDEvent event) {
	}

	public void onMMOSkill(MMOSkillEvent event) {
	}

	@Override
	public void onCustomEvent(Event event) {
		if (event instanceof MMOHUDEvent) {
			onMMOHUD((MMOHUDEvent) event);
		} else if (MMO.mmoChatAPI && event instanceof MMOChatEvent) {
			onMMOChat((MMOChatEvent) event);
		} else if (MMO.mmoInfoAPI && event instanceof MMOInfoEvent) {
			onMMOInfo((MMOInfoEvent) event);
		} else if (MMO.mmoSkillAPI && event instanceof MMOSkillEvent) {
			onMMOSkill((MMOSkillEvent) event);
		} else if (MMO.mmoDamageAPI && event instanceof MMODamageEvent) {
			switch (((MMODamageEvent) event).getDamageType()) {
				case PVE:
					onMMOPVEDamage(((MMODamageEvent) event));
					break;
				case PVP:
					onMMOPVPDamage(((MMODamageEvent) event));
					break;
				case EVE:
					onMMOEVEDamage(((MMODamageEvent) event));
					break;
			}
		}
	}
}
