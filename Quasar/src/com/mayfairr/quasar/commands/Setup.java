package com.mayfairr.quasar.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

import com.mayfairr.quasar.Quasar;

public class Setup implements CommandExecutor {
	
	private Quasar plugin; 
	private PluginDescriptionFile  descriptionFile;
	
	public Setup(Quasar plugin) {
		this.plugin = plugin;
		this.descriptionFile = plugin.getDescription();
		plugin.getCommand("setup").setExecutor(this);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("Only players can send this command");
		}
		Player p = (Player) sender;
		if(p.hasPermission("quasar.setup")) {
			p.sendMessage(String.format("Welcome to §5§l%s§f§r, §5§l%s, §f§rcreated by §5§lMayfairr", this.descriptionFile.getName(), this.descriptionFile.getVersion()) );
			p.sendMessage("You can configure this plugin by modyifying the Config.json file in the server/plugins/Quasar/config.yml");
			return true;
		}else {
			p.sendMessage("You do not have the permission to access this command!");
		}
		
		return false;
	}
	
}
