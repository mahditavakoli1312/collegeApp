package com.example.collegeapp.features.article.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.collegeapp.features.article.data.model.entity.BookmarkEntity
import com.example.collegeapp.features.bookmark.data.model.relation.BookmarkWithArticle

@Dao
interface BookmarkDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBookmark(bookmarkEntity: BookmarkEntity)

    @Query("DELETE FROM bookmark WHERE serverId = :serverId")
    suspend fun removeBookmarkByServerId(serverId: Int)

    @Query("SELECT COUNT(*) FROM bookmark WHERE serverId = :serverId")
    suspend fun howManyAreExist(serverId: Int): Int

    @Query("SELECT * FROM bookmark")
    fun getBookmarkWithArticle(): List<BookmarkWithArticle>
}