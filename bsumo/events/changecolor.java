package us.sushipython.bsumo.events;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Dye;

import java.util.Random;

public class changecolor implements Listener {
    @EventHandler
    public void changecolor(BlockPlaceEvent e) {
        if (e.getItemInHand().getType().equals(Material.WOOL)) {
            Player p = e.getPlayer();
            double x = e.getBlock().getLocation().getX();
            double y = e.getBlock().getLocation().getY();
            double z = e.getBlock().getLocation().getZ();
            World w = e.getPlayer().getWorld();
            if ((new Location(w, x+1, y, z).getBlock().getType().equals(Material.BARRIER)) || (new Location(w, x, y, z+1).getBlock().getType().equals(Material.BARRIER)) || (new Location(w, x-1, y, z).getBlock().getType().equals(Material.BARRIER)) || (new Location(w, x, y, z-1).getBlock().getType().equals(Material.BARRIER))) {
                e.setCancelled(true);
                Location playerLoc = p.getLocation();
                p.teleport(new Location(p.getWorld(), playerLoc.getX(), playerLoc.getY()-2, playerLoc.getZ()));
            } else {
                p.setItemInHand(new ItemStack(Material.WOOL, 64));
                DyeColor[] colors = {DyeColor.RED, DyeColor.LIME, DyeColor.ORANGE, DyeColor.LIGHT_BLUE, DyeColor.GREEN, DyeColor.PURPLE};
                Random generator = new Random();
                int randomIndex = generator.nextInt(colors.length);
                e.getBlock().setData(colors[randomIndex].getDyeData());
            }

        }
    }
}
