package wonder.com.numbergame.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.DialogPreference;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import wonder.com.numbergame.R;
import wonder.com.numbergame.config.Config;

/**
 * Created by wonder on 2016/9/16.
 */
//public class ConfigPreference extends Activity implements View.OnClickListener {
//    private Button mBtnGameLines;
//    private Button mBtnGoal;
//    private Button mBtnBack;
//    private Button mBtnDone;
//    private String[] mGameLinesList;
//    private String[] mGameGoalList;
//    private AlertDialog.Builder mBuilder;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//        setContentView(R.layout.config_preference);
//        initView();
//    }
//    public void initView()
//    {
//        mBtnGameLines = (Button)findViewById(R.id.btn_gamelines);
//        mBtnGoal = (Button)findViewById(R.id.btn_goal);
//        mBtnBack = (Button)findViewById(R.id.btn_back);
//        mBtnDone = (Button)findViewById(R.id.btn_done);
//        mBtnGameLines.setText("" + Config.mGameLines);
//        mBtnGoal.setText("" + Config.mGameGoal);
//        mBtnGameLines.setOnClickListener(this);
//        mBtnGoal.setOnClickListener(this);
//        mBtnBack.setOnClickListener(this);
//        mBtnDone.setOnClickListener(this);
//        mGameLinesList = new String[]{"4","5","6"};
//        mGameLinesList = new String[]{"1024","2048","4096"};
//    }
//    private void saveConfig()
//    {
//        SharedPreferences.Editor editor = Config.mSp.edit();
//        editor.putInt(Config.KEY_GAME_LINES,
//                Integer.parseInt(mBtnGameLines.getText().toString()));
//        editor.putInt(Config.KEY_GAME_GOAL,
//                Integer.parseInt(mBtnGoal.getText().toString()));
//        editor.commit();
//    }
//    @Override
//    public void onClick(View view) {
//        switch (view.getId())
//        {
//            case R.id.btn_gamelines:
//                mBuilder = new AlertDialog.Builder(this);
//                mBuilder.setTitle("choose the lines of game.");
//                mBuilder.setItems(mGameGoalList,
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                mBtnGameLines.setText(mGameGoalList[i]);
//                            }
//                        });
//                mBuilder.create().show();
//                break;
//            case R.id.btn_goal:
//                mBuilder = new AlertDialog.Builder(this);
//                mBuilder.setTitle("choose the goal.");
//                mBuilder.setItems(mGameGoalList,
//                        new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                mBtnGoal.setText(mGameGoalList[i]);
//                            }
//                        });
//                mBuilder.create().show();
//                break;
//            case R.id.btn_back:
//                this.finish();
//                break;
//            case R.id.btn_done:
//                saveConfig();
//                setResult(RESULT_OK);
//                this.finish();
//                break;
//            default:
//                break;
//        }
//    }
//}
public class ConfigPreference extends Activity implements View.OnClickListener {

    private Button mBtnGameLines;

    private Button mBtnGoal;

    private Button mBtnBack;

    private Button mBtnDone;

    private Button mBtnSupper;

    private String[] mGameLinesList;

    private String[] mGameGoalList;

    private AlertDialog.Builder mBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_preference);
        initView();
    }

    private void initView() {
        mBtnGameLines = (Button) findViewById(R.id.btn_gamelines);
        mBtnGoal = (Button) findViewById(R.id.btn_goal);
        mBtnBack = (Button) findViewById(R.id.btn_back);
        mBtnDone = (Button) findViewById(R.id.btn_done);
        mBtnGameLines.setText("" + Config.mSp.getInt(Config.KEY_GAME_LINES, 4));
        mBtnGoal.setText("" + Config.mSp.getInt(Config.KEY_GAME_GOAL, 2048));
        mBtnGameLines.setOnClickListener(this);
        mBtnGoal.setOnClickListener(this);
        mBtnBack.setOnClickListener(this);
        mBtnDone.setOnClickListener(this);
        mGameLinesList = new String[]{"4", "5", "6"};
        mGameGoalList = new String[]{"1024", "2048", "4096"};
        setSupper();
    }
    public void setSupper(){
        mBtnSupper = (Button) findViewById(R.id.btn_super);
        mBtnSupper.setOnClickListener(this);
        if(Config.mSuper) {
            mBtnSupper.setBackgroundColor(getResources()
                    .getColor(R.color.isSupper));
        }else {
            mBtnSupper.setBackgroundColor(getResources()
                    .getColor(R.color.notSupper));
        }
    }
    private void saveConfig() {
        SharedPreferences.Editor editor = Config.mSp.edit();
        editor.putInt(Config.KEY_GAME_LINES,
                Integer.parseInt(mBtnGameLines.getText().toString()));
        editor.putInt(Config.KEY_GAME_GOAL,
                Integer.parseInt(mBtnGoal.getText().toString()));
        editor.commit();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_gamelines:
                mBuilder = new AlertDialog.Builder(this);
                mBuilder.setTitle("choose the lines of the game");
                mBuilder.setItems(mGameLinesList,
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mBtnGameLines.setText(mGameLinesList[which]);
                            }
                        });
                mBuilder.create().show();
                break;
            case R.id.btn_goal:
                mBuilder = new AlertDialog.Builder(this);
                mBuilder.setTitle("choose the goal of the game");
                mBuilder.setItems(mGameGoalList,
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mBtnGoal.setText(mGameGoalList[which]);
                            }
                        });
                mBuilder.create().show();
                break;
            case R.id.btn_super:
                Config.mSuper = !Config.mSuper;
                this.finish();
                break;
            case R.id.btn_back:
                this.finish();
                break;
            case R.id.btn_done:
                saveConfig();
                setResult(RESULT_OK);
                this.finish();
                break;
            default:
                break;
        }
    }
}
