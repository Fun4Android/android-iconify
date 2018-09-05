package com.blackboardtheory.iconify.internal

import android.content.Context
import android.graphics.Typeface
import com.blackboardtheory.iconify.Icon
import com.blackboardtheory.iconify.IconFontDescriptor

class IconFontDescriptorWrapper(val iconFontDescriptor: IconFontDescriptor) {

    private val iconsByKey: MutableMap<String, Icon> = HashMap()
    private var cachedTypeface: Typeface? = null

    init {
        iconFontDescriptor.characters.forEach {
            iconsByKey[it.key] = it
        }
    }

    fun getIcon(key: String): Icon? {
        return iconsByKey.get(key)
    }

    fun getTypeface(context: Context): Typeface {
        cachedTypeface?.let {
            return it
        }
        synchronized(this) {
            cachedTypeface?.let {
                return it
            }
            cachedTypeface = Typeface.createFromAsset(context.assets, iconFontDescriptor.ttfFileName)
            return cachedTypeface!!
        }
    }
}