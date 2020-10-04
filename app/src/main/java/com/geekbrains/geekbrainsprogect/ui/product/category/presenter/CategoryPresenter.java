package com.geekbrains.geekbrainsprogect.ui.product.category.presenter;

import com.geekbrains.geekbrainsprogect.data.dagger.AppData;
import com.geekbrains.geekbrainsprogect.ui.product.category.view.CategoryView;
import com.geekbrains.geekbrainsprogect.ui.product.model.Category;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import retrofit2.Response;

@InjectViewState
public class CategoryPresenter extends MvpPresenter<CategoryView> {

    public CategoryPresenter()
    {
        getCategoryList();
    }

    private void getCategoryList()
    {
        Single<Response<List<Category>>> single = AppData.getApiHelper().getCategoryList();
        Disposable disposable = single.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(categoryResponse ->{
            if(categoryResponse.isSuccessful())
            {
                AppData.setCategoryList(categoryResponse.body());
                getViewState().setDataToAdapter(categoryResponse.body());
            }

        }, throwable -> {
            getViewState().showAlertDialog(throwable.getMessage());
        });
    }
}
