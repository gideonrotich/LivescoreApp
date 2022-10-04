package com.example.livescore.local

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.room.TypeConverter
import androidx.test.core.app.ApplicationProvider
import com.example.livescore.data.local.converters.Converters
import com.example.livescore.data.local.dao.MatchesDao
import com.example.livescore.data.local.db.LivescoreDatabase
import com.example.resources.fakeMatch
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import java.io.IOException
import kotlin.jvm.Throws

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@Config(manifest=Config.NONE)
class MatchesDaoTest {
    private lateinit var database:LivescoreDatabase
    private lateinit var matchesDao: MatchesDao

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun Setup(){

        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context,LivescoreDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        matchesDao = database.MatchesDao()

    }

    @Test
    fun `store matches in LivescoreDatabase`() = runTest {
        matchesDao.insertMatches(listOf(fakeMatch))

        val match = matchesDao.getMatches()

        Truth.assertThat(match).isEqualTo(fakeMatch)
    }

    @Test
    fun `delete matches in LivescoreAppDatabase`() = runTest {
        matchesDao.insertMatches(listOf(fakeMatch))

        matchesDao.deleteMatches()

        val match = matchesDao.getMatches()

        Truth.assertThat(match).isEmpty()
    }

    @After
    @Throws(IOException::class)
    fun tearDown(){
        database.clearAllTables()
        database.close()
    }
}