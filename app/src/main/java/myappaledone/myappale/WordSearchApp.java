package myappaledone.myappale;

import android.app.Application;

import myappaledone.myappale.di.component.AppComponent;
import myappaledone.myappale.di.component.DaggerAppComponent;
import myappaledone.myappale.di.modules.AppModule;



public class WordSearchApp extends Application {

    AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}
