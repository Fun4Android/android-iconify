package com.blackboardtheory.iconify

interface Icon {
    /** The key of icon, for example 'fa-ok' */
    var key: String

    /** The character matching the key in the font, for example '\u4354' */
    var character: Char
}