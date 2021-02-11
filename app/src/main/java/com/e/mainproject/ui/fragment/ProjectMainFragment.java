package com.e.mainproject.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.e.mainproject.BR;
import com.e.mainproject.R;
import com.e.mainproject.databinding.MainProjectFragmentBinding;
import com.e.mainproject.di.factory.DaggerViewModelFactory;
import com.e.mainproject.ui.base.BaseFragment;
import com.e.mainproject.ui.navigator.ProjectMainInterface;
import com.e.mainproject.ui.viewmodel.ProjectMainViewModel;

import javax.inject.Inject;

public class ProjectMainFragment extends BaseFragment<MainProjectFragmentBinding, ProjectMainViewModel> implements
        ProjectMainInterface {

    @Inject
    DaggerViewModelFactory providerFactory;
    private ProjectMainViewModel mViewModel;

    @Override
    public int getBindingVariable() {
        return BR.projectMainViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.main_project_fragment;
    }

    @Override
    public ProjectMainViewModel getViewModel() {
        mViewModel = new ViewModelProvider(this,providerFactory).get(ProjectMainViewModel.class);
        mViewModel.setNavigator(this);
        return mViewModel;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel.getDogFromApi();
    }

    @Override
    public void onError(String error) {
        Toast.makeText(getContext(),error, Toast.LENGTH_SHORT).show();
    }
}
