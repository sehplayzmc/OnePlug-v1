package me.seth.oneplug.commands;

import me.seth.oneplug.utils.Version;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commandversion implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("version")) {
            sender.sendMessage(ChatColor.YELLOW + "[OnePlug]: Current Version: " + ChatColor.GRAY + Version.Snapshot);

        }
        return true;
    }
}
