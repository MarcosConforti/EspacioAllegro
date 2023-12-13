package com.marcosconforti.espacioallegro.core.di

import android.content.Context
import androidx.room.Room
import com.marcosconforti.espacioallegro.register.data.database.RegisterUserDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val REGISTER_USER_DATABASE = "REGISTER_USER_DATA_BASE"

    @Singleton
    @Provides
    fun providesRoom(@ApplicationContext context: Context): RegisterUserDataBase {
        return Room.databaseBuilder(
            context,
            RegisterUserDataBase::class.java,
            REGISTER_USER_DATABASE
        ).build()
    }

    @Singleton
    @Provides
    fun provideUserDao(db: RegisterUserDataBase) = db.getRegisterUserDao()
}