package com.app.data.di

import com.app.data.BuildConfig
import com.app.data.datasource.remote.network.ApiServices
import com.app.data.datasource.remote.network.InterHeader
//import androidx.room.Room//**
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@ComponentScan("com.app.data")
class DataModule {
    @Single
    fun providesInterceptor(): InterHeader =
        InterHeader()

    @Single
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Single
    fun providesOkHttpClient(
      httpLoggingInterceptor: HttpLoggingInterceptor,
      interHeader: InterHeader
    ): OkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(interHeader)
        .apply {
            if (BuildConfig.DEBUG) {
                addInterceptor(
                    httpLoggingInterceptor
                )
            }
        }
        .build()

    @Single
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .build()


    @Single
    fun provideCharacterService(retrofit: Retrofit): ApiServices =
        retrofit.create(ApiServices::class.java)



//    @Single
//    fun provideGenreDao(db: AppDatabase): TestDao = db.testDao()
//**
//    @Single
//    fun provideDatabase(application: Application): AppDatabase {
//        return Room.databaseBuilder(application, AppDatabase::class.java, "RoomDatabase")
//            //.fallbackToDestructiveMigration()
//            .allowMainThreadQueries()
//            .build()
//    }



}
