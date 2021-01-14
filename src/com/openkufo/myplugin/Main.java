package com.openkufo.myplugin;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	ConsoleCommandSender consol = Bukkit.getConsoleSender();
	public boolean canSort;
	
	@Override
	public void onEnable() {
		
		consol.sendMessage( ChatColor.AQUA + "[플러그인 활성화 중 입니다.]");
		setFile();
		registerEvent();
		
		consol.sendMessage(Boolean.toString(canSort));
	}
	
	@Override
	public void onDisable() {
		
		consol.sendMessage( ChatColor.AQUA + "[플러그인 비활성화 중 입니다.]");
	}
	
	public void registerEvent() {
		
		getServer().getPluginManager().registerEvents(new CreeperGuard(), this);
	}
	
	public void setFile() {
		
		saveConfig();
		File cfile = new File(getDataFolder(), "config.yml");
		
		if (cfile.length() == 0) {
			getConfig().options().copyDefaults(true);
			saveConfig();
		}
		
		canSort = this.getConfig().getBoolean("canSort");
	}
	
}