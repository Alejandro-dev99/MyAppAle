package myappaledone.myappale.di.modules;

import android.content.Context;

import myappaledone.myappale.data.sqlite.DbHelper;
import myappaledone.myappale.data.sqlite.GameDataSQLiteDataSource;
import myappaledone.myappale.data.xml.WordXmlDataSource;
import myappaledone.myappale.data.GameDataSource;
import myappaledone.myappale.data.WordDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class DataSourceModule {

    @Provides
    @Singleton
    DbHelper provideDbHelper(Context context) {
        return new DbHelper(context);
    }

    @Provides
    @Singleton
    GameDataSource provideGameRoundDataSource(DbHelper dbHelper) {
        return new GameDataSQLiteDataSource(dbHelper);
    }

//    @Provides
//    @Singleton
//    WordDataSource provideWordDataSource(DbHelper dbHelper) {
//        return new WordSQLiteDataSource(dbHelper);
//    }

    @Provides
    @Singleton
    WordDataSource provideWordDataSource(Context context) {
        return new WordXmlDataSource(context);
    }

}
