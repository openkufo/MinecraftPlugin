package com.openkufo.myplugin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SortChest implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		boolean isAir = !event.hasBlock() && !event.hasItem();
		if (isAir) {
			return;
		}
	}

	@EventHandler
	public void onInventoryOpen(InventoryOpenEvent event) {
		boolean isChest = event.getInventory().getType() == InventoryType.CHEST;
		if (!isChest) {
			return;
		}

		if (Main.isSortable) {
			Inventory inventory = event.getInventory();

			List<ItemStack> itemList = new ArrayList<ItemStack>();

			for (ItemStack itemStack : inventory.getContents()) {
				if (itemStack != null) {
					itemList.add(itemStack);
				}
			}

			inventory.clear();

			sortChest(itemList);

			for (ItemStack itemStack : itemList) {
				inventory.addItem(itemStack);
			}
		}

	}

	public void sortChest(List<ItemStack> itemList) {
		Collections.sort(itemList, new Comparator<ItemStack>() {
			@Override
			public int compare(ItemStack item1, ItemStack item2) {
				return item1.getType().compareTo(item2.getType());
			}
		});
	}

	public void cs(String s) {
		Bukkit.getConsoleSender().sendMessage(s);
	}
}
