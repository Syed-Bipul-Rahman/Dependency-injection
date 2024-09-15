package com.syedbipul.dependency_injection
import dagger.Module
import dagger.Provides
class CoffeeMaker(val heater: Heater, val pump: Pump) {
    fun makeCoffee() = "${ heater.heatWater() } & ${pump.pumpWater()}"
}
class CoffeeMakerModule{
    @Provides
    fun provideHeater() = Heater()
    @Provides
    fun providePump() = Pump()
}