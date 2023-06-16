// This is a borrowed code from a tutorial by https://www.youtube.com/@ModdingByKaupenjoe
// Video this code was borrowed from https://youtu.be/w2wyfFnPPmY
// This mod is a silly joke, so I don't really care about putting too much effort into it :)
// Some parts of this code have been modified by me

package net.misery.confighandler;

import com.mojang.datafixers.util.Pair;

import net.misery.main;

public class configsList {

    public static SimpleConfig CONFIG;
    private static configMod configs;

    public static double SIN_VALUE;
    public static int COS_VALUE;
    public static boolean DISABLE_MOD;
    

    public static void registerConfigs() {
        configs = new configMod();
        createConfigs();

        CONFIG = SimpleConfig.of(main.MOD_ID).provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("sin.value", 10430.378), "Default value for sin is: 10430.378");
        configs.addKeyValuePair(new Pair<>("cos.value", 16384), "Default value for cos is: 16384");
        configs.addKeyValuePair(new Pair<>("disable.mod", false), "By default the mod is enabled, set this to true to disable it");
    }

    private static void assignConfigs() {
        SIN_VALUE = CONFIG.getOrDefault("sin.value", 10430.378);
        COS_VALUE = CONFIG.getOrDefault("cos.value", 16384);
        DISABLE_MOD = CONFIG.getOrDefault("disable.mod", false);
        
        System.out.println(configs.getConfigsList().size() + " Misery configs have been set properly");
    }
}
