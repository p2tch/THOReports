package xyz.thehiddenobject.thoreports.common.configuration

import eu.okaeri.configs.OkaeriConfig

class GeneralConfiguration: OkaeriConfig() {
    lateinit var databaseConfiguration: DatabaseConfiguration
        private set
}