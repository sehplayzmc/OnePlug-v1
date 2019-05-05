package me.seth.oneplug.events;

import me.seth.oneplug.main.Oneplug;
import me.seth.oneplug.utils.pManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.List;
import java.util.UUID;

public class BanWord implements Listener {

    private Oneplug plugin;
    private pManager pM;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        UUID uid = p.getUniqueId();
        int tResume = plugin.getConfig().getInt(uid + ".cooldown-left");
        if(tResume == 0) {
            return;
        } else {
            pM.time.put(uid, tResume);
        }
        if(pM.time.containsKey(uid)) {
            p.sendMessage(ChatColor.GRAY + "You're currently muted!");
        }
        plugin.saveConfig();
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        Player p = event.getPlayer();
        UUID uid = p.getUniqueId();
        plugin.getConfig().set(uid + ".cooldown-left", pM.time.get(uid));
        plugin.saveConfig();
        pM.time.remove(uid);
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String msg = event.getMessage();
        Player p = event.getPlayer();
        boolean state = plugin.getConfig().getBoolean("state");
        int incidents = plugin.getConfig().getInt("incidents." + p.getUniqueId().toString());
        List<String> list = plugin.getConfig().getStringList("banned-words");
        List<String> glist = plugin.getConfig().getStringList("good-words");
        UUID uid = p.getUniqueId();
        if(!pM.time.containsKey(uid)) {
            if (state) {
                for (String banWord : list) {
                    if (msg.contains(banWord)) {
                        event.setCancelled(true);
                        pM.time.put(uid, plugin.getConfig().getInt("mute-cooldown"));
                        p.sendMessage(ChatColor.RED + "You're not allowed to say that word!");
                        if (incidents != 0) {
                            incidents++;
                            plugin.getConfig().set("incidents." + p.getUniqueId().toString(), incidents);
                            plugin.saveConfig();
                        } else {
                            plugin.getConfig().set("incidents." + p.getUniqueId().toString(), 1);
                            plugin.saveConfig();
                        }
                    }
                }
            }
        } else {
            event.setCancelled(true);
            p.sendMessage(ChatColor.RED + "You still have " + ChatColor.DARK_RED + pM.time.get(uid) + ChatColor.RED + "'s !");
        }
    }

    public BanWord(Oneplug pl) {
        plugin = pl;
    }
}
