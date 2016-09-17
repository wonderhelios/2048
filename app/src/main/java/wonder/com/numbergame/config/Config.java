package wonder.com.numbergame.config;

import android.app.Application;
import android.content.SharedPreferences;

import wonder.com.numbergame.R;

/**
 * Created by wonder on 2016/9/16.
 */
public class Config extends Application {
    /**
     * SP对象
     */
    public static SharedPreferences mSp;
    /**
     * Game Goal
     */
    public static int mGameGoal;
    /**
     * GameView行列数
     */
    public static int mGameLines;
    /**
     * Item宽高
     */
    public static int mItemSize;
    /**
     * 是否有Super权限
     */
    public static boolean mSuper = false;
    /**
     * 记录分数
     */
    public static int SCROE = 0;

    public static String SP_HIGH_SCROE = "SP_HIGHSCROE";
    public static String KEY_HIGH_SCROE = "KEY_HIGHSCROE";
    public static String KEY_GAME_LINES = "KEY_GAMELINES";
    public static String KEY_GAME_GOAL = "KEY_GAMEGOAL";

    @Override
    public void onCreate() {
        super.onCreate();
        mSp = getSharedPreferences(SP_HIGH_SCROE, 0);
        //获取储存的数据 设置缺省值
        mGameLines = mSp.getInt(KEY_GAME_LINES,4);
        mGameGoal = mSp.getInt(KEY_GAME_GOAL,2048);
        mItemSize = 0;
    }
}
