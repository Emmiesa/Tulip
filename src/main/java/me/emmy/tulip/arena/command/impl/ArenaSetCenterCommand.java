package me.emmy.tulip.arena.command.impl;

import me.emmy.tulip.Tulip;
import me.emmy.tulip.arena.Arena;
import me.emmy.tulip.utils.CC;
import me.emmy.tulip.utils.command.BaseCommand;
import me.emmy.tulip.utils.command.annotation.Command;
import me.emmy.tulip.utils.command.CommandArgs;
import org.bukkit.entity.Player;

/**
 * Created by Emmy
 * Project: Tulip
 * Date: 05/06/2024 - 19:33
 */
public class ArenaSetCenterCommand extends BaseCommand {
    @Override
    @Command(name = "arena.setcenter", permission = "Tulip.admin")
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (command.length() < 1) {
            player.sendMessage(CC.translate("&cUsage: /arena setcenter <name>"));
            return;
        }

        String arenaName = args[0];

        Arena arena = Tulip.getInstance().getArenaRepository().getArena(arenaName);
        if (arena == null) {
            player.sendMessage(CC.translate("&cArena " + arenaName + " does not exist!"));
            return;
        }

        Tulip.getInstance().getArenaRepository().getArena(arenaName).setCenter(player.getLocation());
        Tulip.getInstance().getArenaRepository().saveArena(arena);
        player.sendMessage(CC.translate("&aCenter set for arena " + arenaName + "!"));
    }
}