package me.seth.oneplug.main;

import me.seth.oneplug.commands.CommandFly;
import me.seth.oneplug.commands.CommandXp;
import me.seth.oneplug.commands.Commandheal;
import me.seth.oneplug.events.BanWord;
import me.seth.oneplug.utils.pManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Oneplug extends JavaPlugin {

    public Oneplug plugin;
    private pManager pM;

    @Override
    public void onEnable() {
        onLoad();
        this.getServer().getConsoleSender().sendMessage(pM.ChatMessage("&a[OnePlug] Enabled!"));
        registerCommands();
        registerEvents();
        saveDefaultConfig();
    }

    private void registerCommands() {
        new Commandheal(this);
        new CommandXp(this);
        new CommandFly(this);
    }


    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new BanWord(this), this);
        this.getServer().getPluginManager().registerEvents(new EventGift(), this);
    }

    @Override
    public void onDisable() {
    }
    public void onLoad() {
        this.getConfig().options().copyDefaults(true);
        pM = new pManager();
        pM.onRunnable();
    }

}