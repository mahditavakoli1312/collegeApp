package com.example.collegeapp.features.article.data.datasource.local

import android.nfc.Tag
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.collegeapp.features.article.data.model.TagEntity

@Dao
interface TagDao{
    @Query("SELECT * FROM tags")
    fun getAllTags(): LiveData<List<TagEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTags(tags : List<TagEntity>)
}