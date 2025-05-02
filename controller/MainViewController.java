package controller;

import viewmodel.MainViewModel;
public class MainViewController {
    private final MainViewModel viewModel = new MainViewModel();

    public void onUndo() {
        viewModel.undoLastAction();
    }

    public MainViewModel getViewModel() {
        return viewModel;
    }
}