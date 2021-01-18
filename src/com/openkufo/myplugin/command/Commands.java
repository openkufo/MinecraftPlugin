package com.openkufo.myplugin.command;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import com.openkufo.myplugin.Main;

public class Commands implements TabExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command object, String command, String[] chat) {
		boolean isSet = command.equalsIgnoreCase("set");
		boolean hasChat = chat.length > 0;
		if (isSet && hasChat) {
			if(chat[0].equalsIgnoreCase("sortable")) {
				setSortable(sender);
			}
		} else {
			sender.sendMessage("/set <Command> 형식으로 입력하세요!");
		}

		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command object, String command, String[] chat) {
		boolean isSet = command.equalsIgnoreCase("set");
		if (isSet) {
			if(chat.length == 1) {
				return Arrays.asList("Sortable");
			}
		}
		return null;
	}

	private void setSortable(CommandSender sender) {
		Main.isSortable = !Main.isSortable;
		sender.sendMessage("Sortable : " + Boolean.toString(Main.isSortable));
	}
}
