package com.example.todo.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class Task(

    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,
    var text: String? = null,
    var timeStamp: Long = System.currentTimeMillis(),
    var scheduledTime: String? = null,
    var scheduledDate: String? = null,
    var done: Boolean = false  //for future option "completed"
) : Parcelable {

}
