package com.gfdellatin.pirateflix.di

import com.gfdellatin.pirateflix.data.DiscoveryRepository
import com.gfdellatin.pirateflix.data.DiscoveryRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindsDiscoveryRepository(
        discoveryRepositoryImpl: DiscoveryRepositoryImpl
    ): DiscoveryRepository
}