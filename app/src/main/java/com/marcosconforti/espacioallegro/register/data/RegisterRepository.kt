package com.marcosconforti.espacioallegro.register.data

import com.marcosconforti.espacioallegro.register.data.database.RegisterUserDao
import com.marcosconforti.espacioallegro.register.data.database.RegisterUserEntities
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RegisterRepository @Inject constructor(private val dao: RegisterUserDao) {

    fun getUserFromDataBase(): Flow<List<RegisterUserEntities>> {
        return dao.getUser()
    }

    suspend fun insertUser(user:RegisterUserEntities) = dao.insertUser(user)

    suspend fun deleteUser() = dao.deleteUser()
}