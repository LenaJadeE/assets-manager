# The Persona pattern

### My prompt

````text
Context: I'm a student in a Java course at Year Up. I'm learning inheritance,
abstract classes and polymorphism. Below are my Asset class (an abstract class)
and my House class (it extends Asset) from my assets-manager project. The
program keeps a list of assets and prints what each one is worth.

Task: Review these two classes the way a senior Java developer would in a code
review. Look at how the abstract class and the child work together, and at
naming, structure and anything that could confuse another developer.

Constraints: Do not rewrite, fix or show any of my code. Only ask me questions
and make observations. Keep it at the level of what I've learned so far, and
don't suggest features I haven't covered.

Format: A numbered list of 3 to 5 points. For each point, give one sentence on
what you noticed and one sentence on why it matters. End with one question for
me to think about.

Asset.java:

```java
package com.pluralsight;

import java.math.BigDecimal;

public abstract class Asset {

    private String description;
    private String dateAcquired;
    private BigDecimal originalCost;

    public Asset(String description, String dateAcquired, BigDecimal originalCost) {
        setDescription(description);
        setDateAcquired(dateAcquired);
        setOriginalCost(originalCost);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(String dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public BigDecimal getOriginalCost() {
        return originalCost;
    }

    public void setOriginalCost(BigDecimal originalCost) {
        this.originalCost = originalCost;
    }

    public abstract BigDecimal getValue();
}
```

House.java:

```java
package com.pluralsight;

import java.math.BigDecimal;

public class House extends Asset {

    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, BigDecimal originalCost,
                 String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        setAddress(address);
        setCondition(condition);
        setSquareFoot(squareFoot);
        setLotSize(lotSize);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    @Override
    public BigDecimal getValue() {
        BigDecimal pricePerSquareFoot;

        if (getCondition() == 1) {
            pricePerSquareFoot = new BigDecimal("180");
        } else if (getCondition() == 2) {
            pricePerSquareFoot = new BigDecimal("130");
        } else if (getCondition() == 3) {
            pricePerSquareFoot = new BigDecimal("90");
        } else {
            pricePerSquareFoot = new BigDecimal("80");
        }

        BigDecimal houseValue = pricePerSquareFoot.multiply(BigDecimal.valueOf(getSquareFoot()));
        BigDecimal lotValue = new BigDecimal("0.25").multiply(BigDecimal.valueOf(getLotSize()));

        return houseValue.add(lotValue);
    }
}
```
````

### The four pieces

- **Context:** tells the AI who I am and what the code is, so the answer fits my level.
- **Task:** what I want it to do. "The way a senior Java developer would" is the persona.
- **Constraints:** what it must not do. It can't rewrite my code. It can only ask questions and make observations.
- **Format:** the shape of the answer, so it's short and easy to use.

### The feedback I got

1. **What I noticed:** Making `getValue()` abstract in `Asset` is a good design choice, because any class that extends `Asset` has to decide how it is valued.
   **Why it matters:** That's what lets your program keep a list of `Asset` objects and call `getValue()` on each one without knowing whether it's a `House` or something else.

2. **What I noticed:** The `Asset` constructor calls its own public setters, and a subclass is allowed to override those setters.
   **Why it matters:** If a child class ever overrides one, the child's version would run inside `super(...)`, before the child's own fields have been set, and that kind of bug is hard to track down.

3. **What I noticed:** `condition` is an `int`, and nothing in the code says what 1, 2 or 3 means, or whether 1 is the best or the worst.
   **Why it matters:** Someone reading `setCondition(2)` has to guess, and the final `else` quietly gives an $80 rate to any other number, including 0, -5 or 99, so a typo gives a wrong value instead of an error.

4. **What I noticed:** `squareFoot` sounds like a unit of measure rather than an amount, and `lotSize` doesn't say what unit it's in.
   **Why it matters:** The 0.25 multiplier only gives a sensible number if the lot is measured in square feet, so if another developer enters acres, every house value will be wrong with no warning.

5. **What I noticed:** The numbers that drive the valuation (180, 130, 90, 80 and 0.25) appear only inside `getValue()`, with no names or comments.
   **Why it matters:** A teammate who needs to change a price, or check why a house is worth what it is, has to read through the whole method to work out what each number stands for.

### Do I agree?

I agree with most of it. Points 1 and 3 made the most sense to me. Making
`getValue()` abstract is what lets my loop call `getValue()` on every asset
without caring what kind it is. And it's true that `condition` is just a
number: nothing tells you what 1 means, and any other number quietly gets the
$80 rate. I'm less sure about point 2. It happened because I call the setters
inside the constructors, and I'd have to think about that more before changing
it.

### The one change I made

I picked point 5, the unnamed numbers in `House.getValue()`. I gave the lot
price a name, `lotPricePerSquareFoot`, so the method says what 0.25 means
instead of leaving it as a bare number. I chose it because it's a small change
that doesn't change how the program works, and my results stayed the same.
Commit message: `Name the lot price in House.getValue`