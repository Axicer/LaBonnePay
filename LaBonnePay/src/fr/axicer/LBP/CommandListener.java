package fr.axicer.LBP;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener{
	
	Main pl;
	
	public CommandListener(Main pl) {
		this.pl = pl;
	}
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void CommandPreProcess(PlayerCommandPreprocessEvent ev){
		Player p = ev.getPlayer();
		
	}
}
