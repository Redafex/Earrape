package com.redafex;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.UUID;

import static com.redafex.Utils.play;
import static com.redafex.Utils.sendFromConfig;

public class EarrapeCommand implements CommandExecutor {

    public static ArrayList<UUID> earraping = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        Player p = (Player) commandSender;
        UUID pUuid = p.getUniqueId();
        if (args.length != 0 && ( p == null || p.hasPermission("earrape.permission"))) {
            Player target = Bukkit.getPlayerExact(args[0]);
            UUID uuid = target.getUniqueId();

            if (target == null) {
                sendFromConfig(p, target, 0L,"PlayerNotFound", false);
                return true;
            }

            if (earraping.contains(uuid)){
                sendFromConfig(p, target, 0L,"PlayerCancelEarrape", false);
                earraping.remove(uuid);
                return true;
            }

            if (args.length == 2){
                try {
                    float time = Float.parseFloat(args[1]);
                    sendFromConfig(p, target,(long) time,"PlayerEarrapedTime", true);
                    sendFromConfig(p, target, 0L,"PlayerReceivedEarrape", true);
                    play(target, earraping);
                    new BukkitRunnable(){
                        @Override
                        public void run() {
                            earraping.remove(uuid);
                        }
                    }.runTaskLater(Earrape.instance,((long) time) * 20);
                } catch (Exception e){
                    sendFromConfig(p, p, 0L,"NumberNotCorrect", false);
                }
                return true;
            }

            sendFromConfig(p, target, 0L,"PlayerEarraped", false);
            sendFromConfig(p, target, 0L,"PlayerReceivedEarrape", true);
            play(target, earraping);
            return true;
        }

        if (earraping.contains(pUuid)){
            sendFromConfig(p, p, 0L,"PlayerCancelEarrape", false);
            earraping.remove(pUuid);
            return true;
        }

        sendFromConfig(p, p, 0L,"PlayerEarraped", false);
        sendFromConfig(p, p, 0L,"PlayerReceivedEarrape", false);
        play(p, earraping);
        return true;
    }


}


