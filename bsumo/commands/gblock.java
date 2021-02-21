package us.sushipython.bsumo.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Random;

public class gblock implements CommandExecutor {
    private void spawnItem(World w) { // big boi items
        ItemStack bat = new ItemStack(Material.STONE_SWORD);
        Material[] items = {Material.STICK, Material.BLAZE_ROD, Material.PRISMARINE_CRYSTALS};
        Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("BSumo"), () -> {
            Random generator = new Random();
            Integer randNumb = generator.nextInt(items.length);
            w.dropItem(new Location(w, 42, 114, -131), new ItemStack(items[randNumb]));
            Bukkit.broadcastMessage(ChatColor.GOLD + new ItemStack(items[randNumb]).getType().name() + ChatColor.WHITE + " spawned on the gold block.");
            spawnItem(w);
        }, 1200L);
    }
    private void giveItem() { // light items
        ItemStack[] items = {new ItemStack(Material.FIREBALL), new ItemStack(Material.FIREBALL), new ItemStack(Material.TNT), new ItemStack(Material.SNOW_BALL, 16), new ItemStack(Material.WOOD_SWORD)};
        Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("BSumo"), () -> {
            Random generator = new Random();
            Integer n = generator.nextInt(items.length);
            for (Player p : Bukkit.getOnlinePlayers()) {
                ItemStack finalItem = new ItemStack(Material.WOOD_SWORD);
                if (items[n].equals(finalItem)) {
                    ItemMeta testEnchantMeta = finalItem.getItemMeta();
                    testEnchantMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
                    finalItem.setItemMeta(testEnchantMeta);
                } else {
                    finalItem = items[n];
                }
                p.getInventory().addItem(finalItem);
            }
            Bukkit.broadcastMessage(ChatColor.GOLD + items[n].getType().name().replace('_', ' ') + ChatColor.WHITE + " has been given to every player.");
            giveItem();
        }, 1000L);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        spawnItem(player.getWorld());
        giveItem();
        return false;
    }
}