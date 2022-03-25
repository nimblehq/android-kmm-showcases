package co.nimblehq.kmm.showcase.domain

import co.nimblehq.kmm.showcase.data.RepositoryImpl

interface GetJobDetailUseCase {
    suspend fun execute(): JobDetailUiModel
}

class GetJobDetailUseCaseImpl : GetJobDetailUseCase {

    private val repository = RepositoryImpl()

    override suspend fun execute(): JobDetailUiModel {
        return repository.getJobDetail().toUiModel()
    }
}