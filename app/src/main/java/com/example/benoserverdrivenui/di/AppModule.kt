package com.example.benoserverdrivenui.di


import com.example.benoserverdrivenui.data.remote.Api
import com.example.benoserverdrivenui.data.repository.SDUIRepositoryImp
import com.example.benoserverdrivenui.domain.repository.SDUIRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASEURL = "https://gist.githubusercontent.com/yousefbilal/d99cc28b8abc25bce8f4b321cb3cd2ec/raw/5b51c8750a070eb63bd92ded3c173592ca450cf7/"

    @Provides
    @Singleton
    fun provideApi(): Api {
        return Retrofit.Builder()
            .baseUrl(BASEURL)
            .build()
            .create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideSDUIRepository(api: Api): SDUIRepository {
        return SDUIRepositoryImp(api)
    }


}