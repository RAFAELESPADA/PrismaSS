package com.br.gabrielsilva.prismamc.screenshare.scoreboard;

import org.bukkit.entity.Player;

import com.br.gabrielsilva.prismamc.commons.bukkit.BukkitMain;
import com.br.gabrielsilva.prismamc.commons.bukkit.account.BukkitPlayer;
import com.br.gabrielsilva.prismamc.commons.bukkit.api.scoreboard.Sidebar;

public class ScoreboardManager {
	
	public static void setScoreboard(Player player, boolean staff) {
		if (staff) {
			applyStaff(player);
		} else {
			applyPlayer(player);
		}
	}
	
	private static void applyPlayer(Player player) {
		BukkitPlayer bukkitPlayer = BukkitMain.getManager().getDataManager().getBukkitPlayer(player.getUniqueId());
		
		Sidebar sideBar = bukkitPlayer.getSideBar();
		if (sideBar == null) {
			bukkitPlayer.setSideBar(sideBar = new Sidebar(player.getScoreboard()));
			sideBar.show();
		}
		if (sideBar.isHided())
			return;
		
		sideBar.hide();
		sideBar.show();
	
		sideBar.setTitle("§6§lKOMBO§f§lPVP");
		sideBar.setText(9, "");
        sideBar.setText(8, "§cVocê foi puxado para");
        sideBar.setText(7, "§cScreenShare, siga todos os");
        sideBar.setText(6, "§cPassos pedidos pelo staffer");
        sideBar.setText(5, "");
        sideBar.setText(4, "§cNão deslogue do servidor");
        sideBar.setText(3, "§cou você será banido!");
		sideBar.setText(2, "");
		sideBar.setText(1, "§ekombopvp.net");
	}
	
	private static void applyStaff(Player player) {
		BukkitPlayer bukkitPlayer = BukkitMain.getManager().getDataManager().getBukkitPlayer(player.getUniqueId());
		
		Sidebar sideBar = bukkitPlayer.getSideBar();
		if (sideBar == null) {
			bukkitPlayer.setSideBar(sideBar = new Sidebar(player.getScoreboard()));
			sideBar.show();
		}
		if (sideBar.isHided())
			return;
		
		sideBar.hide();
		sideBar.show();
	
		sideBar.setTitle("§6§lKOMBO§f§lPVP");
		sideBar.setText(7, "");
        sideBar.setText(6, "§cVoc§ puxou um jogador para");
        sideBar.setText(5, "§cscreenshare, realize todos");
        sideBar.setText(4, "§cos procedimentos e n§o deslogue");
        sideBar.setText(3, "§cantes de finalizar a screenshare");
		sideBar.setText(2, "");
		sideBar.setText(1, "§bkombopvp.net");
	}
}