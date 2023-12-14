package me.srrapero720.embeddiumplus;

import me.srrapero720.dynamiclights.LambDynLights;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.network.NetworkConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import me.srrapero720.embeddiumplus.config.EmbeddiumPlusConfig;

@Mod(EmbeddiumPlus.ID)
public class EmbeddiumPlus {
    public static final String ID = "embeddiumplus";
    public static final Logger LOGGER = LogManager.getLogger();

    public EmbeddiumPlus() {
        MinecraftForge.EVENT_BUS.register(this);
        EmbeddiumPlusConfig.loadConfig();
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> LambDynLights::init);
//        EmbeddiumPlusConfig.loadConfig(FMLPaths.CONFIGDIR.get().resolve("embeddium++.toml"));
    }
}