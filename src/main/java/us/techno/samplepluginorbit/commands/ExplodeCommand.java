package us.techno.samplepluginorbit.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class ExplodeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (args.length < 1) { //player may have provided too much info
            commandSender.sendMessage(ChatColor.RED + "Wrong Syntax. Use " + command.getUsage());
            return true;
        }
        final Player target = Bukkit.getPlayer(args[0]);

        if (target != null) {
            target.setHealth(0.0D);
            Objects.requireNonNull(target.getLocation().getWorld()).createExplosion(target.getLocation(), 1.0F, true);
            commandSender.sendMessage(ChatColor.GREEN + "Successfully exploded " + target.getDisplayName() + "!");
        } else {
            commandSender.sendMessage(ChatColor.RED + "Player not found!");
        }

        return true;
    }
}
