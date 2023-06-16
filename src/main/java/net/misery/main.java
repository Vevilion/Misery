package net.misery;

import net.fabricmc.api.ModInitializer;
import net.misery.confighandler.configsList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class main implements ModInitializer {
  
    public static final String MOD_ID = "misery";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        configsList.registerConfigs();
        LOGGER.info("The corruption spreads...");
    }
}