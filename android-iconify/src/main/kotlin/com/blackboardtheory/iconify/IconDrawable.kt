package com.blackboardtheory.iconify

import android.content.Context
import android.graphics.drawable.Drawable

class IconDrawable : Drawable {

    lateinit var context: Context
    lateinit var icon: Icon

    constructor(context: Context, icon: Icon) {
        this.context = context
        this.icon = icon
    }

    constructor(context: Context, iconKey: String) {

    }

}