package com.example.livescore.di

import android.content.Context
import androidx.room.Room
import com.example.livescore.data.local.converters.Converters
import com.example.livescore.data.local.db.LivescoreDatabase
import com.example.livescore.data.remote.api.LivescoreApi
import com.example.livescore.data.remote.repository.MatchesRepositoryImpl
import com.example.livescore.domain.repository.MatchesRepository
import com.example.livescore.util.Constants
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideGson() = Gson()

    @Provides
    @Singleton
    fun provideConverters(gson: Gson) = Converters(gson)

    @Provides
    @Singleton
    fun provideForbesDatabase(
        @ApplicationContext context: Context,
        converters: Converters
    ): LivescoreDatabase {
        return Room.databaseBuilder(
            context,
            LivescoreDatabase::class.java,
            "livescore_db"
        )
            .addTypeConverter(converters)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideLIvescoreRepository(
        livescoreApi:LivescoreApi,
        livescoreDatabase: LivescoreDatabase
    ):MatchesRepository{
            return MatchesRepositoryImpl(
            livescoreApi = livescoreApi,
            matchesDao = livescoreDatabase.MatchesDao(),
                matchDetailsDao = livescoreDatabase.MatchDetailsDao()
        )
    }

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideForbesListApi(okHttpClient: OkHttpClient): LivescoreApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(LivescoreApi::class.java)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .callTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
        return okHttpClient.build()
    }

}