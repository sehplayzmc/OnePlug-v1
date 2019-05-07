package me.seth.oneplug.commands;

import me.seth.oneplug.main.Oneplug;
import me.seth.oneplug.utils.pManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFly implements CommandExecutor {
    private Oneplug plugin;
    private pManager pm;

    public CommandFly(Oneplug pl) {
        plugin = pl;
        this.plugin.getCommand("fly").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(pm.ChatMessage(plugin.getConfig().getString("messages.console_error")));
            return true;
        }
        Player p = (Player) sender;
        if(p.hasPermission("one.fly")) {
            if(p.isFlying()) {
                p.setAllowFlight(false);
                p.setFlying(false);
                p.sendMessage(this.plugin.getConfig().getString("messages.fly_disabled"));
            } else {
                p.setAllowFlight(true);
                p.setFlying(true);
                p.sendMessage(this.plugin.getConfig().getString("messages.fly_disabled"));
            }
        } else {
            p.sendMessage(this.plugin.getConfig().getString("messages.fly_disabled"));
            return true;
        }
        return false;
    }
}
