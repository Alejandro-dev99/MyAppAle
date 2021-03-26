package myappaledone.myappale.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;

import myappaledone.myappale.features.ViewModelFactory;
import myappaledone.myappale.data.GameDataSource;
import myappaledone.myappale.data.GameThemeRepository;
import myappaledone.myappale.data.WordDataSource;
import myappaledone.myappale.features.gamehistory.GameHistoryViewModel;
import myappaledone.myappale.features.gameover.GameOverViewModel;
import myappaledone.myappale.features.gameplay.GamePlayViewModel;
import myappaledone.myappale.features.mainmenu.MainMenuViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class AppModule {

    private Application mApp;

    public AppModule(Application application) {
        mApp = application;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mApp;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    @Singleton
    ViewModelFactory provideViewModelFactory(GameDataSource gameDataSource,
                                             WordDataSource wordDataSource) {
        return new ViewModelFactory(
                new GameOverViewModel(gameDataSource),
                new GamePlayViewModel(gameDataSource, wordDataSource),
                new MainMenuViewModel(new GameThemeRepository()),
                new GameHistoryViewModel(gameDataSource)
        );
    }
}
