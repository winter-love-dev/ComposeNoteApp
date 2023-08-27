package com.season.winter.composenoteapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.season.winter.composenoteapp.constants.DatabaseName_Note
import com.season.winter.composenoteapp.data.NoteDatabaseDao
import com.season.winter.composenoteapp.model.NoteEntity

@Database(
    entities = [
        NoteEntity::class,
        // SomeOtherDataClass::class,
    ],
    version = 1,
    exportSchema = false
)
//@TypeConverters(SomeConverter::class)
abstract class NoteDatabase: RoomDatabase() {

    abstract fun noteDao(): NoteDatabaseDao

    companion object {

        @Volatile
        private var instance: NoteDatabase? = null

        fun getInstance(context: Context): NoteDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): NoteDatabase {
            return Room.databaseBuilder(
                context,
                NoteDatabase::class.java,
                DatabaseName_Note
            )
//                .addTypeConverter(RemoteConfigConverters)
                .addCallback(
                    object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                        }
                    }
                )
                .build()
        }

    }

}