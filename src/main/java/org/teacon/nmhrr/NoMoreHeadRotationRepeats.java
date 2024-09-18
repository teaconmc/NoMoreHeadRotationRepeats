package org.teacon.nmhrr;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.maven.artifact.versioning.ArtifactVersion;

@Mod(NoMoreHeadRotationRepeats.MOD_ID)
public final class NoMoreHeadRotationRepeats {
    public static final String MOD_ID = "nmhrr";
    public static final Logger LOGGER = LogManager.getLogger("NoMoreHeadRotationRepeats");

    private final ArtifactVersion version;

    public NoMoreHeadRotationRepeats(ModContainer container, IEventBus modBus) {
        modBus.addListener(FMLCommonSetupEvent.class, this::on);
        this.version = container.getModInfo().getVersion();
    }

    private void on(FMLCommonSetupEvent event) {
        LOGGER.info("NMHRR Version: {}", this.version);
    }
}
