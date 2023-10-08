package com.example.listadapterpractice

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table")
    fun getAllData() : List<UserEntity>

    @Query("SELECT * FROM user_table")
    fun getAllDataWithFlow() : Flow<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user : UserEntity)


}