package us.sushipython.bsumo.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;


public class antistonebreak implements Listener {

    @EventHandler
    public void antistonebreak(BlockBreakEvent e) {
        Material block = e.getBlock().getType();
    if (block.equals(Material.STONE) || block.equals(Material.SMOOTH_BRICK) || block.equals(Material.SMOOTH_STAIRS) || block.equals(Material.STONE_SLAB2) || block.equals(Material.GOLD_BLOCK) || block.equals(Material.IRON_BLOCK) || block.equals(Material.COBBLE_WALL)) {
            e.setCancelled(true);
            e.getPlayer().sendMessage("You can't break this block here!");
        }

        if (block.equals(Material.WOOL)) {
            e.setCancelled(true);
            e.getBlock().setType(Material.AIR);
        }

    }
}