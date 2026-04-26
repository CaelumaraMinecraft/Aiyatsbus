package cc.polarastrum.aiyatsbus.core.util

import net.kyori.adventure.key.Key

/**
 * 命名空间路径的最小化字符串表现
 *
 * 若命名空间为 [Key.MINECRAFT_NAMESPACE] 仅返回命名空间的路径, 否则返回包含命名空间的字符串.
 */
fun String.minimizeIdentifierString(): String {
    val key = net.kyori.adventure.key.Key.key(this)
    return key.minimizeString()
}

fun Key.minimizeString(): String {
    return if (this.namespace() == Key.MINECRAFT_NAMESPACE) this.value() else this.asString()
}
