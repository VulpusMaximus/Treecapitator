package dev.vulpus.treecapitator;

import org.bukkit.Location;
import org.bukkit.block.Block;

import java.util.ArrayList;
import java.util.List;

public class Methods {

    public List<Block> getSurrounding(Location origin, String type) {

        List<Block> blocks = new ArrayList<>();
        for (int x = -1; x < 2; x++)
            for (int y = 0; y < 2; y++)
                for (int z = -1; z < 2; z++) {

                    Location loc = origin.clone().add(x, y, z);
                    Block block = loc.getBlock();
                    if (!origin.equals(loc) && block.getType().name().endsWith(type)) {

                        blocks.add(block);

                    }

                }

        return blocks;

    }

    public List<Block> getLogs(Location origin, String type) {

        List<Block> logs = new ArrayList<>();
        List<Block> next = getSurrounding(origin, type);

        while (!next.isEmpty()) {

            List<Block> nextNext = new ArrayList<>();
            for (Block log : next) {

                if (!logs.contains(log)) {
                    logs.add(log);
                    nextNext.addAll(getSurrounding(log.getLocation(), type));
                }

            }

            next = nextNext;

        }

        return logs;

    }

    public boolean hasLeaves(List<Block> logs, String type) {

        for (Block log : logs) {

            if (!getSurrounding(log.getLocation(), type).isEmpty()) {
                return true;
            }

        }

        return false;

    }

}
