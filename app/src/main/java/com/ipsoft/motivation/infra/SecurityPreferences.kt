package com.ipsoft.motivation.infra

import android.content.Context

/**
 *
 *  Author:     Anthoni Ipiranga
 *  Project:    Motivation
 *  Date:       23/01/2021
 */

class SecurityPreferences(ctx: Context) {

    private val sharedPreferences = ctx.getSharedPreferences("motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, value: String) {

        sharedPreferences.edit().putString(key, value).apply()

    }

    fun getString(key: String) {

        sharedPreferences.getString(key, "")

    }


}