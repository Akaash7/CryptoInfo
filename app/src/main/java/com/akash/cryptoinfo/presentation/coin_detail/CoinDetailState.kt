package com.akash.cryptoinfo.presentation.coin_detail

import com.akash.cryptoinfo.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading : Boolean= false,
    val coin: CoinDetail? = null ,
    val error: String = ""
) {
}