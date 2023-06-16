// This is a borrowed code from a tutorial by https://www.youtube.com/@ModdingByKaupenjoe
// Video this code was borrowed from https://youtu.be/w2wyfFnPPmY
// This mod is a silly joke, so I don't really care about putting too much effort into it :)

package net.misery.confighandler;

import java.util.ArrayList;
import java.util.List;
import com.mojang.datafixers.util.Pair;

public class configMod implements SimpleConfig.DefaultConfig {
    
    private String configContents = "";

    public List<Pair> getConfigsList() {
        return configsList;
    }

    private final List<Pair> configsList = new ArrayList<>();

     public void addKeyValuePair(Pair<String, ?> keyValuePair, String comment) {
        configsList.add(keyValuePair);
        configContents += keyValuePair.getFirst() + "=" + keyValuePair.getSecond() + " #"
                + comment + " | default: " + keyValuePair.getSecond() + "\n";
    }
        
    
    @Override
    public String get(String namespace) {
        return configContents;
    }
}
