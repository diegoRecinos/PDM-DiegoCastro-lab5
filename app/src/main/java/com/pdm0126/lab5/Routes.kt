package com.pdm0126.lab5

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable


@Serializable
sealed interface Routes: NavKey{

    @Serializable
    data object Screen1: Routes{

    }

    @Serializable
    data object TaskScreen: Routes{

    }

}


