package us.sushipython.bsumo.misc;

import fr.minuskube.netherboard.Netherboard;
import fr.minuskube.netherboard.bukkit.BPlayerBoard;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import us.sushipython.bsumo.commands.queue;
import us.sushipython.bsumo.events.deathheight;

import java.util.ArrayList;
import java.util.Random;

public class spawn {
    public static boolean gameOn;
    public static void spawn(ArrayList<Player> players) {
        gameOn = true;
        for (int c = 0; c < players.size(); c++) {
            queue.livesMap.put(players.get(c), 5);
        }
        System.out.println("activated with " + players.toString());
        World world = players.get(0).getWorld();
        String everyone = "";
        Location[] spawns = {
                new Location(world, 42.5, 113, -139.5, 0, 0),
                new Location(world, 51.5, 113, -139.5, 45, 0),
                new Location(world, 51.5, 113, -130.5, 90, 0),
                new Location(world, 51.5, 113, -121.5, 135, 0),
                new Location(world, 42.5, 113, -121.5, 180, 0),
                new Location(world, 33.5, 113, -121.5, -135, 0),
                new Location(world, 33.5, 113, -130.5, -90, 0),
                new Location(world, 33.5, 113, -139.5, -45, 0)};
        Location[] s = {
                new Location(world, 42, 113, -140, 0, 0),
                new Location(world, 51, 113, -140, 45, 0),
                new Location(world, 51, 113, -131, 90, 0),
                new Location(world, 51, 113, -122, 135, 0),
                new Location(world, 42, 113, -122, 180, 0),
                new Location(world, 33, 113, -122, -135, 0),
                new Location(world, 33, 113, -131, -90, 0),
                new Location(world, 33, 113, -140, -45, 0)};
        for (int f = 0; f < players.size(); f++) {
            Player player = players.get(f);
            addScoreboard.scoreboardReset(players);
            everyone = everyone+player.getDisplayName()+", ";
            ItemStack wool = new ItemStack(Material.WOOL, 64);
            ItemStack shears = new ItemStack(Material.SHEARS, 1);
            deathheight.invincibles.add(player);
            Random generator = new Random();
            int randomIndex = generator.nextInt(spawns.length);
            player.getInventory().clear();
            player.getInventory().addItem(wool);
            player.getInventory().addItem(shears);
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 255));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 999999, 255));
            player.setHealth(20);
            player.setGameMode(GameMode.SPECTATOR);
            player.teleport(new Location(world, 43, 120, -130));
            Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("BSumo"), () -> {
                Location i = spawns[randomIndex];
                Location c = s[randomIndex];
                new Location(world, c.getX(), 113, c.getZ()).getBlock().setType(Material.AIR);
                new Location(world, c.getX(), 114, c.getZ()).getBlock().setType(Material.AIR);
                player.teleport(spawns[randomIndex]);
                player.setGameMode(GameMode.SURVIVAL);
            }, 100L);
            Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("BSumo"), () -> {
                deathheight.invincibles.remove(player);
                player.sendMessage("Invincibility expired.");
            }, 200L);
        }
        Bukkit.broadcastMessage(ChatColor.DARK_PURPLE+"Players: "+ChatColor.WHITE+everyone);
    }
    public static void spawnone(Player player) {
        World world = player.getWorld();
        Location[] spawns = {
                new Location(world, 42.5, 113, -139.5, 0, 0),
                new Location(world, 51.5, 113, -139.5, 45, 0),
                new Location(world, 51.5, 113, -130.5, 90, 0),
                new Location(world, 51.5, 113, -121.5, 135, 0),
                new Location(world, 42.5, 113, -121.5, 180, 0),
                new Location(world, 33.5, 113, -121.5, -135, 0),
                new Location(world, 33.5, 113, -130.5, -90, 0),
                new Location(world, 33.5, 113, -139.5, -45, 0)};
        Location[] s = {
                new Location(world, 42, 113, -140, 0, 0),
                new Location(world, 51, 113, -140, 45, 0),
                new Location(world, 51, 113, -131, 90, 0),
                new Location(world, 51, 113, -122, 135, 0),
                new Location(world, 42, 113, -122, 180, 0),
                new Location(world, 33, 113, -122, -135, 0),
                new Location(world, 33, 113, -131, -90, 0),
                new Location(world, 33, 113, -140, -45, 0)};
            ItemStack wool = new ItemStack(Material.WOOL, 64);
            ItemStack shears = new ItemStack(Material.SHEARS, 1);
            deathheight.invincibles.add(player);
            Random generator = new Random();
            int randomIndex = generator.nextInt(spawns.length);
            player.getInventory().clear();
            player.getInventory().addItem(wool);
            player.getInventory().addItem(shears);
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 999999, 255));
            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 999999, 255));
            player.setHealth(20);
            player.setGameMode(GameMode.SPECTATOR);
            player.teleport(new Location(world, 43, 120, -130));
            // scoreboards
            int playerlives = queue.livesMap.get(player);
            queue.livesMap.remove(player);
            queue.livesMap.put(player, playerlives);
            addScoreboard.scoreboardReset(queue.inqueue);
            Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("BSumo"), () -> {
                Location i = spawns[randomIndex];
                Location c = s[randomIndex];
                new Location(world, c.getX(), 113, c.getZ()).getBlock().setType(Material.AIR);
                new Location(world, c.getX(), 114, c.getZ()).getBlock().setType(Material.AIR);
                player.teleport(spawns[randomIndex]);
                player.setGameMode(GameMode.SURVIVAL);
            }, 100L);
            Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("BSumo"), () -> {
                deathheight.invincibles.remove(player);
                player.sendMessage("Invincibility expired.");
            }, 200L);
        }
}
