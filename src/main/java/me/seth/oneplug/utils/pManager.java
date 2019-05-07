package me.seth.oneplug.utils;

import me.seth.oneplug.main.Oneplug;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.UUID;

public class pManager {
    public HashMap<UUID, Integer> time = new HashMap<UUID, Integer>();
    private Oneplug plugin;
    public String ChatMessage(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public void onRunnable() {
        new BukkitRunnable() {
            @Override
            public void run() {
                if(time.isEmpty()) {
                    return;
                }
                for(UUID uuid : time.keySet()) {
                    int tleft = time.get(uuid);
                    if(tleft <= 0) {
                        time.remove(uuid);
                    } else {
                        time.put(uuid, tleft - 1);
                    }
                }

            }
        }.runTaskTimer(plugin, 0, 20);
    }
}
