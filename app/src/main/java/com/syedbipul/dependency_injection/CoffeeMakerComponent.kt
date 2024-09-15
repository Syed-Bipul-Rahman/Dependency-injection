package com.syedbipul.dependency_injection

import dagger.Component

@Component(modules = [CoffeeMakerModule::class])
interface CoffeeMakerComponent {

    fun getCoffeeMaker(): CoffeeMaker
}