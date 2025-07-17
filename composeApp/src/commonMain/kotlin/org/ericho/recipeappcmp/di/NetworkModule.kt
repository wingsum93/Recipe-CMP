package org.ericho.recipeappcmp.di

import io.ktor.client.HttpClient
import org.koin.dsl.module
import org.ericho.recipeappcmp.features.common.data.api.httpClient

fun networkModule()  = module {

    single<HttpClient> {
        httpClient
    }
}