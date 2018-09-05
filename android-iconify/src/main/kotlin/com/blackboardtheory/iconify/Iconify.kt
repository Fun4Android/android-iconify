package com.blackboardtheory.iconify

import android.widget.TextView
import com.blackboardtheory.iconify.internal.IconFontDescriptorWrapper

class Iconify {

    companion object {
        private val iconFontDescriptors: MutableList<IconFontDescriptorWrapper> = ArrayList()

        /**
         * Add support for a new icon font.
         * @param iconFontDescriptor The IconDescriptor holding the ttf file reference and its mappings.
         * @return An initializer instance for chain calls.
         */
        fun with(iconFontDescriptor: IconFontDescriptor): IconifyInitializer {
            return IconifyInitializer(iconFontDescriptor)
        }

        fun addIcons(vararg textViews: TextView) {
            textViews.filterNotNull().forEach {

            }
        }

        private fun addIconFontDescriptor(iconFontDescriptor: IconFontDescriptor) {
            // perform this check so we don't add duplicates
            if(iconFontDescriptors.filter{it.iconFontDescriptor.ttfFileName == iconFontDescriptor.ttfFileName}.isNotEmpty()) {
                return
            }
            iconFontDescriptors.add(IconFontDescriptorWrapper(iconFontDescriptor))
        }

        /**
         * Allows chain calls on {@link Iconify#with(IconFontDescriptor)}.
         */
        class IconifyInitializer(iconFontDescriptor: IconFontDescriptor) {

            init {
                Iconify.addIconFontDescriptor(iconFontDescriptor)
            }

            /**
             * Add support for a new icon font.
             * @param iconFontDescriptor The IconDescriptor holding the ttf file reference and its mappings.
             * @return An initializer instance for chain calls.
             */
            fun with(iconFontDescriptor: IconFontDescriptor): IconifyInitializer {
                Iconify.addIconFontDescriptor(iconFontDescriptor)
                return this
            }
        }

        /**
         * Finds the Typeface to apply for a given icon.
         * @param icon The icon for which you need the typeface.
         * @return The font descriptor which contains info about the typeface to apply, or null
         * if the icon cannot be found. In that case, check that you properly added the modules
         * using {@link #with(IconFontDescriptor)}} prior to calling this method.
         */
        fun findTypefaceOf(icon: Icon): IconFontDescriptorWrapper? {
            val possibleDescriptors =  iconFontDescriptors.filter{it.getIcon(icon.key) != null}
            return if(possibleDescriptors.isEmpty()) null else possibleDescriptors.first()
        }

        /**
         * Retrieve an icon from a key,
         * @return The icon, or null if no icon matches the key.
         */
        fun findIconForKey(iconKey: String): Icon? {
            val possibleDescriptors = iconFontDescriptors.filter {it.getIcon(iconKey) != null}
            return if(possibleDescriptors.isEmpty()) null else possibleDescriptors.first().getIcon(iconKey)
        }
    }

}