package com.example.daggerapp

import android.app.Application
import android.content.ContentValues
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.annotation.RequiresApi
import com.example.daggerapp.di.scopes.PerActivity
import com.example.daggerapp.domain.ImageData
import javax.inject.Inject

@PerActivity
class Presenter @Inject constructor(
    private val app: Application
) : PresenterInterface {

    var showToast: ((Int) -> Unit)? = null

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun clickBtn() {
        val imagesList = mutableListOf<ImageData>()

        val collection = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            MediaStore.Images.Media.getContentUri(
                MediaStore.VOLUME_EXTERNAL
            )
        } else {
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        }

        val projection = arrayOf(
            MediaStore.Images.Media._ID,
            MediaStore.Images.Media.DISPLAY_NAME,
            MediaStore.Images.Media.SIZE
        )

        val sortOrder = "${MediaStore.Images.Media.DISPLAY_NAME} ASC"

        val query = app.contentResolver.query(
            collection,
            projection,
            null,
            null,
            sortOrder
        )

        query?.use { cursor ->
            val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
            val nameColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME)
            val sizeColumn = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.SIZE)

            while (cursor.moveToNext()) {
                val id = cursor.getLong(idColumn)
                val name = cursor.getString(nameColumn)
                val size = cursor.getInt(sizeColumn)

                val photoUri: Uri = Uri.withAppendedPath(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    cursor.getString(idColumn)
                )

                imagesList += ImageData(photoUri, name, size)
            }
        }

//        val images = ArrayList<String>()
//        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
//        val projection = arrayOf(MediaStore.MediaColumns.DATA,
//            MediaStore.Images.Media.BUCKET_DISPLAY_NAME,
//            MediaStore.Images.Media.WIDTH,
//            MediaStore.Images.Media.HEIGHT)
//
//        app.contentResolver
//            .query(uri,
//                projection,
//                null,
//                null,
//                MediaStore.MediaColumns.DATE_ADDED + " DESC")
//            ?.apply {
//                val columnIndexData = getColumnIndexOrThrow(MediaStore.MediaColumns.DATA)
//                val columnIndexWidth = getColumnIndex(MediaStore.MediaColumns.WIDTH)
//                val columnIndexHeight = getColumnIndex(MediaStore.MediaColumns.HEIGHT)
//                while (moveToNext()) {
//                    val width = getInt(columnIndexWidth)
//                    val height = getInt(columnIndexHeight)
//                    //не добавляем некорректные изображения
//                    if (width > 0 && height > 0) {
//                        val absolutePathOfImage = getString(columnIndexData)
//                        images.add(absolutePathOfImage)
//                    }
//                }
//                close()
//            }

        showToast?.invoke(imagesList.count())
    }
}