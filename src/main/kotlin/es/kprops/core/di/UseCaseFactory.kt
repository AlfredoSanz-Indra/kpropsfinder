package es.kprops.core.di

import es.kprops.domain.api.antcases.AntUseCase
import es.kprops.domain.usecases.antcases.AntUseCaseImpl


/**
 * @author Alfredo Sanz
 * @time 2022
 */
object UseCaseFactory {

    private lateinit var antUseCase: AntUseCaseImpl

    fun getAntUseCase(): AntUseCase {
        if (!this::antUseCase.isInitialized) {
            this.antUseCase = AntUseCaseImpl()
        }
        return this.antUseCase
    }
}