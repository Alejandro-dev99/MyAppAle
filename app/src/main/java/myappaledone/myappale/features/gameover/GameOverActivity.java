package myappaledone.myappale.features.gameover;

import androidx.core.app.NavUtils;
import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import org.jetbrains.annotations.NotNull;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import myappaledone.myappale.R;
import myappaledone.myappale.features.ViewModelFactory;
import myappaledone.myappale.WordSearchApp;
import myappaledone.myappale.commons.DurationFormatter;
import myappaledone.myappale.model.GameDataInfo;
import myappaledone.myappale.features.FullscreenActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GameOverActivity extends FullscreenActivity {
    public static final String EXTRA_GAME_ROUND_ID =
            "com.paperplanes.wordsearch.presentation.ui.activity.GameOverActivity";

    @Inject
    ViewModelFactory mViewModelFactory;

    @BindView(R.id.game_stat_text)
    TextView mGameStatText;

    private int mGameId;
    private GameOverViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        ButterKnife.bind(this);
        ((WordSearchApp) getApplication()).getAppComponent().inject(this);

        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(GameOverViewModel.class);
        mViewModel.getOnGameDataInfoLoaded().observe(this, this::showGameStat);

        if (getIntent().getExtras() != null) {
            mGameId = getIntent().getExtras().getInt(EXTRA_GAME_ROUND_ID);
            mViewModel.loadData(mGameId);
        }
    }

    @OnClick(R.id.main_menu_btn)
    public void onMainMenuClick() {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        goToMainMenu();
    }

    private void goToMainMenu() {
        if (getPreferences().deleteAfterFinish()) {
            mViewModel.deleteGameRound(mGameId);
        }
        NavUtils.navigateUpTo(this, new Intent());
        finish();
    }

    public void showGameStat(GameDataInfo info) {
        String strGridSize = info.getGridRowCount() + " x " + info.getGridColCount();

        String str = getString(R.string.finish_text);
        str = str.replaceAll(":gridSize", strGridSize);
        str = str.replaceAll(":uwCount", String.valueOf(info.getUsedWordsCount()));
        str = str.replaceAll(":duration", DurationFormatter.fromInteger(info.getDuration()));
        //addded
        List<String> list = new ArrayList<String>();
        list.add("about String Instruments");  //https://www.vocabulary.cl/english/musical-instruments.htm
        list.add("about Percussion"); // https://en.wikipedia.org/wiki/List_of_percussion_instruments
        list.add("about the Music Language");// https://en.wikipedia.org/wiki/Glossary_of_music_terminology
        list.add("about Brass Instruments");
        list.add("about the Music Notes");
        list.add("about who made this app");
        String random = list.get(new Random().nextInt(list.size()));
        str = str.replaceAll(":random", random);

        //btGetUrlString = findViewById(R.id.btgeturlstring);

//hasta aqui
        mGameStatText.setText(str);
    }
}
