package com.carbon.survey.data.storage

interface Storage<E: Any> {

    fun store(data: E)

    fun get(): E
}