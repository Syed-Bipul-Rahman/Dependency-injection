### Step-by-Step Guide to Manual Dependency Injection

Manual Dependency Injection is a design pattern where you provide the necessary dependencies of a class from outside the class rather than letting the class create them itself. This allows for more flexibility, easier testing, and looser coupling between components.

Here’s how to do manual dependency injection from the ground up using basic OOP principles:

---

### Step 1: **Understand Dependencies**

A dependency is a class or object required by another class to function. For example, consider a `Car` class that needs an `Engine` to run.

```kotlin
class Engine {
    fun start() {
        println("Engine started")
    }
}

class Car {
    private val engine = Engine()

    fun drive() {
        engine.start()
        println("Car is moving")
    }
}
```

In this example, `Car` creates its own `Engine`. This is **tight coupling** because `Car` is directly responsible for the creation of its `Engine`.

---

### Step 2: **Separate Dependency Creation**

To loosen the coupling, the `Car` should receive the `Engine` from outside rather than creating it internally. We can pass the `Engine` as a constructor parameter.

```kotlin
class Car(private val engine: Engine) {

    fun drive() {
        engine.start()
        println("Car is moving")
    }
}
```

Now, instead of creating an `Engine` inside `Car`, we inject the `Engine` into the `Car` when we create it.

---

### Step 3: **Injecting Dependencies Manually**

You can now manually inject dependencies when you create objects. Here’s how you would instantiate the `Car`:

```kotlin
fun main() {
    val engine = Engine()  // Manually create the Engine
    val car = Car(engine)  // Manually inject the Engine into the Car

    car.drive()
}
```

In this example, the `Car` doesn't know how to create an `Engine`; it only knows how to use one. The responsibility of creating the `Engine` has shifted outside of the `Car` class.

---

### Step 4: **Why Manual Dependency Injection is Useful**

- **Flexibility**: You can easily switch the dependency with a different one. For example, you can create a `MockEngine` class for testing purposes.

- **Testability**: Since the `Car` class doesn't create its own `Engine`, you can inject mock or stub implementations when testing.

- **Loose Coupling**: `Car` only depends on the behavior of `Engine`, not its implementation or creation.

---

### Step 5: **Advanced: Interface Injection**

To take this further, you can use interfaces to decouple the `Car` from specific implementations of `Engine`. This makes it even more flexible.

```kotlin
interface Engine {
    fun start()
}

class PetrolEngine : Engine {
    override fun start() {
        println("Petrol Engine started")
    }
}

class ElectricEngine : Engine {
    override fun start() {
        println("Electric Engine started")
    }
}

class Car(private val engine: Engine) {
    fun drive() {
        engine.start()
        println("Car is moving")
    }
}
```

Now, you can inject different implementations of `Engine`:

```kotlin
fun main() {
    val petrolEngine = PetrolEngine()
    val electricEngine = ElectricEngine()

    val petrolCar = Car(petrolEngine)
    petrolCar.drive()

    val electricCar = Car(electricEngine)
    electricCar.drive()
}
```

---

### Recap:
1. **Step 1**: Identify dependencies (e.g., `Car` depends on `Engine`).
2. **Step 2**: Move dependency creation outside the dependent class.
3. **Step 3**: Inject the dependencies manually via the constructor or setter methods.
4. **Step 4**: Optionally use interfaces to achieve looser coupling.

This is the essence of manual dependency injection. Later, you can move to frameworks like Dagger or Koin to automate this process.