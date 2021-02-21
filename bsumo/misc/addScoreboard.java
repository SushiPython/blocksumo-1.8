package us.sushipython.bsumo.misc;

import fr.minuskube.netherboard.Netherboard;
import fr.minuskube.netherboard.bukkit.BPlayerBoard;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import us.sushipython.bsumo.commands.queue;

import java.util.ArrayList;

public class addScoreboard {
    public static void scoreboardReset(ArrayList<Player> players) {
        for (int z = 0; z < players.size(); z++) {
            BPlayerBoard board = Netherboard.instance().createBoard(players.get(z), "Block Sumo");
            for (int i = 0; i < players.size(); i++) {
                String sbe = ChatColor.RED + players.get(i).getDisplayName() + ": " + ChatColor.GREEN + queue.livesMap.get(players.get(i));
                board.set(sbe, z);
            }
        }
    }
}
