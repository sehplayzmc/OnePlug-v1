package me.seth.oneplug.main;

import me.seth.oneplug.commands.CommandXp;
import me.seth.oneplug.commands.Commandheal;
import me.seth.oneplug.commands.Commandversion;
import me.seth.oneplug.events.BanWord;
import me.seth.oneplug.utils.Version;
import me.seth.oneplug.utils.pManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Oneplug extends JavaPlugin {

    public Oneplug plugin;
    private pManager pM;

    @Override
    public void onEnable() {
        onLoad();
        registerCommands();
        registerEvents();
//        pM.mConsole(this, "OnePlug is Enabled, Version: " + Version.Snapshot);
    }

    private void registerCommands() {
        this.getCommand("heal").setExecutor(new Commandheal());
        this.getCommand("xp").setExecutor(new CommandXp());

    }


    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new BanWord(this), this);
        this.getServer().getPluginManager().registerEvents(new EventGift(), this);
    }

    @Override
    public void onDisable() {
/*
        pM.mConsole(this, ChatColor.RED + "OnePlug: is Disabled!");
*/

    }
    public void onLoad() {
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        pM.onRunnable();
    }
    public Oneplug getPlugin() {
        return plugin;
    }

}
