package com.grishchenkova.app.resources

import dev.icerock.moko.resources.StringResource

expect class Strings {
    fun get(id: StringResource) : String
}