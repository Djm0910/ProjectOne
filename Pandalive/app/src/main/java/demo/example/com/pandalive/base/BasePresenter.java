package demo.example.com.pandalive.base;

/**
 * Created by 丁军明 on 2017/11/27.
 */

public abstract class BasePresenter<M, V> {
    public M baseModel;
    public V baseView;
    public void setVM(M m,V v){
        baseModel=m;
        baseView=v;
        this.onStart();
    }

    public abstract void onStart();
}
