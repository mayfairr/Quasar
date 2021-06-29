package com.mayfairr.quasar;

import org.bukkit.plugin.java.JavaPlugin;

import com.mayfairr.quasar.commands.Setup;

public class Quasar extends JavaPlugin {
	
	@Override
	public void onEnable() {
		new Setup(this);
		loadConfig();
	}
	
	
	public void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
}