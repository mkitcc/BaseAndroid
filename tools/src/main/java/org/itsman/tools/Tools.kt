package org.itsman.tools

import android.content.Context
import android.widget.Toast


fun toast(c: Context, str: String) {
    Toast.makeText(c, str, Toast.LENGTH_LONG).show()
}