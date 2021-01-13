package com.openkufo.myplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
	
	ConsoleCommandSender consol = Bukkit.getConsoleSender();
	
	@Override
	public void onEnable() {
		
		getServer().getPluginManager().registerEvents(new CreeperGuard(), this);
		
		consol.sendMessage( ChatColor.AQUA + "[플러그인 활성화 중 입니다.]");
		
	}
	
	@Override
	public void onDisable() {
		
		consol.sendMessage( ChatColor.AQUA + "[플러그인 비활성화 중 입니다.]");
		
	}
	
}