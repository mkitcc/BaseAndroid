package org.itsman.baseandroid.Tools

import android.content.Context
import android.widget.Toast


fun toast(c: Context) {
    Toast.makeText(c, "Toast", Toast.LENGTH_LONG).show()
}