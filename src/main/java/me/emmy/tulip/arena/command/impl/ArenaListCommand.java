package me.emmy.tulip.arena.command.impl;

import me.emmy.tulip.Tulip;
import me.emmy.tulip.utils.CC;
import me.emmy.tulip.utils.command.BaseCommand;
import me.emmy.tulip.utils.command.annotation.Command;
import me.emmy.tulip.utils.command.CommandArgs;
import org.bukkit.command.CommandSender;

/**
 * @author Emmy
 * @project Tulip
 * @date 05/06/2024 - 20:17
 */
public class ArenaListCommand extends BaseCommand {
    @Override
    @Command(name = "arena.list", permission = "Tulip.admin", inGameOnly = false)
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();

        sender.sendMessage("");
        sender.sendMessage(CC.translate("&eArena List &7(&e" + Tulip.getInstance().getArenaRepository().getArenas().size() + "&7)"));
        if (Tulip.getInstance().getArenaRepository().getArenas().isEmpty()) {
            sender.sendMessage(CC.translate("&7There are no arenas available."));
        }
        Tulip.getInstance().getArenaRepository().getArenas().forEach(arena -> sender.sendMessage(CC.translate(" &7- " + arena.getName())));
        sender.sendMessage("");
    }
}