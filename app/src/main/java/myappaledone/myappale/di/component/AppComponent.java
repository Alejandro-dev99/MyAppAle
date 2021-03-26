package myappaledone.myappale.di.component;

import myappaledone.myappale.di.modules.AppModule;
import myappaledone.myappale.di.modules.DataSourceModule;
import myappaledone.myappale.features.FullscreenActivity;
import myappaledone.myappale.features.gamehistory.GameHistoryActivity;
import myappaledone.myappale.features.gameover.GameOverActivity;
import myappaledone.myappale.features.gameplay.GamePlayActivity;
import myappaledone.myappale.features.mainmenu.MainMenuActivity;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class, DataSourceModule.class})
public interface AppComponent {

    void inject(GamePlayActivity activity);

    void inject(MainMenuActivity activity);

    void inject(GameOverActivity activity);

    void inject(FullscreenActivity activity);

    void inject(GameHistoryActivity activity);

}
