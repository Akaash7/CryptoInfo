package com.akash.cryptoinfo.data.repository

import com.akash.cryptoinfo.data.remote.CoinPaprikaApi
import com.akash.cryptoinfo.data.remote.dto.CoinDTO
import com.akash.cryptoinfo.data.remote.dto.CoinDetailDTO
import com.akash.cryptoinfo.domain.model.Coin
import com.akash.cryptoinfo.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository{


    override suspend fun getCoins(): List<CoinDTO> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDTO {
        return api.getCoinById(coinId)
    }
}