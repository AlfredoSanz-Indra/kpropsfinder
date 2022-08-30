package es.kprops.core.di

import es.kprops.domain.api.antcases.AntUseCase
import es.kprops.domain.api.systemcases.SystemUseCase
import es.kprops.domain.usecases.antcases.AntUseCaseImpl
import es.kprops.domain.usecases.systemcases.SystemUseCaseImpl


/**
 * @author Alfredo Sanz
 * @time 2022
 */
object UseCaseFactory {

    private lateinit var antUseCase: AntUseCase
    private lateinit var systemUseCase: SystemUseCase

    fun getAntUseCase(): AntUseCase {
        if (!this::antUseCase.isInitialized) {
            this.antUseCase = AntUseCaseImpl()
        }
        return this.antUseCase
    }

    fun getSystemUseCase(): SystemUseCase {
        if (!this::systemUseCase.isInitialized) {
            this.systemUseCase = SystemUseCaseImpl()
        }
        return this.systemUseCase
    }
}