package app.aihunt.movie.di

import app.aihunt.movie.data.repository.MovieRepositoryImpl
import app.aihunt.movie.domain.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun providesMovieRepository(movieRepositoryImp: MovieRepositoryImpl): MovieRepository


}