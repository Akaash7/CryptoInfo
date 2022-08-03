package com.akash.cryptoinfo.presentation.coin_list

import com.akash.cryptoinfo.domain.model.Coin

data class CoinListState(
    val isLoading : Boolean= false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
) {
}