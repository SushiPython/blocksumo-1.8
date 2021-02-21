package us.sushipython.bsumo.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.sushipython.bsumo.misc.spawn;

import java.util.ArrayList;
import java.util.HashMap;

public class queue implements CommandExecutor {
    public static ArrayList<Player> inqueue = new ArrayList<Player>();
    public static HashMap<Player, Integer> livesMap = new HashMap<Player, Integer>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        Location spawnLoc = new Location(p.getWorld(), 42.5, 112, -130.5);
        Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + p.getDisplayName() + ChatColor.WHITE + " joined the queue!");
        inqueue.add(p);
        return false;
    }
}
