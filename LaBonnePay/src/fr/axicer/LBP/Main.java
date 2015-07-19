package fr.axicer.LBP;

import java.util.HashMap;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	private static HashMap<String, Integer> commandPrice = new HashMap<String, Integer>();
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new CommandListener(), this);
		
		saveDefaultConfig();
		
		try{
			for(String compiled : getConfig().getStringList("prix")){
				HashMap<String, Integer> decompiled = decompileStrinf(compiled);
				for(String command: decompiled.keySet()){
					commandPrice.put(command, decompiled.get(command));
				}
			}
		}catch(Exception e){e.printStackTrace();}//ich liebe inline
		
		
		Vault.setupChat(this);
		Vault.setupEconomy(this);
		Vault.setupPermissions(this);
		
		getLogger().info("Plugin ON");
		getLogger().info("Plugin by Axicer_");
	}
	@Override
	public void onDisable() {
		getLogger().info("Plugin OFF");
	}
	
	public static HashMap<String, Integer> getCommandPrice(){
		return commandPrice;
	}
	
	public HashMap<String, Integer> decompileStrinf(String compiled){
		try{
			HashMap<String , Integer> command = new HashMap<String, Integer>();
			String[] stringTable = compiled.split(",");
			command.put(stringTable[0], Integer.valueOf(stringTable[1]));
			return command;
		}catch(Exception e){e.printStackTrace();}//c tres l'inline
		return null;
	}
}
