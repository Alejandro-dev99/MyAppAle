package myappaledone.myappale.features.mainmenu;

import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import myappaledone.myappale.R;
import myappaledone.myappale.WordSearchApp;
import myappaledone.myappale.easyadapter.MultiTypeAdapter;
import myappaledone.myappale.features.FullscreenActivity;
import myappaledone.myappale.features.ViewModelFactory;
import myappaledone.myappale.features.gamehistory.GameHistoryActivity;
import myappaledone.myappale.features.gameplay.GamePlayActivity;
import myappaledone.myappale.features.settings.SettingsActivity;
import myappaledone.myappale.model.GameTheme;

public class MainMenuActivity extends FullscreenActivity {

    //esto mio
    MediaPlayer mySound;
    //ya ta

    @BindView(R.id.rv) RecyclerView mRv;
    @BindView(R.id.game_template_spinner) Spinner mGridSizeSpinner;
   // mio  @BindView(R.id.new_game_btn) new new_game_btn;

    @BindArray(R.array.game_round_dimension_values)
    int[] mGameRoundDimVals;

    @Inject
    ViewModelFactory mViewModelFactory;
    MainMenuViewModel mViewModel;
    MultiTypeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        ButterKnife.bind(this);
        ((WordSearchApp) getApplication()).getAppComponent().inject(this);

        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MainMenuViewModel.class);
        mViewModel.getOnGameThemeLoaded().observe(this, this::showGameThemeList);


        mAdapter = new MultiTypeAdapter();
        mAdapter.addDelegate(
                GameTheme.class,
                R.layout.item_game_theme,
                (model, holder) -> holder.<TextView>find(R.id.textThemeName).setText(model.getName()),
                (model, view) -> Toast.makeText(MainMenuActivity.this, model.getName(), Toast.LENGTH_SHORT).show()
        );
        mAdapter.addDelegate(
                HistoryItem.class,
                R.layout.item_histories,
                (model, holder) -> {
                },
                (model, view) -> {
                    Intent i = new Intent(MainMenuActivity.this, GameHistoryActivity.class);
                    startActivity(i);
                }
        );

        //added this line lex
        mRv = findViewById(R.id.rv);
        mySound = MediaPlayer.create(this, R.raw.discotrompeta);
        mySound.start();



        mRv.setAdapter(mAdapter);
        mRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mViewModel.loadData();
    }

    public void showGameThemeList(List<GameTheme> gameThemes) {
        mAdapter.setItems(gameThemes);
        mAdapter.insertAt(0, new HistoryItem());
    }

    @OnClick(R.id.settings_button)
    public void onSettingsClick() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }


    @OnClick(R.id.new_game_btn)
    public void onNewGameClick() {
        int dim = mGameRoundDimVals[ mGridSizeSpinner.getSelectedItemPosition() ];
        Intent intent = new Intent(MainMenuActivity.this, GamePlayActivity.class);
        intent.putExtra(GamePlayActivity.EXTRA_ROW_COUNT, dim);
        intent.putExtra(GamePlayActivity.EXTRA_COL_COUNT, dim);
        startActivity(intent);
    }

     public void toggle(View view) {
        if (mySound==null) {
        mySound = MediaPlayer.create(this, R.raw.discotrompeta);
        mySound.start();
     }
        else {
        mySound.stop();


    } }
}
