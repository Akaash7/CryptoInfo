package com.akash.cryptoinfo.domain.use_case.get_coin

import androidx.lifecycle.SavedStateHandle
import com.akash.cryptoinfo.common.Resource
import com.akash.cryptoinfo.data.remote.dto.toCoin
import com.akash.cryptoinfo.data.remote.dto.toCoinDetail
import com.akash.cryptoinfo.domain.model.Coin
import com.akash.cryptoinfo.domain.model.CoinDetail
import com.akash.cryptoinfo.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId : String): Flow<Resource<CoinDetail>> = flow{
        try{
            emit(Resource.Loading())

            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        }
        catch (e:HttpException){
            emit(Resource.Error(e.localizedMessage?: "An unexpected error has occured"))
        }catch (e:IOException){
            emit(Resource.Error("Couldnt reach server."))
        }

    }
}