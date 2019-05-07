package me.seth.oneplug.commands;

import me.seth.oneplug.main.Oneplug;
import me.seth.oneplug.utils.pManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandXp implements CommandExecutor {

    private Oneplug plugin;
    private pManager pm;

    public CommandXp(Oneplug pl) {
        plugin = pl;
        this.plugin.getCommand("xp").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("xp")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "You are not a Player!");
                return true;
            }
            Player p = (Player) sender;
            if (args.length < 1) {
                sender.sendMessage(ChatColor.RED + "Please put an amount");
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
        return false;
    }
}
