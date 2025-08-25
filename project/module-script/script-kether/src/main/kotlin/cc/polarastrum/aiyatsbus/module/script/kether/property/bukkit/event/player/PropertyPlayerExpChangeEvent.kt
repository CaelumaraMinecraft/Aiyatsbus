package cc.polarastrum.aiyatsbus.module.script.kether.property.bukkit.event.player

import cc.polarastrum.aiyatsbus.core.util.coerceInt
import cc.polarastrum.aiyatsbus.module.script.kether.AiyatsbusGenericProperty
import cc.polarastrum.aiyatsbus.module.script.kether.AiyatsbusProperty
import org.bukkit.event.player.PlayerExpChangeEvent
import taboolib.common.OpenResult

@AiyatsbusProperty(
    id = "player-exp-change-event",
    bind = PlayerExpChangeEvent::class
)
class PropertyPlayerExpChangeEvent : AiyatsbusGenericProperty<PlayerExpChangeEvent>("player-exp-change-event") {
    override fun readProperty(instance: PlayerExpChangeEvent, key: String): OpenResult {
        val property: Any? = when (key) {
            "source" -> instance.source
            "amount", "exp" -> instance.amount
            else -> return OpenResult.failed()
        }
        return OpenResult.successful(property)
    }

    override fun writeProperty(instance: PlayerExpChangeEvent, key: String, value: Any?): OpenResult {
        when (key) {
            "amount", "exp" -> instance.amount = value?.coerceInt() ?: return OpenResult.successful()
            else -> return OpenResult.failed()
        }
        return OpenResult.successful()
    }
}