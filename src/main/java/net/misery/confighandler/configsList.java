// This is a borrowed code from a tutorial by https://www.youtube.com/@ModdingByKaupenjoe
// Video this code was borrowed from https://youtu.be/w2wyfFnPPmY
// This mod is a silly joke, so I don't really care about putting too much effort into it :)

package net.misery.confighandler;

import com.mojang.datafixers.util.Pair;

import net.misery.main;

public class configsList {

    public static SimpleConfig CONFIG;
    private static configMod configs;

    public static double SIN_VALUE;
    public static double COS_VALUE;
    

    public static void registerConfigs() {
        configs = new configMod();
        createConfigs();

        CONFIG = SimpleConfig.of(main.MOD_ID).provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("sin value", 10430.378), "Default value for sin is: 10430.378");
        configs.addKeyValuePair(new Pair<>("cos value", 16384.0), "Default value for cos is: 16384.0");
        
    }

    private static void assignConfigs() {
        SIN_VALUE = CONFIG.getOrDefault("sin value", 10430.378);
        COS_VALUE = CONFIG.getOrDefault("cos value", 16384.0);
        

        System.out.println("All " +  configs.getConfigsList().size() + " have been set properly");
    }
}
