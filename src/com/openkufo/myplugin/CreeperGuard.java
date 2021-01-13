package com.openkufo.myplugin;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class CreeperGuard implements Listener {
	
	@EventHandler
	public void onExplode(EntityExplodeEvent event) {
		
		if (event.getEntityType() == EntityType.CREEPER) {
			event.setCancelled(true);
		}
		
	}
}
