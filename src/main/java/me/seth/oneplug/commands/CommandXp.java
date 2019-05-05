package me.seth.oneplug.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandXp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (command.getName().equalsIgnoreCase("xp")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "You are not a Player!");
                return true;
            } else {
                if (args.length < 1) {
                    sender.sendMessage(ChatColor.RED + "Please put the xp amount");
                    return true;
                } else if (args.length == 1) {
                    try {
                        int amount = args.length;
                        int addAmount = Integer.parseInt(args[0]);
                        p.giveExp(amount + addAmount);
                        p.sendMessage(ChatColor.GRAY + "You now have " + ChatColor.GREEN + addAmount + ChatColor.GRAY + "of xp!");
                    } catch (NumberFormatException e) {
                        sender.sendMessage(ChatColor.RED + "Please put a real number!");
                        return true;
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
