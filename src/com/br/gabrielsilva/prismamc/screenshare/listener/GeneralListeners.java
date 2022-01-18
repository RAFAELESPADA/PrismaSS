package com.br.gabrielsilva.prismamc.screenshare.listener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import com.br.gabrielsilva.prismamc.commons.bukkit.custom.events.ScoreboardChangeEvent;
import com.br.gabrielsilva.prismamc.commons.bukkit.custom.events.ScoreboardChangeEvent.ChangeType;
import com.br.gabrielsilva.prismamc.screenshare.ScreenShare;
import com.br.gabrielsilva.prismamc.screenshare.scoreboard.ScoreboardManager;

public class GeneralListeners implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		player.teleport(ScreenShare.getSpawn());
		
		if (!player.getGameMode().equals(GameMode.ADVENTURE)) {
		    player.setGameMode(GameMode.ADVENTURE);
		}
		
		ScoreboardManager.setScoreboard(player, 
				player.hasPermission("prismamc.staff"));
	}
	
	@EventHandler
	public void onChangeScoreboard(ScoreboardChangeEvent event) {
		if (event.getChangeType() == ChangeType.DESATIVOU) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void spread(BlockSpreadEvent event) {
		event.setCancelled(true);
	}
	
	@EventHandler
	public void onFood(FoodLevelChangeEvent event) {
		event.setCancelled(true);
	}
	
	@EventHandler
	public void onChuva(WeatherChangeEvent event) {
		if (event.toWeatherState()) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		event.setCancelled(true);
		if (event.getCause().equals(DamageCause.VOID)) {
			event.getEntity().teleport(ScreenShare.getSpawn());
		}
	}
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event) {
		event.setCancelled(true);
	}
	
	@EventHandler
	public void ignite(BlockIgniteEvent event) {
		event.setCancelled(true);
	}
	
	@EventHandler
	public void onEntitySpawn(CreatureSpawnEvent event) {
		event.setCancelled(true);
	}
	
	@EventHandler
	public void drop(PlayerDropItemEvent event) {
		event.setCancelled(true);
	}
	
	@EventHandler
	public void pickup(PlayerPickupItemEvent event) {
		event.setCancelled(true);
	}
	
	@EventHandler
	public void spawn(ItemSpawnEvent event) {
		event.setCancelled(true);
	}
	
	@EventHandler(priority=EventPriority.LOWEST)
	public void onBreak(BlockBreakEvent event) {
		event.setCancelled(true);
	}
	
	@EventHandler
	public void Interact(PlayerInteractEvent event) {
		event.setCancelled(true);
	}
	
	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		event.setBuild(true);
	}
}