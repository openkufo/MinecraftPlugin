package com.openkufo.myplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class CreeperGuard implements Listener {
	
	@EventHandler
	public void onExplode(EntityExplodeEvent event) {
		if (event.getEntityType().equals(EntityType.CREEPER)) {
			Bukkit.getPlayer("openkufo").sendMessage("크리퍼 폭발");
			event.setCancelled(true);
		}
		if (event.getEntityType() == EntityType.CREEPER) {
			Bukkit.getPlayer("openkufo").sendMessage("크리퍼 폭발2");
			cs("이것도 맞음");
		}
	}
	
	public void cs(String msg) {
		ConsoleCommandSender console = Bukkit.getConsoleSender();
		console.sendMessage(msg);
	}
}
