package com.grishchenkova.app.resources

import dev.icerock.moko.resources.StringResource
import dev.icerock.moko.resources.desc.Resource
import dev.icerock.moko.resources.desc.StringDesc

actual class Strings {
    actual fun get(id: StringResource): String {
        return StringDesc.Resource(id).localized()
    }
}