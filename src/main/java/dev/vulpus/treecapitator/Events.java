package dev.vulpus.treecapitator;

import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Events implements Listener {

    private final FileConfiguration config;
    public Events(FileConfiguration configuration) {
        config = configuration;
    }

    Methods m = new Methods();

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        Player player = event.getPlayer();
        ItemStack tool = player.getInventory().getItemInMainHand();
        Block block = event.getBlock();
        String type = block.getType().name();
        if (player.hasPermission("treecapitator.fell") && !player.getGameMode().equals(GameMode.CREATIVE) && tool.getType().name().endsWith("_AXE") && type.endsWith("_LOG") && (!player.isSneaking() || !config.getBoolean("sneak-ignore", config.getDefaults().getBoolean("sneak-ignore")))) {

            if (type.startsWith("STRIPPED_")) {
                type = type.substring(9);
            }

            List<Block> logs = m.getLogs(block.getLocation(), type);
            if (!config.getBoolean("trees-have-leaves", config.getDefaults().getBoolean("trees-have-leaves")) || m.hasLeaves(logs, type.substring(0, type.length() - 4) + "_LEAVES")) {

                if (config.getBoolean("damage-per-block", config.getDefaults().getBoolean("damage-per-block"))) {

                    Damageable meta = (Damageable) tool.getItemMeta();
                    int dur = tool.getType().getMaxDurability() - meta.getDamage();
                    if (logs.size() > dur) {
                        logs = logs.subList(0, dur - 1);
                    }
                    meta.setDamage(meta.getDamage() + logs.size());
                    tool.setItemMeta((ItemMeta) meta);

                }

                for (Block log : logs) {
                    log.breakNaturally();
                }

            }

        }

    }

}
