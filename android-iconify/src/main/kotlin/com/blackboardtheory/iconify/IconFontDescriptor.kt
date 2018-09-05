package com.blackboardtheory.iconify

interface IconFontDescriptor {
    /** The TTF file name - a name with no slash, present in the assets. **/
    var ttfFileName: String
    var characters: Array<Icon>
}