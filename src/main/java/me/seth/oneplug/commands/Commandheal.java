package me.seth.oneplug.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandheal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("heal")) {
            if(!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "You are not a player!");
            }else {
                Player p = (Player) sender;
                if(p.getHealth() < 20) {
                    p.setHealth(20);
                    sender.sendMessage(ChatColor.YELLOW + "You are fully healed!");
                    return true;
                }else {
                    sender.sendMessage(ChatColor.GOLD + "You're in full health!");
                    return true;
                }
            }
        }
        return false;
    }
}
