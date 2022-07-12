package us.techno.samplepluginorbit.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LightningCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (args.length != 1) { //player may have provided too much info
            commandSender.sendMessage(ChatColor.RED + "Wrong Syntax. Use " + command.getUsage());
            return true;
        }
        final Player target = Bukkit.getPlayer(args[0]);

        if (target != null) {
            target.getWorld().strikeLightning(target.getLocation());
            commandSender.sendMessage(ChatColor.GREEN + "Successfully struck " + target.getDisplayName() + " with lightning!");
        } else {
            commandSender.sendMessage(ChatColor.RED + "Player not found!");
        }

        return true;
    }
}

