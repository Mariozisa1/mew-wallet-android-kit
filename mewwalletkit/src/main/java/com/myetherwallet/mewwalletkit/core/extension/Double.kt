package com.myetherwallet.mewwalletkit.core.extension

import java.math.BigDecimal
import java.math.BigInteger

/**
 * Created by BArtWell on 22.10.2019.
 */

fun Double.toTokenBalance(decimals: Int = 18): BigInteger = BigDecimal.valueOf(this).multiply(BigDecimal.TEN.pow(decimals)).toBigInteger()
