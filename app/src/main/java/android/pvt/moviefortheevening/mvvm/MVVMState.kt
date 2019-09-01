package android.pvt.moviefortheevening.mvvm

import android.pvt.moviefortheevening.entity.Films

sealed class MVVMState {
    class Data(val films: Films):MVVMState()
    class Error(throwable: Throwable):MVVMState()
}