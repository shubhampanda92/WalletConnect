package com.hike.walletconnect

/**
 * Created by Shubham Panda on 20/08/21.
 * Copyright (c) 2021 Hike. All rights reserved.
 */
public fun ByteArray.toHexString(prefix: String = "0x"): String = encode(this, prefix)
private const val CHARS = "0123456789abcdef"
public fun ByteArray.toNoPrefixHexString(): String = toHexString(prefix = "")

/**
 * Encodes the given byte value as an hexadecimal character.
 */
public fun encode(value: Byte): String {
    return CHARS[value.toInt().shr(4) and 0x0f].toString() + CHARS[value.toInt().and(0x0f)].toString()
}

/**
 * Encodes the given byte array value to its hexadecimal representations, and prepends the given prefix to it.
 *
 * Note that by default the 0x prefix is prepended to the result of the conversion.
 * If you want to have the representation without the 0x prefix, pass to this method an empty prefix.
 */
public fun encode(value: ByteArray, prefix: String = "0x"): String {
    return prefix + value.joinToString("") { encode(it) }
}