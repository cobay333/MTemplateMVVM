package com.template.view;

import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.template.R;

public class LoadingDialog extends Dialog {

    /**
     * @param context
     * @param color   ContextCompat.getColor(this,R.color.colorAccent)
     */
    public LoadingDialog(Context context, int color) {
        super(context, R.style.loadingDiaLogStyle);
        View view = LayoutInflater.from(context).inflate(R.layout.loading_dialog, null);

        LoadingView loadingView = view.findViewById(R.id.loadingView);
        loadingView.setPaintColor(color);

        //设置半透明
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.6f;
        getWindow().setAttributes(lp);

        setCancelable(false);
        setContentView(view);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                dismiss();
                break;
        }
        return super.onKeyUp(keyCode, event);
    }

}
