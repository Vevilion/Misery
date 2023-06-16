// This is a borrowed code from a tutorial by https://www.youtube.com/@ModdingByKaupenjoe
// Video this code was borrowed from https://youtu.be/w2wyfFnPPmY
// This mod is a silly joke, so I don't really care about putting too much effort into it :)
// Some parts of this code have been modified by me

package net.misery.confighandler;

import java.util.ArrayList;
import java.util.List;
import com.mojang.datafixers.util.Pair;

public class configMod implements SimpleConfig.DefaultConfig {
    
    public String configContents = "";
    public String configHeaderText = "";

    public List<Pair> getConfigsList() {
        return configsList;
    }

    private final List<Pair> configsList = new ArrayList<>();

     public void addKeyValuePair(Pair<String, ?> keyValuePair, String comment) {
        configsList.add(keyValuePair);


        configContents +=  "#" + comment + "\n" + keyValuePair.getFirst() + "=" + keyValuePair.getSecond() + "\n";
    }
    
    @Override
    public String get(String namespace) {
        return configContents;
        
    }

        /* 
        "#DISCLAIMER: I'm not responsible for any damages this mod may cause to your game or your computer.\n" 
            + "#When setting values, don't set them too high, keep them under 1 million.\n" 
            + "#I don't know what happens if you set them too high, so be responsible.\n\n";
        */
}
