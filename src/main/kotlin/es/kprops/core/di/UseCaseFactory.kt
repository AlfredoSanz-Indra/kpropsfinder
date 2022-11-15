package es.kprops.core.di

import es.kprops.domain.api.antcases.AntUseCase
import es.kprops.domain.api.propcases.PropUseCase
import es.kprops.domain.api.systemcases.SystemUseCase
import es.kprops.domain.usecases.antcases.AntUseCaseImpl
import es.kprops.domain.usecases.propcases.PropUseCaseImpl
import es.kprops.domain.usecases.systemcases.SystemUseCaseImpl


/**
 * @author Alfredo Sanz
 * @time 2022
 */
object UseCaseFactory {

    private lateinit var antUseCase: AntUseCase
    private lateinit var systemUseCase: SystemUseCase
    private lateinit var propUseCase: PropUseCase

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

    fun getPropUseCase(): PropUseCase {
        if (!this::propUseCase.isInitialized) {
            this.propUseCase = PropUseCaseImpl()
        }
        return this.propUseCase
    }
}