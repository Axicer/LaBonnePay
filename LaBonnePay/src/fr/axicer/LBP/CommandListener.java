package fr.axicer.LBP;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener{
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void CommandPreProcess(PlayerCommandPreprocessEvent ev){
		Player p = ev.getPlayer();
		if(Main.getCommandPrice().containsKey(ev.getMessage())){
			if(Vault.getEconomy().getBalance(p) >= Main.getCommandPrice().get(ev.getMessage())){
				Vault.getEconomy().withdrawPlayer(p, Main.getCommandPrice().get(ev.getMessage()));
				p.sendMessage(ChatColor.GREEN+"-"+Main.getCommandPrice().get(ev.getMessage()));
			}else{
				p.sendMessage(ChatColor.RED+"Tu n'as pas assez d'argent !");
				p.sendMessage("La commande coute: "+Main.getCommandPrice().get(ev.getMessage())+"$");
				ev.setCancelled(true);
			}
		}
	}
}
