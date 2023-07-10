package org.example.services

import io.micronaut.context.annotation.Bean
import org.example.connectors.GenericConnector

@Bean
class ServiceImpl(val connector: GenericConnector) : Service {
    override fun getValue(): String {
        return connector.returnCall()
    }
}