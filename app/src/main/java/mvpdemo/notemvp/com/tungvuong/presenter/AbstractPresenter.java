package mvpdemo.notemvp.com.tungvuong.presenter;

import mvpdemo.notemvp.com.tungvuong.MainContract;

public abstract class AbstractPresenter implements MainContract.Presenter {  AbstractPresenter(){ }

    @Override
    public void onStop() { }

    @Override
    public void onStart() { }

}
