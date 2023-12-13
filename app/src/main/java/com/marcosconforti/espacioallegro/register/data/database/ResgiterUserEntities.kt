package com.marcosconforti.espacioallegro.register.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class RegisterUserEntities(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id:Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "lastName") val lastName: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "password") val password: String
    )

//Posible mapeo
/*fun NewUserModel.toUserDataBase() = RegisterUserEntities(
    id = id.toInt(),
    name = name,
    lastName = lastName,
    email = email,
    password = password,

)*/