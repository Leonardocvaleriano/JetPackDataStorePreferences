package com.codeplace.jetpackdatastorepreferences.di

import android.app.Application
import android.content.Context
import com.codeplace.jetpackdatastorepreferences.data.DataStoreRepository
import com.codeplace.jetpackdatastorepreferences.ui.theme.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel

import org.koin.dsl.module




val appModule = module {
    single {DataStoreRepository(context = androidContext()) }
    viewModel {HomeViewModel(get())}
}