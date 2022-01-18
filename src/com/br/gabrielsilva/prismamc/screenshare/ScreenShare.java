package com.br.gabrielsilva.prismamc.screenshare;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import com.br.gabrielsilva.prismamc.commons.bukkit.commands.BukkitCommandFramework;
import com.br.gabrielsilva.prismamc.commons.bukkit.manager.config.PluginConfig;
import com.br.gabrielsilva.prismamc.commons.core.utils.loaders.CommandLoader;
import com.br.gabrielsilva.prismamc.commons.core.utils.loaders.ListenerLoader;

import lombok.Getter;
import lombok.Setter;

public class ScreenShare extends JavaPlugin {

	@Getter @Setter
	private static ScreenShare instance;
	
	@Getter @Setter
	public static Location spawn;
	
	public void onLoad() {
		setInstance(this);
		saveDefaultConfig();
	}
	
	public void onEnable() {
		PluginConfig.createLoc(getInstance(), "spawn");
		
		setSpawn(PluginConfig.getNewLoc(getInstance(), "spawn"));
		
		ListenerLoader.loadListenersBukkit(getInstance(), "com.br.gabrielsilva.prismamc.screenshare.listener");
		
		new CommandLoader(new BukkitCommandFramework(getInstance())).
		loadCommandsFromPackage("com.br.gabrielsilva.prismamc.screenshare.commands");
	}
	
	public static void console(String msg) {
		Bukkit.getConsoleSender().sendMessage("[ScreenShare] " + msg);
	}
	
	public static void runAsync(Runnable runnable) {
		Bukkit.getScheduler().runTaskAsynchronously(instance, runnable);	
	}
	
	public static void runLater(Runnable runnable) {
		Bukkit.getScheduler().runTaskLater(instance, runnable, 5L);	
	}
	
	public static void runLater(Runnable runnable, long ticks) {
		Bukkit.getScheduler().runTaskLater(instance, runnable, ticks);	
	}
}