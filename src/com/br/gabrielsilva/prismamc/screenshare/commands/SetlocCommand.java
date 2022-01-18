package com.br.gabrielsilva.prismamc.screenshare.commands;

import org.bukkit.entity.Player;

import com.br.gabrielsilva.prismamc.commons.bukkit.commands.BukkitCommandSender;
import com.br.gabrielsilva.prismamc.commons.bukkit.manager.config.PluginConfig;
import com.br.gabrielsilva.prismamc.commons.core.command.CommandClass;
import com.br.gabrielsilva.prismamc.commons.core.command.CommandFramework.Command;
import com.br.gabrielsilva.prismamc.commons.core.group.Groups;
import com.br.gabrielsilva.prismamc.screenshare.ScreenShare;

public class SetlocCommand implements CommandClass {
	
	@Command(name = "setloc", groupsToUse= {Groups.DONO})
	public void setloc(BukkitCommandSender commandSender, String label, String[] args) {
		if (!commandSender.isPlayer()) {
			return;
		}
		
		if (args.length == 0) {
			commandSender.sendMessage("§cUse: /setloc spawn");
			return;
		}
		Player player = commandSender.getPlayer();
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("spawn")) {
				PluginConfig.putNewLoc(ScreenShare.getInstance(), "spawn", player);
				ScreenShare.setSpawn(PluginConfig.getNewLoc(ScreenShare.getInstance(), "spawn"));
				commandSender.sendMessage("§aSpawn setado!");
			} else {
				commandSender.sendMessage("§cUse: /setloc spawn");
			}
		} else {
			commandSender.sendMessage("§cUse: /setloc spawn");
		}
	}
}