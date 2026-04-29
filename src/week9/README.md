# Week 9 Learning Content: equals, hashCode, Objects, and Wrapper Classes

This README covers the key learning topics for Week 9: overriding `equals()` and `hashCode()` methods, using the `Objects` utility class, and working with Wrapper classes for primitive types.

## 1. Overriding equals() and hashCode()

### Purpose
- `equals()`: Checks for logical equality between objects.
- `hashCode()`: Returns a hash code value for the object, used in hash-based collections (e.g., HashMap, HashSet).
- **Contract**: If two objects are equal (via `equals()`), they must have the same `hashCode()`. Not equal does not guarantee different hash codes.

### Requirements for Student Class
- Fields: `id` (int), `name` (String)
- `equals()`: Compare based on `id` only.
- `hashCode()`: Use `Objects.hash(id)`.

### Example Implementation (from Student.java)
```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Student student = (Student) obj;
    return id == student.id;
}

@Override
public int hashCode() {
    return Objects.hash(id);
}
```

### Execution Logic
- Create two `Student` objects with the same `id` (e.g., 1) but different `name`s.
- `==` comparison: `false` (different references).
- `equals()` comparison: `true` (same `id`).

## 2. Objects Utility Class

### Key Methods
- `Objects.equals(a, b)`: Null-safe equality check (handles null values).
- `Objects.hash(values...)`: Generates a hash code from multiple values.
- `Objects.toString(obj)`: Null-safe toString.
- `Objects.requireNonNull(obj)`: Throws NullPointerException if null.

### Usage in hashCode()
- Instead of manual hashing, use `Objects.hash(id)` for consistency and null-safety.

## 3. Wrapper Classes

### Overview
- Wrapper classes (e.g., `Integer`, `Double`, `Boolean`) wrap primitive types (`int`, `double`, `boolean`) into objects.
- Allow primitives to be used in collections or as objects.

### Conversion Methods
- **parseXXX(String)**: Converts string to primitive (e.g., `Integer.parseInt("123")` → `int 123`).
- **valueOf(String)**: Converts string to Wrapper object (e.g., `Integer.valueOf("123")` → `Integer 123`).

### Comparison
- `==`: Compares references (for Wrappers, usually `false` for different objects, even if values are equal).
- `equals()`: Compares values (returns `true` if values are equal).

### Example (from StringConversionExample.java)
```java
String input = "123";
int primitive = Integer.parseInt(input);  // int 123
Integer wrapper = Integer.valueOf(input); // Integer 123

Integer wrapper2 = Integer.valueOf(input); // Another Integer 123
System.out.println(wrapper == wrapper2);     // false (different objects)
System.out.println(wrapper.equals(wrapper2)); // true (same value)
```

### Exception Handling
- `NumberFormatException`: Thrown if the string cannot be parsed (e.g., `Integer.parseInt("abc")`).
- Always wrap conversions in try-catch.

### Supported Types
- `Integer` for `int`
- `Double` for `double`
- `Boolean` for `boolean`
- Others: `Long`, `Float`, `Character`, `Byte`, `Short`

## Running Examples
- Compile: `javac week6\*.java`
- Run Student demo: `java week6.Student`
- Run conversion demo: `java week6.StringConversionExample`

## Notes
- No Lombok used; all overrides are manual.
- Focus on understanding object equality vs. reference equality.
- Practice with different inputs to handle exceptions.