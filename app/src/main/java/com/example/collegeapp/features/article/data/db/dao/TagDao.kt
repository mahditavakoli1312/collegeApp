package com.example.collegeapp.features.article.data.db.dao

import androidx.room.*
import com.example.collegeapp.features.article.data.model.entity.TagEntity

@Dao
interface TagDao {
    @Query("SELECT * FROM tags")
    suspend fun getAllTags(): List<TagEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTags(tags: List<TagEntity>): List<Long>

    @Query("SELECT * FROM tags WHERE isSelected == 1")
    fun getTagSelected(): List<TagEntity>?

    @Update
    fun updateTag(tag: TagEntity)

    @Update
    fun updateTags(tags: List<TagEntity>)

    @Query("SELECT * FROM tags WHERE isChecked == 1")
    fun getTagChecked(): List<TagEntity>?
}