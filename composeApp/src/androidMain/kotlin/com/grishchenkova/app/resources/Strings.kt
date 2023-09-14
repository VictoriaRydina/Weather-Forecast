package com.grishchenkova.app.resources

import android.content.Context
import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.StringDesc

actual class Strings(
    private val context: Context
) {
    actual fun get(id: StringResource): String {
        return StringDesc.Resource(id).toString(context)
    }
}