package com.akash.cryptoinfo.di

import com.akash.cryptoinfo.common.Constants
import com.akash.cryptoinfo.data.remote.CoinPaprikaApi
import com.akash.cryptoinfo.data.repository.CoinRepositoryImpl
import com.akash.cryptoinfo.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesPaprikaApi():CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api:CoinPaprikaApi) : CoinRepository {
        return CoinRepositoryImpl(api)
    }
}