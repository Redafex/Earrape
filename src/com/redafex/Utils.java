package com.redafex;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

public class Utils {

    public static FileConfiguration config = Earrape.instance.getConfig();


    public static void play(Player target, ArrayList<UUID> arr){
        arr.add(target.getUniqueId());
        Timer t = new Timer();
        int volume = 10;
        int pitch = 1;
        if (Bukkit.getVersion().contains("1.8") || Bukkit.getVersion().contains("1.7")){
            TimerTask tt = new TimerTask() {
                @Override
                public void run() {
                    if (!arr.contains(target.getUniqueId())){
                        t.cancel();
                        return;
                    }
                    for (int i = 0; i < 10; i += 1) {
                        target.playSound(target.getLocation(), Sound.valueOf("VILLAGER_DEATH"), volume, pitch);
                        target.playSound(target.getLocation(), Sound.valueOf("ANVIL_BREAK"), volume, pitch);
                        target.playSound(target.getLocation(), Sound.valueOf("ANVIL_BREAK"), volume, pitch);
                        target.playSound(target.getLocation(), Sound.valueOf("DOOR_OPEN"), volume, pitch);
                        target.playSound(target.getLocation(), Sound.valueOf("DOOR_CLOSE"), volume, pitch);
                    }
                }
            };
            t.scheduleAtFixedRate(tt, 0, 20);
        } else {
            TimerTask tt = new TimerTask() {
                @Override
                public void run() {
                    if (!arr.contains(target.getUniqueId())){
                        t.cancel();
                        return;
                    }
                    for (int i = 0; i < 10; i += 1) {
                        //Multiplying sounds by 2 because it's less loud in versions above 1.8 :)
                        target.playSound(target.getLocation(), Sound.valueOf("ENTITY_VILLAGER_DEATH"), volume * 2, pitch);
                        target.playSound(target.getLocation(), Sound.valueOf("BLOCK_ANVIL_BREAK"), volume * 2, pitch);
                        target.playSound(target.getLocation(), Sound.valueOf("BLOCK_ANVIL_BREAK"), volume * 2, pitch);
                        target.playSound(target.getLocation(), Sound.valueOf("BLOCK_WOODEN_DOOR_OPEN"), volume * 2, pitch);
                        target.playSound(target.getLocation(), Sound.valueOf("BLOCK_WOODEN_DOOR_CLOSE"), volume * 2, pitch);
                    }
                }
            };
            t.scheduleAtFixedRate(tt, 0, 20);
        }
    }

    public static void sendFromConfig(Player p, Player target, Long time, String configMsg, boolean flip){
        String msg = "Messages." + configMsg;
        if (config.getString(msg) == null || config.getString(msg).equals("Disable")) return;
        String name = p == null ? "Console" : p.getName();
        String s = color(config.getString(msg))
                .replace("%player%", name)
                .replace("%target%", target.getName())
                .replace("%seconds%", Long.toString(time));

        if (flip) target.sendMessage(s);
        else sendToPlayerIfPos(p, s);
    }
    public static void sendToPlayerIfPos(Player p, String s){
        if (p == null) p.sendMessage(s);
        else Bukkit.getConsoleSender().sendMessage(s);
    }

    public static String color(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
