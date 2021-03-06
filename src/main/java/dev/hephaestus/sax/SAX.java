package dev.hephaestus.sax;

import dev.hephaestus.fiblib.FibLib;
import dev.hephaestus.sax.block.HideOccludedOre;
import dev.hephaestus.sax.server.Config;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class SAX implements ModInitializer {
    public static final String MODID = "sax";
    public static final String MOD_NAME = "SAX";
    public static final Logger LOG = LogManager.getLogger(MOD_NAME);

    public static Identifier id(String... path) {
        return new Identifier(MODID, String.join(".", path));
    }

    @Override
    public void onInitialize() {
        for (Map.Entry<Block, Block> entry : Config.HIDDEN.entrySet()) {
            FibLib.Blocks.register(new HideOccludedOre(entry.getKey(), entry.getValue()));
        }
    }
}
