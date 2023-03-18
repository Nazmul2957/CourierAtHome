package com.stitbd.courierathomemerchant.Activity;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.stitbd.courierathomemerchant.R;

public class MyAlertDialog {

    public TextView msgTextView, titleTextView,okButton, cancelButton;
    private ImageView imageView;
    private Dialog dialog;
    private View view;

    public MyAlertDialog(Context context){
        this.dialog = new Dialog(context);
        this.dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    public  void showConfirmDialog(String message, String okTitle, String cancelTitle) {
        this.dialog.setContentView(R.layout.alert_dialog_box);
        view = dialog.findViewById(R.id.dialogTitleView);
        titleTextView = dialog.findViewById(R.id.dialogTitleTextView);
        imageView = dialog.findViewById(R.id.dialogIconImageView);
        cancelButton = dialog.findViewById(R.id.dialogCancelButton);
        dialog.setCancelable(false);

        msgTextView = dialog.findViewById(R.id.dialogMessageTextView);
        okButton = dialog.findViewById(R.id.dialogOkButton);

//        titleTextView.setText("Confirm");
        msgTextView.setText(message);
        okButton.setText(okTitle);
//        cancelButton.setText(cancelTitle);

        if (dialog.getWindow() != null) {
            dialog.getWindow().setAttributes(getLayoutParams(dialog));

            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

            okButton.setOnClickListener(view ->MyAlertDialog.this.cancel());
        }
    }


    private WindowManager.LayoutParams getLayoutParams(@NonNull Dialog dialog) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        if (dialog.getWindow() != null) {
            layoutParams.copyFrom(dialog.getWindow().getAttributes());
        }
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        return layoutParams;
    }

    public void show() {
        if (dialog != null) {
            dialog.show();
        }
    }

    public Dialog getDialog() {
        return dialog;
    }

    public void cancel() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
