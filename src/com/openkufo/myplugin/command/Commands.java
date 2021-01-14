package com.openkufo.myplugin.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import com.openkufo.myplugin.Main;

public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command object, String command, String[] chat) {
		switch (command.toLowerCase()) {
			case "cansort": canSort(sender, chat); break;
			default: return false;
		}
		
		return false;
	}

	private void canSort(CommandSender sender, String[] chat) {
		String msg = "/canSort { true | false } 형식으로 입력하세요!";
		
		if (chat.length != 1) {
			sender.sendMessage(msg);
			return;
		}
		
		switch (chat[0].toLowerCase()) {
		case "true":
		case "t": 
			Main.canSort = true;
			break;
			
		case "false":
		case "f":
			Main.canSort = false;
			break;
			
		default: sender.sendMessage(msg);
		}
		
		sender.sendMessage("canSort : " + Main.canSort);
	}
	
}
