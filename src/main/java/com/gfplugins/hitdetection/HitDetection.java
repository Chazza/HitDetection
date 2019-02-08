package com.gfplugins.hitdetection;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class HitDetection extends JavaPlugin implements Listener {

    private int maxNoDamageTicks;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        maxNoDamageTicks = getConfig().getInt("no-damage-ticks", 20);
        Bukkit.getLogger().info("[HitDetection] The Maximum No Damage Ticks is set to: " + maxNoDamageTicks);
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        saveDefaultConfig();

        maxNoDamageTicks = 0;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().setMaximumNoDamageTicks(maxNoDamageTicks);
    }
}
