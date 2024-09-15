package com.syedbipul.dependency_injection

import dagger.Module
import dagger.Provides
import javax.inject.Inject


class CoffeeMaker @Inject constructor(val heater: Heater, val pump: Pump) {
    fun makeCoffee() = "${heater.heatWater()} & ${pump.pumpWater()}"
}


@Module
class CoffeeMakerModule {
    @Provides
    fun provideHeater() = Heater()

    @Provides
    fun providePump() = Pump()
//
//    @Provides
//    fun provideCoffeeMaker(heater: Heater, pump: Pump) = CoffeeMaker(heater, pump)
}
