package es.kprops.core.di

import es.kprops.domain.usecases.antcases.AntUseCaseImpl


object UseCaseFactory {

    private lateinit var antUseCase: AntUseCaseImpl

    fun getAntUseCase(): AntUseCaseImpl {
        if (!this::antUseCase.isInitialized) {
            this.antUseCase = AntUseCaseImpl()
        }
        return return this.antUseCase
    }
}