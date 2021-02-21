package us.sushipython.bsumo.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class antifall implements Listener {
    @EventHandler
    public void antifall(EntityDamageEvent event) {
        Entity ee = event.getEntity();
        if (ee instanceof Player) {
            Player p = (Player) ee;
            EntityDamageEvent.DamageCause type = event.getCause();
            if (type == EntityDamageEvent.DamageCause.FALL) {
                event.setCancelled(true);
            }
            if (deathheight.invincibles.contains(p)) {
                event.setCancelled(true);
            }
        }
    }
}
