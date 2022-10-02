package com.example.collegeapp.features.article.data.dp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.collegeapp.features.article.data.model.entity.BookmarkEntity

@Dao
interface BookmarkDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookmark(bookmarkEntity: BookmarkEntity)

    @Query("DELETE FROM bookmark WHERE serverId = :serverId")
    suspend fun removeBookmarkByServerId(serverId: Int)

    @Query("SELECT COUNT(*) FROM bookmark WHERE serverId = :serverId")
    suspend fun howManyAreExist(serverId: Int): Int
}