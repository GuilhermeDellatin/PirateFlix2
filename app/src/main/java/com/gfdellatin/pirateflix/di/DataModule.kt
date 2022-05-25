package com.gfdellatin.pirateflix.di

import com.gfdellatin.pirateflix.data.api.DiscoverAPI
import com.gfdellatin.pirateflix.network.ServiceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DataModule {

    @Provides
    fun providesDiscoverApi(
        serviceProvider: ServiceProvider
    ): DiscoverAPI {
        return serviceProvider.createService(DiscoverAPI::class.java)
    }
}