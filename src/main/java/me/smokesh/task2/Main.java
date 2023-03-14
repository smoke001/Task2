package me.smokesh.task2;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Random;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginCommand("bs").setExecutor((sender, command, s, args) -> {
            if (sender.isOp()) {
                new BukkitRunnable() {
                    Player player = (Player)sender;
                    Random random = new Random();
                    @Override
                    public void run() {
//                        //float y = (float) -5 + (float)(Math.random() * ((8 - -8) + 1));
//                        float z = random.nextInt(10);
//                        float x = random.nextInt(15);
                        for (double i = 0; i < 2 * Math.PI; i = i + (Math.PI / 4)) {
                            double x = Math.sin(i) * 10;
                            double z = Math.cos(i) * 10;

                            TNTPrimed block = (TNTPrimed) player.getWorld().spawnEntity(player.getLocation().add(x, 15, z), EntityType.PRIMED_TNT);
                        }
                    }
                }.runTaskTimer(this, 0, 20L);
            }
            return true;
        });
        Bukkit.getPluginCommand("bs2").setExecutor((sender, command, s, args) -> {
            if (sender.isOp()) {
                new BukkitRunnable() {
                    Player player = (Player)sender;
                    Random random = new Random();
                    @Override
                    public void run() {
                        float z = random.nextInt(10);
                        float x = random.nextInt(15);
                       player.getWorld().spawnEntity(player.getLocation().add(x, 15, z), EntityType.PRIMED_TNT);
                    }
                }.runTaskTimer(this, 0, 20L);
            }
            return true;
        });
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
