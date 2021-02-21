package us.sushipython.bsumo.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.sushipython.bsumo.misc.spawn;

import java.util.HashMap;
import java.util.Map;

public class start implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        spawn.spawn(queue.inqueue);
        return false;
    }
}
