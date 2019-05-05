package me.seth.oneplug.main;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EventGift implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        Player p = event.getPlayer();
        Block bck = event.getBlock();
        Material mat = bck.getType();
        if(mat.equals(Material.GRASS)) {
            bck.getDrops().clear();
            p.sendMessage(ChatColor.GRAY + "Weird it disappear!");
            p.addPotionEffect(PotionEffectType.REGENERATION.createEffect(180, 5));
            p.addPotionEffect(PotionEffectType.HEALTH_BOOST.createEffect(180, 10));
        }
    }
}
