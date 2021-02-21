package us.sushipython.bsumo.events;

import jdk.internal.icu.impl.BMPSet;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import us.sushipython.bsumo.misc.spawn;

import java.util.ArrayList;

public class deathheight implements Listener {
    public static ArrayList<Player> invincibles = new ArrayList<Player>();
    @EventHandler
    public void deathheight(PlayerMoveEvent e) {
        Location playerLoc = e.getTo();
        if (playerLoc.getY() < 100 & e.getPlayer().getGameMode().equals(GameMode.SURVIVAL)) {
            Player player = e.getPlayer();
            Bukkit.broadcastMessage(ChatColor.DARK_PURPLE+player.getDisplayName() + ChatColor.WHITE + " has fallen into the void.");
            player.sendMessage("You died! You will respawn in 5 seconds.");
            spawn.spawnone(player);
        }
    }

}
