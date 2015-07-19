package fr.axicer.LBP;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new CommandListener(this), this);
		getLogger().info("Plugin ON");
		getLogger().info("Plugin by Axicer_");
	}
	@Override
	public void onDisable() {
		getLogger().info("Plugin OFF");
	}
}
