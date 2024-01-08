package com.marcosconforti.espacioallegro.register.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RegisterUserDao {

    @Query("SELECT * FROM user_table")
    fun getUser(): Flow<List<RegisterUserEntities>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: RegisterUserEntities)

    @Query("DELETE FROM user_table")
    suspend fun deleteUser()
}