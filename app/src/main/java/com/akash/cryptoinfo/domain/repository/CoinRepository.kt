package com.akash.cryptoinfo.domain.repository

import com.akash.cryptoinfo.data.remote.dto.CoinDTO
import com.akash.cryptoinfo.data.remote.dto.CoinDetailDTO
import com.akash.cryptoinfo.domain.model.CoinDetail

interface CoinRepository {

    suspend fun getCoins():List<CoinDTO>

    suspend fun getCoinById(coinId:String):CoinDetailDTO
}