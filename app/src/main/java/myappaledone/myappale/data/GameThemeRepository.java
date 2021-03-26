package myappaledone.myappale.data;

import myappaledone.myappale.model.GameTheme;

import java.util.ArrayList;
import java.util.List;

public class GameThemeRepository {

    public List<GameTheme> getGameThemes() {
        // sample data
        List<GameTheme> themes = new ArrayList<>();
        themes.add(new GameTheme(1, "Discover the Bass & Guitar instrument parts"));
        themes.add(new GameTheme(2, "Discover new Percussion instruments"));
        themes.add(new GameTheme(3, "Discover the Contrabass instrument parts"));
        themes.add(new GameTheme(4, "Expand your Musical language"));


        return themes;
    }

}
