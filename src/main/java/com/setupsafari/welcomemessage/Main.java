package com.setupsafari.welcomemessage;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import com.setupsafari.welcomemessage.commands.RootCommand;
import com.setupsafari.welcomemessage.listeners.PlayerJoinListener;
import com.setupsafari.welcomemessage.tasks.Task;

public class Main extends JavaPlugin {
    
    @Override
    public void onEnable () {
        this.saveDefaultConfig();
	    
        this.getCommand("rootcommand").setExecutor(new RootCommand());
        
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);

        final long taskRepeatEvery = this.getConfig().getInt("task-repeat-every") * 20L;
        BukkitTask task = new Task().runTaskLater(this, taskRepeatEvery);
	    
	// This is a regular Runnable example just in case I have a use for it,
	// though I'm not making a Runnable example file
	Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
			public void run() {
				//remove the block placed.
				System.out.println("start message XD");
			}
		}, 20L * 2L * 3l);
    }

    private static Main instance;

    public static Main getInstance () {
        return Main.instance;
    }
}