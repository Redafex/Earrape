package com.redafex;

import org.bukkit.plugin.java.JavaPlugin;

public class Earrape extends JavaPlugin {

    public static Earrape instance;

    @Override
    public void onEnable() {
        instance = this;
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        saveConfig();
        reloadConfig();
        getLogger().info(Utils.color("&c+Earrape plugin activated"));
        this.getCommand("earrape").setExecutor(new EarrapeCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("Deactivated");
    }
}
