package com.marcosconforti.espacioallegro.register.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [RegisterUserEntities::class], version = 1)
abstract class RegisterUserDataBase : RoomDatabase() {
    abstract fun getRegisterUserDao(): RegisterUserDao
}