package mvpdemo.notemvp.com.tungvuong.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import mvpdemo.notemvp.com.tungvuong.presenter.Presenter;

public abstract class AbstractActivity extends AppCompatActivity implements View {
    private ProgressDialog mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    abstract Presenter getPresenter();

    @Override
    protected void onStart() {
        super.onStart();
        if (getPresenter() != null) {
            getPresenter().onStart();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (getPresenter() != null) {
            getPresenter().onStop();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    public void showToast(String text) {
        if (text == null || text.isEmpty()) return;
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    @Override
    public void startLoading() {
        if (mDialog != null && mDialog.isShowing()) {
            return;
        }
        mDialog = new ProgressDialog(this);
        mDialog.setMessage("Đang tải...");
        mDialog.setCancelable(false);
        mDialog.show();

    }

    @Override
    public void stopLoading() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

}
