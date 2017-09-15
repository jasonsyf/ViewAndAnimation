package com.jason.viewandanimation.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jason.viewandanimation.R;

import org.w3c.dom.Text;

/**
 * Created by Jason_Sunyf on 2017/9/15 0015.
 * Email： jason_sunyf@163.com
 */

public class TitleBarView extends RelativeLayout {
    private Button mTitleLiftBtn;
    private Button mTitleRightBtn;
    private TextView mTitleText;




    public TitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initTypeArray(context, attrs);

    }

    private void initTypeArray(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.title_bar, this, true);
        mTitleLiftBtn = findViewById(R.id.title_bar_left);
        mTitleRightBtn = findViewById(R.id.title_bar_right);
        mTitleText = findViewById(R.id.title_bar_title);
        TypedArray arrtibutes = context.obtainStyledAttributes(attrs, R.styleable.title_bar_style);
        if (arrtibutes != null) {
            //处理titleBar背景色
            int titleBar_bg = arrtibutes.getResourceId(R.styleable.title_bar_style_title_bg, Color.GREEN);
//            setBackgroundResource(titleBar_bg);
            //左边按钮
            //是否visible
            boolean leftBtnVisible = arrtibutes.getBoolean(R.styleable.title_bar_style_left_btn_visible, true);
            if (leftBtnVisible) {
                mTitleLiftBtn.setVisibility(View.VISIBLE);
            } else {
                mTitleLiftBtn.setVisibility(View.INVISIBLE);
            }
            //左边按钮文字
            String leftBtnText = arrtibutes.getString(R.styleable.title_bar_style_left_btn_text);
            if (!TextUtils.isEmpty(leftBtnText)) {
                mTitleLiftBtn.setText(leftBtnText);
                //左边按钮背景颜色
                int leftBtnTextColor = arrtibutes.getColor(R.styleable.title_bar_style_left_btn_text_color, Color.GREEN);
                mTitleLiftBtn.setTextColor(leftBtnTextColor);
            } else {
                //要么是文字要么是图片
                int leftButtonDrawable = arrtibutes.getResourceId(
                        R.styleable.title_bar_style_left_btn_drawable, -1);
                if (leftButtonDrawable != -1) {
                    mTitleLiftBtn.setBackgroundResource(leftButtonDrawable);
                }

            }
            //处理标题   先处理是否要显示图片icon
            int titleTextDrawable = arrtibutes.getResourceId(
                    R.styleable.title_bar_style_title_text_drawable, -1);
            if (titleTextDrawable != -1) {
                mTitleText.setBackgroundResource(titleTextDrawable);
            } else {
                //标题不是图片  就设置文字标题
                String titleText = arrtibutes.getString(R.styleable.title_bar_style_title_text);
                if (!TextUtils.isEmpty(titleText)) {
                    mTitleText.setText(titleText);
                }
                int titleTextColor = arrtibutes.getColor(R.styleable.title_bar_style_title_text_color, Color.YELLOW);
                mTitleText.setTextColor(titleTextColor);
            }
            //处理右边按钮  先处理Visible
            boolean rightBtnVisible = arrtibutes.getBoolean(R.styleable.title_bar_style_right_btn_visible, true);
            if (rightBtnVisible) {
                mTitleRightBtn.setVisibility(View.VISIBLE);
            } else {
                mTitleRightBtn.setVisibility(View.INVISIBLE);
            }
            String rightBtnText = arrtibutes.getString(R.styleable.title_bar_style_right_btn_text);
            if (!TextUtils.isEmpty(rightBtnText)) {
                mTitleRightBtn.setText(rightBtnText);
                int rightBtnTextColor = arrtibutes.getColor(R.styleable.title_bar_style_right_btn_text_color, Color.LTGRAY);
                mTitleRightBtn.setTextColor(rightBtnTextColor);
            } else {
                //设置右边图片icon 这里是二选一 要么只能是文字 要么只能是图片
                int rightBtnDrawable = arrtibutes.getResourceId(R.styleable.title_bar_style_right_btn_drawable, -1);
                if (rightBtnDrawable != -1) {
                    mTitleRightBtn.setBackgroundResource(rightBtnDrawable);
                }

            }
            arrtibutes.recycle();
        }
    }

    public void setTitleClickListener(OnClickListener onClickListener) {
        if (onClickListener != null) {
            mTitleLiftBtn.setOnClickListener(onClickListener);
            mTitleRightBtn.setOnClickListener(onClickListener);
        }
    }


    public Button getTitleLiftBtn() {
        return mTitleLiftBtn;
    }

    public Button getTitleRightBtn() {
        return mTitleRightBtn;
    }

    public TextView getTitleText() {
        return mTitleText;
    }
}
