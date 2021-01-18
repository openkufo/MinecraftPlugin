package com.openkufo.myplugin;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.openkufo.myplugin.command.Commands;

public class Main extends JavaPlugin {
	
	ConsoleCommandSender consol = Bukkit.getConsoleSender();
	public static boolean isSortable;
	
	@Override
	public void onEnable() {
		consol.sendMessage( ChatColor.AQUA + "[플러그인 활성화 중 입니다.]");
		
		setFile();
		setCommand();
		setEvent();
	}
	
	@Override
	public void onDisable() {
		consol.sendMessage( ChatColor.AQUA + "[플러그인 비활성화 중 입니다.]");
	}
	
	public void setFile() {
		saveConfig();
		File cfile = new File(getDataFolder(), "config.yml");
		
		if (cfile.length() == 0) {
			getConfig().options().copyDefaults(true);
			saveConfig();
		}
		
		isSortable = this.getConfig().getBoolean("isSortable");
	}
	
	public void setCommand() {
		getCommand("set").setExecutor(new Commands());
		getCommand("set").setTabCompleter(new Commands());
	}
	
	public void setEvent() {
		getServer().getPluginManager().registerEvents(new CreeperGuard(), this);
		getServer().getPluginManager().registerEvents(new SortChest(), this);
	}
	
}