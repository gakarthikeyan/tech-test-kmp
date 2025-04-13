package com.karthik.android.techtestkmp.di

import com.karthik.android.techtestkmp.data.repository.BookRepositoryImpl
import com.karthik.android.techtestkmp.domain.repository.BookRepository
import com.karthik.android.techtestkmp.presentation.book.BookViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
/**
 * POC of Kotlin Multiplatform (Core Module)
 *
 * Koin DI module to inject
 * network module, repository implementations and
 * view models
 */
val sharedModule = module {
    includes(networkModule)
    single<BookRepository> { BookRepositoryImpl(get()) }
    single { BookViewModel(get()) }
}